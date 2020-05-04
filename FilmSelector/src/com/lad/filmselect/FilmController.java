package com.lad.filmselect;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class FilmController {
	String getListView(String fileName) {
		List<Film> films = new FilmListDAO(fileName).getFilmList(); // TODO get file name from view
		StringBuilder sbfilm = new StringBuilder(100);
		for (Film aFilm : films) {
			sbfilm.append(aFilm.getFilmType() + ":" + aFilm.getFilmName() + ":" + aFilm.getReleaseYear() + ":"
					+ aFilm.getGenre() + ":" + aFilm.getUserRating() + "\n");
		}
		return sbfilm.toString();
	}

	String getTypeView(FilmType typeIn, String fileName) {
		List<Film> films = new FilmListDAO(fileName).searchByType(typeIn);
		Collections.sort(films);
		StringBuilder sbfilm = new StringBuilder(100);
		for (Film bFilm : films) {
			sbfilm.append(bFilm.getFilmName() + ":" + bFilm.getReleaseYear() + ":" + bFilm.getGenre() + ":"
					+ bFilm.getUserRating() + "\n");
		}
		return sbfilm.toString();

	}

	String getGenreView(Genre inputGenre, String fileName) {
		List<Film> films = new FilmListDAO(fileName).searchByGenre(inputGenre);
		Collections.sort(films);
		StringBuilder sbfilm = new StringBuilder(100);
		for (Film aFilm : films) {
			sbfilm.append(aFilm.getFilmName() + ":" + aFilm.getReleaseYear() + ":" + aFilm.getFilmType() + ":"
					+ aFilm.getUserRating() + "\n");
		}
		return sbfilm.toString();
	}

	String getRatingView(String rating, String fileName) {
		List<Film> films = new FilmListDAO(fileName).getFilmList();
		films = films.stream().filter(o -> o.getUserRating() >= Double.parseDouble(rating))
				.collect(Collectors.toList());
		StringBuilder sbrating = new StringBuilder(100);
		for (Film aFilm : films) {
			sbrating.append(aFilm.getFilmType() + ":" + aFilm.getFilmName() + ":" + aFilm.getReleaseYear() + ":"
					+ aFilm.getGenre() + ":" + aFilm.getUserRating() + "\n");
		}
		return sbrating.toString();
	}

	String getRandomView(String fileName) {
		List<Film> films = new FilmListDAO(fileName).getFilmList();
		Random rand = new Random();
		Film randFilm = films.get(rand.nextInt(films.size()));
		StringBuilder sbrandom = new StringBuilder(100);
		sbrandom.append(randFilm.getFilmType() + ":" + randFilm.getFilmName() + ":" + randFilm.getReleaseYear() + ":"
				+ randFilm.getGenre() + ":" + randFilm.getUserRating());
		return sbrandom.toString();
	}
}
