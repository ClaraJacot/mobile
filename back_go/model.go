package main

import (
	"encoding/json"
	"time"
)

func UnmarshalWelcome(data []byte) (Welcome, error) {
	var r Welcome
	err := json.Unmarshal(data, &r)
	return r, err
}

func (r *Welcome) Marshal() ([]byte, error) {
	return json.Marshal(r)
}

type Welcome struct {
	Records []Record `json:"records"`
}

type Record struct {
	ID          string    `json:"id"`
	CreatedTime time.Time `json:"createdTime"`
	Fields      Fields    `json:"fields"`
}

type Fields struct {
	SurfBreak               []string     `json:"Surf Break"`
	DifficultyLevel         int64        `json:"Difficulty Level"`
	Destination             string       `json:"Destination"`
	Geocode                 string       `json:"Geocode"`
	Influencers             []Influencer `json:"Influencers,omitempty"`
	MagicSeaweedLink        string       `json:"Magic Seaweed Link"`
	Photos                  []Photo      `json:"Photos"`
	PeakSurfSeasonBegins    string       `json:"Peak Surf Season Begins"`
	DestinationStateCountry string       `json:"Destination State/Country"`
	PeakSurfSeasonEnds      string       `json:"Peak Surf Season Ends"`
	Address                 string       `json:"Address"`
	Travellers              []string     `json:"Travellers,omitempty"`
}

type Photo struct {
	ID         string     `json:"id"`
	Width      int64      `json:"width"`
	Height     int64      `json:"height"`
	URL        string     `json:"url"`
	Filename   string     `json:"filename"`
	Size       int64      `json:"size"`
	Type       Type       `json:"type"`
	Thumbnails Thumbnails `json:"thumbnails"`
}

type Thumbnails struct {
	Small Full `json:"small"`
	Large Full `json:"large"`
	Full  Full `json:"full"`
}

type Full struct {
	URL    string `json:"url"`
	Width  int64  `json:"width"`
	Height int64  `json:"height"`
}

type Influencer string

const (
	Rec1PtbRPxhS8RRun Influencer = "rec1ptbRPxhS8rRun"
	RecD1Zp1PQYc8O7L2 Influencer = "recD1zp1pQYc8O7l2"
	RecSkJ4HuvzAUBrdd Influencer = "recSkJ4HuvzAUBrdd"
)

type Type string

const (
	ImageJPEG Type = "image/jpeg"
)
