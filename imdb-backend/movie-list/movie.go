package main

import (
	"fmt"
	"log"
	"net/http"

	"github.com/gin-gonic/gin"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

type Movie struct {
	ID          uint    `json:"id"`
	Title       string  `json:"title"`
	Overview    string  `json:"overview"`
	PosterPath  string  `json:"poster_path" gorm:"column:poster_path"`
	VoteAverage float32 `json:"vote_average" gorm:"column:vote_average"`
}

var DB *gorm.DB

func main() {
	dsn := "host=localhost user=postgres password=Thowaff999 dbname=imdb-db-project port=5432 sslmode=disable"
	var err error
	DB, err = gorm.Open(postgres.Open(dsn), &gorm.Config{})
	if err != nil {
		log.Fatal("Failed to connect to database:", err)
	}

	fmt.Println("Berhasil terhubung ke database")

	r := gin.Default()
	r.GET("/movies", func(c *gin.Context) {
		var movies []Movie
		if err := DB.Find(&movies).Error; err != nil {
			c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
			return
		}
		c.JSON(http.StatusOK, movies)
	})

	r.Run(":8080")
}
