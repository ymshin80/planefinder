package com.dev.planefinder.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.dev.planefinder.domain.InputRequestInfo;
import com.dev.planefinder.domain.OutputResponseInfo;
import com.dev.planefinder.utils.EnableRestCallLogs;


@RestController
@RequestMapping("/api")
public class HomeController {

	
	@GetMapping("/testGet/{name}")
	@ResponseStatus(HttpStatus.OK)
	@EnableRestCallLogs
	public OutputResponseInfo testGetEndpoint(@PathVariable String name) {
		
		OutputResponseInfo result = new OutputResponseInfo();
		
		result.setResponse_state(HttpStatus.OK);
		Map<String, Object> m = new HashMap<>();
		m.put("ID", Integer.valueOf(1));
		m.put("Input_Name", name);
		
		result.setPayload(m);
		
		
		return result;
	}
	
	@PostMapping("/testPost")
	@ResponseStatus(HttpStatus.CREATED)
	@EnableRestCallLogs
	public OutputResponseInfo testPostEndpoint(@RequestBody InputRequestInfo info) {
		OutputResponseInfo result = new OutputResponseInfo();
		result.setResponse_state(HttpStatus.CREATED);
		Map<String, Object> m = new HashMap<>();
		
		m.put("parameters", info);
		result.setPayload(m);
		
		return result;
	}
	
}
