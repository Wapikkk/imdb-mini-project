package models

type User struct {
	ID          uint   `json:"id"`
	FullName    string `json:"full_name"`
	PhoneNumber string `json:"phone_number"`
	Email       string `json:"email"`
	Password    string `json:"password"`
}
