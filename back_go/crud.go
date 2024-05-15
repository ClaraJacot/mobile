package main

import (
	"encoding/json"
	"fmt"
	"log"
	"net/http"
	"os"

	"github.com/gorilla/mux"
)

func getAllSpots(w http.ResponseWriter, r *http.Request) {
	data, err := os.ReadFile("spots.json")
	if err != nil {
		log.Printf("Error reading JSON file: %v\n", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}

	welcome, err := UnmarshalWelcome(data)
	if err != nil {
		log.Printf("Erreur du Unmarshal: %v\n", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}

	var surfSpots Welcome
	surfSpots.Records = make([]Record, len(welcome.Records))

	for i, record := range welcome.Records {
		surfSpots.Records[i].ID = record.ID
		surfSpots.Records[i].Fields.SurfBreak = []string{record.Fields.SurfBreak[0]}
		surfSpots.Records[i].Fields.Address = record.Fields.Address
		surfSpots.Records[i].Fields.Photos = []Photo{{URL: record.Fields.Photos[0].URL}}
	}

	responseData, err := json.Marshal(surfSpots)
	if err != nil {
		log.Printf("Erreur d'encodage en json: %v\n", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}

	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(http.StatusOK)
	w.Write(responseData)
}

func getOneSpot(w http.ResponseWriter, r *http.Request) {

	vars := mux.Vars(r)
	id := vars["id"]
	fmt.Printf("Id recup:", id)
	if id == "" {
		http.Error(w, "ID manquant", http.StatusBadRequest)
		return
	}

	data, err := os.ReadFile("spots.json")
	if err != nil {
		log.Printf("Error reading JSON file: %v\n", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}

	welcome, err := UnmarshalWelcome(data)
	if err != nil {
		log.Printf("Erreur du Unmarshal: %v\n", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}

	var spot *Record
	for _, record := range welcome.Records {
		if record.ID == id {
			spot = &record
			break
		}
	}

	if spot == nil {
		http.Error(w, "Spot non trouvé", http.StatusNotFound)
		return
	}

	responseData, err := json.Marshal(spot)
	if err != nil {
		log.Printf("Erreur d'encodage en json: %v\n", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}

	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(http.StatusOK)
	w.Write(responseData)
}
