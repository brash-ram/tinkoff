package com.tinkoff.dto;

import java.util.List;
import java.util.Map;

public class ResponseYandexDTO {
	List<Map<String, String>> translations;

	public ResponseYandexDTO(List<Map<String, String>> translations) {
		this.translations = translations;
	}

	public ResponseYandexDTO() {
	}

	public List<Map<String, String>> getTranslations() {
		return translations;
	}

	public void setTranslations(List<Map<String, String>> translations) {
		this.translations = translations;
	}
}
