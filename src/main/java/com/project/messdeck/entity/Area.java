package com.project.messdeck.entity;

public enum Area {
	Omkar_Nagar(Pincode._410507, City.TALEGAON), Yashvant_Nagar(Pincode._410507,
			City.TALEGAON), Anand_Hotel(Pincode._410507, City.TALEGAON);

	private Pincode pincode;
	private City city;

	private Area(Pincode pincode, City city) {
		this.pincode = pincode;
		this.city = city;
	}

	public Pincode getPincode() {
		return pincode;
	}

	public City getCity() {
		return city;
	}

}
