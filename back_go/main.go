package main

import (
	"fmt"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

func main() {
	router := mux.NewRouter().StrictSlash(true)
	router.HandleFunc("/spots", getAllSpots).Methods("GET")
	fmt.Print("Gooooooo")

	log.Fatal(http.ListenAndServe(":8080", router))
}
