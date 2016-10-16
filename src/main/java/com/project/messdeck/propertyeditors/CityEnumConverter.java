package com.project.messdeck.propertyeditors;

import java.beans.PropertyEditorSupport;

import com.project.messdeck.entity.City;

public class CityEnumConverter extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		String capitalized = text.toUpperCase();
		City city = City.valueOf(capitalized);
		setValue(city);
	}
}