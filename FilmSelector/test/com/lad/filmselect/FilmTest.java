package com.lad.filmselect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//TODO JUnit testing
class FilmTest {
	List<Film> filmTest;
	Film film1;
	String fileName = "FilmList.txt";
	// FilmListDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		film1 = new Film("Jaws", "Movie", 1975, "Action", 5);
		FilmListDAO dao = new FilmListDAO("FilmList.txt");
			filmTest = dao.getFilmList();
		
	}

	@Test
	void testCompareTo() {
		Film expected = new Film("1917", "Movie", 2019, "Drama", 4);
		Collections.sort(filmTest);
		Film actual = filmTest.get(0);
		assertEquals(expected, actual);
	}
	@Test
	void testEquals() {
		assertTrue(film1.equals(filmTest.get(0)));
	}

	@Test
	void testCompare() {
		Film expected = new Film("Java Heat", "Movie", 2013, "Action", 2.5);
		Collections.sort(filmTest, film1);
		Film actual = filmTest.get(0);
		assertEquals(expected, actual);

	}

	@Test
	void testSortListByGenre() {
		Film expected = film1;
		Collections.sort(filmTest, film1.sortListByGenre());
//		for(Film film: filmTest) {
//			System.out.println(film);
//		}
		Film actual = filmTest.get(0);
		assertEquals(expected, actual);
	}
}
