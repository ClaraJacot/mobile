package main

import (
	"log"
	"net/http"
	"os"
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

	// var surfSpots []map[string]string
	// for _, record := range welcome.Records {
	// 	spot := make(map[string]string)
	// 	spot["SurfBreak"] = record.Fields.SurfBreak[0]
	// 	spot["Address"] = record.Fields.Address
	// 	spot["Photos"] = record.Fields.Photos[0].URL
	// 	surfSpots = append(surfSpots, spot)
	// }

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
