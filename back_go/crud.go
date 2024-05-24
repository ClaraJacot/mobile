package main

import (
	"encoding/json"
	"log"
	"math/rand"
	"net/http"
	"os"
	"strconv"
	"time"
)

func addOneSpot(w http.ResponseWriter, r *http.Request) {
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
	var surfSpot Record
	_ = json.NewDecoder(r.Body).Decode(&surfSpot)
	log.Printf(" toto %s\n", r.Body)
	log.Printf("tata %v\n", surfSpot)
	surfSpot.ID = strconv.Itoa(rand.Intn(1000000))
	surfSpot.CreatedTime = time.Now()
	welcome.Records = append(welcome.Records, surfSpot)

	newWelcome, err := welcome.Marshal()
	if err != nil {
		log.Printf("Erreur d'encodage en json: %v\n", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}

	err = os.WriteFile("spots.json", newWelcome, 0664)
	if err != nil {
		log.Printf("Erreur d'ecriture de fichier json: %v\n", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}
	responseData, err := json.Marshal(surfSpot)
	if err != nil {
		log.Printf("Erreur d'encodage en json: %v\n", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}

	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(http.StatusOK)
	w.Write(responseData)

	/* var welcome Welcome
	var surfSpot Record
	_ = json.NewDecoder(r.Body).Decode(&surfSpot)
	surfSpot.ID = strconv.Itoa(rand.Intn(1000000))
	surfSpot.CreatedTime = time.Now()
	welcome.Records = append(welcome.Records, surfSpot)
	json.NewEncoder(w).Encode(surfSpot)

	w.Header().Set("Content-Type", "application/json")*/
}

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

	responseData, err := welcome.Marshal()
	if err != nil {
		log.Printf("Erreur d'encodage en json: %v\n", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}

	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(http.StatusOK)
	w.Write(responseData)
}
