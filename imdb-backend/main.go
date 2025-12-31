package main

import (
	"fmt"
	"log"
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/wapekk/imdb-backend/config"
	"github.com/wapekk/imdb-backend/handlers"
	"github.com/wapekk/imdb-backend/models"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

var DB *gorm.DB

func main() {
	dsn := "host=localhost user=postgres password=Thowaff999 dbname=imdb-db-project port=5432 sslmode=disable"
	var err error

	config.DB, err = gorm.Open(postgres.Open(dsn), &gorm.Config{})
	if err != nil {
		log.Fatal("Gagal terhubung ke database:", err)
	}

	fmt.Println("Berhasil terhubung ke database")
	r := gin.Default()

	r.GET("/movies", func(c *gin.Context) {
		var movies []models.Movie
		if err := config.DB.Find(&movies).Error; err != nil {
			c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
			return
		}
		c.JSON(http.StatusOK, movies)
	})
	r.POST("/register", handlers.Register)
	r.POST("/login", handlers.Login)

	r.Run(":8080")
}
