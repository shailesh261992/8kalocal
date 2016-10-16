package com.project.messdeck.propertyeditors;

import java.beans.PropertyEditorSupport;

import com.project.messdeck.entity.State;

public class StateEnumConverter extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		String capitalized = text.toUpperCase();
		State state = State.valueOf(capitalized);
		setValue(state);
	}
}