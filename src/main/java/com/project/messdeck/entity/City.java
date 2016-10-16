package com.project.messdeck.entity;

public enum City {

	TALEGAON(District.PUNE);

	private District district;

	City(District district) {
		this.district = district;
	}

	public District getDistrict() {
		return district;
	}

}
