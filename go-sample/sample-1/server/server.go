package server

import (
	log "github.com/sirupsen/logrus"
	"net/http"
	"encoding/json"
)

type Sample1 struct {
	config *Sample1Config
}

type Sample1Config struct {
	Port     string
	UserName string
}

func NewSample1(config *Sample1Config) *Sample1 {
	return &Sample1{
		config: config,
	}
}

func (sample *Sample1) Start() {

	routes := make(map[string]func(w http.ResponseWriter, r *http.Request))
	routes["/api/user"] = sample.UserInfo

	for route, handler := range routes {
		http.Handle(route, http.HandlerFunc(handler))
	}

	port := sample.config.Port
	log.Infof("Server started on %s", port)

	err := http.ListenAndServe(port, nil)
	if err != nil {
		log.Fatal(err)
	}
}

func writeToResponse(v interface{}, w *http.ResponseWriter) {
	resultJson, _ := json.Marshal(v)
	(*w).Write(resultJson)
}
