package com.tinkoff.dto;

public class RequestTranslationDTO {
	String text;
	String toLanguage;

	public RequestTranslationDTO(String text, String toLanguage) {
		this.text = text;
		this.toLanguage = toLanguage;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getToLanguage() {
		return toLanguage;
	}

	public void setToLanguage(String toLanguage) {
		this.toLanguage = toLanguage;
	}
}
