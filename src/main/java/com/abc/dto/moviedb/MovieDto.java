package com.abc.dto.moviedb;

import java.util.List;

public class MovieDto {
	private boolean adult;

	private String backdrop_path;

	private String belongs_to_collection;

	private int budget;

	private List<Genres> genres;

	private String homepage;

	private int id;

	private String imdb_id;

	private String original_language;

	private String original_title;

	private String overview;

	private double popularity;

	private String poster_path;

	private List<Production_companies> production_companies;

	private List<Production_countries> production_countries;

	private String release_date; // TODO - was 'DateTime' type originally

	private int revenue;

	private int runtime;

	private List<Spoken_languages> spoken_languages;

	private String status;

	private String tagline;

	private String title;

	private boolean video;

	private double vote_average;

	private int vote_count;

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public boolean getAdult() {
		return this.adult;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public String getBackdrop_path() {
		return this.backdrop_path;
	}

	public void setBelongs_to_collection(String belongs_to_collection) {
		this.belongs_to_collection = belongs_to_collection;
	}

	public String getBelongs_to_collection() {
		return this.belongs_to_collection;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getBudget() {
		return this.budget;
	}

	public void setGenres(List<Genres> genres) {
		this.genres = genres;
	}

	public List<Genres> getGenres() {
		return this.genres;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getHomepage() {
		return this.homepage;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}

	public String getImdb_id() {
		return this.imdb_id;
	}

	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}

	public String getOriginal_language() {
		return this.original_language;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public String getOriginal_title() {
		return this.original_title;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getOverview() {
		return this.overview;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	public double getPopularity() {
		return this.popularity;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public String getPoster_path() {
		return this.poster_path;
	}

	public void setProduction_companies(List<Production_companies> production_companies) {
		this.production_companies = production_companies;
	}

	public List<Production_companies> getProduction_companies() {
		return this.production_companies;
	}

	public void setProduction_countries(List<Production_countries> production_countries) {
		this.production_countries = production_countries;
	}

	public List<Production_countries> getProduction_countries() {
		return this.production_countries;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getRelease_date() {
		return this.release_date;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getRevenue() {
		return this.revenue;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public int getRuntime() {
		return this.runtime;
	}

	public void setSpoken_languages(List<Spoken_languages> spoken_languages) {
		this.spoken_languages = spoken_languages;
	}

	public List<Spoken_languages> getSpoken_languages() {
		return this.spoken_languages;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getTagline() {
		return this.tagline;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public boolean getVideo() {
		return this.video;
	}

	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}

	public double getVote_average() {
		return this.vote_average;
	}

	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}

	public int getVote_count() {
		return this.vote_count;
	}
}
