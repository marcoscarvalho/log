package com.marcoscarvalho;

import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController {

	private final Logger logg = LoggerFactory.getLogger(getClass().getName());
	public static final SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Log post(@RequestBody Log log, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws IOException {

		logg.info(log.toString());
		
		response.setStatus(201);

		return log;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Log get(HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws IOException {

		return new Log("INFO", "Ok");
	}
}
