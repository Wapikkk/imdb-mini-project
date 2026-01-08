package main

import (
	"fmt"
	"log"

	"github.com/gin-gonic/gin"
	"github.com/wapekk/imdb-backend/config"
	"github.com/wapekk/imdb-backend/handlers"
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

	r.GET("/movies", handlers.GetMovies)
	r.POST("/register", handlers.Register)
	r.POST("/login", handlers.Login)

	r.Run(":8080")
}
