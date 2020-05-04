package com.lad.filmselect;

import java.util.Scanner;

class FilmView implements AutoCloseable {
	private Scanner scan;
	private String input;
	private String fileName = "FilmList.txt";

	void filmSelector() {
		this.displayOptions();
		scan = new Scanner(System.in);
		input = scan.nextLine();
		this.determineRoute(input);
		System.out.println("Thank you for using the film generator, we hope you enjoy your film! :)");
	}

	private void displayOptions() {
		System.out.println("Welcome to the film selector!");
		System.out.println("Enter 1 to display all films");
		System.out.println("Enter 2 to select a Genre");
		System.out.println("Enter 3 to search by Viewer Rating");
		System.out.println("Enter 4 to view films by film type");
		System.out.println("Enter 5 to choose a completely random film");
	}

	private void determineRoute(String input) {
		if (input.equals("1")) {
			this.displayAllMovies();
		} else if (input.equals("2")) {
			this.searchByGenre();
		} else if (input.equals("3")) {
			this.searchByRating();
		} else if (input.equals("4")) {
			this.searchByType();
		} else if (input.equals("5")) {
			this.randomFilm();
		} else {
			usageEscape();
		}
	}

	private void displayAllMovies() {
		String films = new FilmController().getListView(fileName);
		System.out.println(films);
	}

	private void searchByType() {
		System.out.println("Please enter a Type: Movie or Series");
		String typeIn = scan.nextLine();
		String typeList = null;
		if (typeIn.equalsIgnoreCase("movie")) {
			typeList = new FilmController().getTypeView(FilmType.MOVIE, fileName);
		} else if (typeIn.equalsIgnoreCase("series")) {
			typeList = new FilmController().getTypeView(FilmType.SERIES, fileName);
		} else {
			usageEscape();
		}
		System.out.println(typeList);

	}

	private void searchByGenre() {
		System.out.println("Please enter a Genre: ACTION, COMEDY, DRAMA");
		String genreIn = scan.nextLine();
		String genreList = null;
		if (genreIn.equalsIgnoreCase("action")) {
			genreList = new FilmController().getGenreView(Genre.ACTION, fileName);
		} else if (genreIn.equalsIgnoreCase("drama")) {
			genreList = new FilmController().getGenreView(Genre.DRAMA, fileName);
		} else if (genreIn.equalsIgnoreCase("comedy")) {
			genreList = new FilmController().getGenreView(Genre.COMEDY, fileName);
		} else {
			usageEscape();
		}
		System.out.println(genreList);
	}

	private void searchByRating() {
		System.out.println(
				"Please enter  1, 2, 3, 4, or 5 to indicate what the lowest rating you are interested in viewing is.");
		String rating = scan.nextLine();
		String ratingList = null;
		switch (rating) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
			ratingList = new FilmController().getRatingView(rating, fileName);
			break;
		default:
			usageEscape();

		}
		System.out.println(ratingList);

	}

	private void randomFilm() {
		String randFilm = new FilmController().getRandomView(fileName);
		System.out.println(randFilm);

	}

	private static void usageEscape() {
		System.out.println("USAGE");
		System.exit(0);
	}

	@Override
	public void close() {
		try {
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
