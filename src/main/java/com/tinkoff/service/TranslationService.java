package com.tinkoff.service;

import com.tinkoff.dto.RequestTranslationDTO;
import com.tinkoff.dto.ResponseTranslationDTO;
import com.tinkoff.dto.ResponseYandexDTO;
import com.tinkoff.entity.Request;
import com.tinkoff.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class TranslationService {

	@Autowired
	RequestRepository requestRepository;

	private HttpEntity<Map<String, Object>> getBody(String word, String toLanguage) {
		String token = "t1.9euelZqemJeXlZXOjcqWmJeWx43Mk-3rnpWalMqMxs_MkJ3Ik46Ym5yNyMbl9PcQAw5u-e86MQKV3fT3UDELbvnvOjEClQ.WvNDAynua7-ot5tXw_I90ozbV6XYM1gIJP7CJCKo3U_XfFGHXsyaWDT5nlaNDAXQSa5wGtkqwZk84yAIMyckAA";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer "+token);

		List<String> list = new ArrayList<>();
		list.add(word);
		Map<String, Object> params = new HashMap<>();
		params.put("folderId", "b1gvai4mjrujrr1ng2ol");
		params.put ("texts", list);
		params.put("targetLanguageCode", toLanguage);

		return new HttpEntity<>(params, headers);
	}

	private ResponseYandexDTO translateWord(String word, String toLanguage) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Map<String, Object>> httpEntity = getBody(word, toLanguage);
		return restTemplate.postForObject("https://translate.api.cloud.yandex.net/translate/v2/translate", httpEntity,
				ResponseYandexDTO.class);
	}

	public ResponseTranslationDTO  translateText(RequestTranslationDTO request, String ip) {
		StringBuilder line = new StringBuilder();
		for (String word : request.getText().split(" ")) {
			line.append(translateWord(word, request.getToLanguage()).getTranslations().get(0).get("text")).append(" ");
		}
		Calendar cal = new GregorianCalendar();
		String fromLanguage = translateWord(request.getText().split(" ")[0],
				request.getToLanguage()).getTranslations().get(0).get("detectedLanguageCode");
		requestRepository.save(new Request(request.getText(), line.toString(), ip, fromLanguage, request.getToLanguage(), cal.getTime()));

		return new ResponseTranslationDTO(line.toString());
	}
}
