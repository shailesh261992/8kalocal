package com.project.messdeck.propertyeditors;

import java.beans.PropertyEditorSupport;

import com.project.messdeck.entity.District;

public class DistrictEnumConverter extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		String capitalized = text.toUpperCase();
		District district = District.valueOf(capitalized);
		setValue(district);
	}
}