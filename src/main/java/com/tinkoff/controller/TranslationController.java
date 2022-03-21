package com.tinkoff.controller;

import com.tinkoff.dto.RequestTranslationDTO;
import com.tinkoff.dto.ResponseTranslationDTO;
import com.tinkoff.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TranslationController {

	@Autowired
	TranslationService translationService;

	@PostMapping("/translate")
	public ResponseTranslationDTO translateText(@RequestBody RequestTranslationDTO request, HttpServletRequest req) {
		return translationService.translateText(request, req.getRemoteAddr());
	}
}
