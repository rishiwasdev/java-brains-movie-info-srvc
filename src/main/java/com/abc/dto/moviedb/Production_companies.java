package com.abc.dto.moviedb;

public class Production_companies {
	private int id;

	private String logo_path;

	private String name;

	private String origin_country;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}

	public String getLogo_path() {
		return this.logo_path;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}

	public String getOrigin_country() {
		return this.origin_country;
	}
}