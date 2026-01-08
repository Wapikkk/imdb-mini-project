package handlers

import (
	"encoding/json"
	"github.com/gin-gonic/gin"
	"github.com/wapekk/imdb-backend/models"
	"net/http"
)

func GetMovies(c *gin.Context) {
	apiKey := "5edd888394a11ec849afd01f0949cbdc"
	url := "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey

	resp, err := http.Get(url)
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": "Gagal terhubung ke TMDB"})
		return
	}
	defer resp.Body.Close()

	var tmdbResponse struct {
		Results []models.Movie `json:"results"`
	}

	if err := json.NewDecoder(resp.Body).Decode(&tmdbResponse); err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": "Gagal membaca data"})
		return
	}

	c.JSON(http.StatusOK, tmdbResponse.Results)
}
