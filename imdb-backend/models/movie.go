package models

type Movie struct {
	ID          uint    `json:"id"`
	Title       string  `json:"title"`
	Overview    string  `json:"overview"`
	PosterPath  string  `json:"poster_path" gorm:"column:poster_path"`
	VoteAverage float32 `json:"vote_average" gorm:"column:vote_average"`
}
