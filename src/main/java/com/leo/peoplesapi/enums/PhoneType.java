package com.leo.peoplesapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum PhoneType {

	HOME("Home"),
	MOBILE("Mobile"),
	COMMERCIAL("Commercial");
	
	private final String description;

	private PhoneType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
		
}
