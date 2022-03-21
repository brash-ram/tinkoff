package com.tinkoff.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "request")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String request;
	String response;
	String ip;
	String fromLanguage;
	String toLanguage;
	@Basic
	Date time;

	public Request(String request, String response, String ip, String fromLanguage, String toLanguage, Date time) {
		this.request = request;
		this.response = response;
		this.ip = ip;
		this.fromLanguage = fromLanguage;
		this.toLanguage = toLanguage;
		this.time = time;
	}


	public Request() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getFromLanguage() {
		return fromLanguage;
	}

	public void setFromLanguage(String fromLanguage) {
		this.fromLanguage = fromLanguage;
	}

	public String getToLanguage() {
		return toLanguage;
	}

	public void setToLanguage(String toLanguage) {
		this.toLanguage = toLanguage;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}