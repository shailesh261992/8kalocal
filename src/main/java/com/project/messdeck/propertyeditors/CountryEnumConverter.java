package com.project.messdeck.propertyeditors;

import java.beans.PropertyEditorSupport;

import com.project.messdeck.entity.Country;

public class CountryEnumConverter extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		String capitalized = text.toUpperCase();
		Country country = Country.valueOf(capitalized);
		setValue(country);
	}
}