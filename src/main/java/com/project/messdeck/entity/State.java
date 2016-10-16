package com.project.messdeck.entity;

public enum State {
	MAHARASHTRA(Country.INDIA);

	private Country country;

	private State(Country country) {
		this.country = country;
	}

	public Country getCountry() {
		return country;
	}

}
