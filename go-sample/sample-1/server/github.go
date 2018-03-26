package server

import (
	"net/http"
	"io/ioutil"
	"encoding/json"
	log "github.com/sirupsen/logrus"
)

type UserInfo struct {
	Code	int
	Msg 	string
	Data 	*UserInfoData
}

type UserInfoData struct {
	Id 				int
	Avatar_Url 		string
	Followers_Url	string
	Following_Url	string
	Gists_Url		string
	Repos_Url		string
}

func (sample *Sample1) UserInfo(w http.ResponseWriter, r *http.Request) {
	if r.Method != "GET" {
		writeToResponse(
			UserInfo{
				Code: 1,
				Msg: "Invalid method type",
				Data: nil,
			}, &w,
		)

		return
	}

	url := "https://api.github.com/users/"
	url += sample.config.UserName

	resp, err := http.Get(url)
	if err != nil {
		log.Error(err)

		writeToResponse(
			UserInfo{
				Code: 1,
				Msg: "Error",
				Data: nil,
			}, &w,
		)
		return
	}

	raw, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		log.Error(err)

		writeToResponse(
			UserInfo{
				Code: 1,
				Msg: "Error",
				Data: nil,
			}, &w,
		)
		return
	}
	defer resp.Body.Close()

	data := UserInfoData{}
	err = json.Unmarshal(raw, &data)
	if err != nil {
		log.Error(err)

		writeToResponse(
			UserInfo{
				Code: 1,
				Msg: "Error",
				Data: nil,
			}, &w,
		)
		return
	}

	writeToResponse(
		UserInfo{
			Code: 0,
			Msg: "SUCCESS",
			Data: &data,
		}, &w,
	)
}
