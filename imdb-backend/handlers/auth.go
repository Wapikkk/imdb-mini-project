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

	result := config.DB.Where("INSERT INTO users (full_name, phone_number, email, password) VALUES ($1, $2, $3, $4)",
		input.FullName, input.PhoneNumber, input.Email, string(hashedPassword))

	if result.Error != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": "Gagal menyimpan data"})
		return
	}

	c.JSON(http.StatusCreated, gin.H{"message": "Registrasi Berhasil", "success": true})
}

func Login(c *gin.Context) {
	var input models.User
	var user models.User

	if err := c.ShouldBindJSON(&input); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}

	if err := config.DB.Where("email = ?", input.Email).First(&user).Error; err != nil {
		c.JSON(http.StatusUnauthorized, gin.H{"error": "Email atau password salah", "success": false})
		return
	}

	if err := bcrypt.CompareHashAndPassword([]byte(user.Password), []byte(input.Password)); err != nil {
		c.JSON(http.StatusUnauthorized, gin.H{"error": "Email atau password salah", "success": false})
		return
	}

	c.JSON(http.StatusOK, gin.H{"message": "Login Berhasil", "succes": true})
}
