package com.lad.filmselect;

import java.util.Comparator;

public class Film implements Comparable<Film>, Comparator<Film> {
	private String filmName;
	private FilmType filmType;
	private int releaseYear;
	private Genre genre;
	private double userRating;

	Film(String filmNameIn, String filmTypeIn, int releaseYearIn, String genreIn, double userRatingIn) {
		this.setFilmType(filmTypeIn);
		this.setGenre(genreIn);
		this.setFilmName(filmNameIn);
		this.setReleaseYear(releaseYearIn);
		this.setGenre(genreIn);
		this.setUserRating(userRatingIn);
	}

	@Override
	public int compareTo(Film film) {
		return this.getFilmName().compareTo(film.getFilmName());
	}

	@Override
	public String toString() {
		return "Title: " + filmName + " Type: " + filmType + " Year: " + releaseYear + " Genre: " + genre + " Stars: "
				+ userRating;
	}

	@Override
	public int compare(Film film1, Film film2) {
		return (int) Double.compare(film1.getUserRating(), film2.getUserRating());
	}

	Comparator<Film> sortListByGenre() {
		return new Comparator<Film>() {
			@Override
			public int compare(Film film1, Film film2) {
				return film1.getGenre().compareTo(film2.getGenre());
			}
		};
	}


	public String getFilmName() {
		return filmName;
	}

	public FilmType getFilmType() {
		return filmType;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public Genre getGenre() {
		return genre;
	}

	public double getUserRating() {
		return userRating;
	}

	private void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	private void setFilmType(String filmType) {
		if (filmType.equalsIgnoreCase("movie")) {
			this.filmType = FilmType.MOVIE;
		}else if(filmType.equalsIgnoreCase("series")) {
			this.filmType = FilmType.SERIES;
		}
	}

	private void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	private void setGenre(String genre) {
		if(genre.equalsIgnoreCase("action")) {
			this.genre = Genre.ACTION;
		}else if(genre.equalsIgnoreCase("comedy")){
			this.genre =Genre.COMEDY;
		}else if(genre.equalsIgnoreCase("drama")) {
			this.genre = Genre.DRAMA;
		}

	}

	private void setUserRating(double userRating) {
		this.userRating = userRating;
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		result = prime * result + ((filmType == null) ? 0 : filmType.hashCode());
		result = prime * result + ((filmName == null) ? 0 : filmName.hashCode());
		result = prime * result + releaseYear;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Film other = (Film) obj;
		if (filmType == null) {
			if (other.filmType != null) {
				return false;
			}
		} else if (!filmType.equals(other.filmType)) {
			return false;
		}
		if (filmName == null) {
			if (other.filmName != null) {
				return false;
			}
		} else if (!filmName.equals(other.filmName)) {
			return false;
		}
		if (releaseYear != other.releaseYear) {
			return false;
		}
		return true;
	}

}
