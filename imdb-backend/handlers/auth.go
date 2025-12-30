package handlers

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/wapekk/imdb-backend/config"
	"github.com/wapekk/imdb-backend/models"
	"golang.org/x/crypto/bcrypt"
)

func Register(c *gin.Context) {
	var input models.User
	if err := c.ShouldBindJSON(&input); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}

	hashedPassword, _ := bcrypt.GenerateFromPassword([]byte(input.Password), bcrypt.DefaultCost)

	result := config.DB.Exec("INSERT INTO users (full_name, phone_number, email, password) VALUES ($1, $2, $3, $4)",
		input.FullName, input.PhoneNumber, input.Email, string(hashedPassword))

	if result.Error != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": "Gagal menyimpan data"})
		return
	}

	c.JSON(http.StatusCreated, gin.H{"message": "Registrasi Berhasil"})
}
