package com.lad.filmselect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class FilmListDAO {
	private List<Film> filmList = new ArrayList<>();

	private String fileName;

	FilmListDAO(String fileNameIn) {
		this.fileName = fileNameIn;
		this.getFilmData();
	}

	private List<Film> getFilmData() {
		String line = null;
		try (BufferedReader filmReader = new BufferedReader(new FileReader(fileName))) {
			while ((line = filmReader.readLine()) != null) {
				String[] filmDetails = line.split(",");
				String filmName = filmDetails[0];
				String filmType = filmDetails[1];
				int year = Integer.parseInt(filmDetails[2]);
				String genre = filmDetails[3];
				double starRating = Double.parseDouble(filmDetails[4]);
				filmList.add(new Film(filmName, filmType, year, genre, starRating));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.unmodifiableList(filmList);
	}

	List<Film> getFilmList() {
		Collections.sort(filmList);
		List<Film> filmCopy = new ArrayList<>();
		filmCopy.addAll(Collections.unmodifiableList(filmList));
		return Collections.unmodifiableList(filmCopy);
	}

	List<Film> searchByGenre(Genre genreIn) {
		List<Film> filmsByGenre = this.getFilmList();
		return filmsByGenre.stream().filter(film -> film.getGenre().equals(genreIn)).collect(Collectors.toList());
	}

	List<Film> searchByType(FilmType typeIn) {
		List<Film> filmsByType = this.getFilmList();
		return filmsByType.stream().filter(film -> film.getFilmType().equals(typeIn)).collect(Collectors.toList());
	}

}
