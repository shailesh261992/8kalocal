package com.project.messdeck.entity;

public enum District {
	PUNE(State.MAHARASHTRA);

	private State state;

	private District(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

}
