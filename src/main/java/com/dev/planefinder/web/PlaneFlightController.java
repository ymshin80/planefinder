package com.dev.planefinder.web;

import java.time.Duration;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.planefinder.domain.Aircraft;
import com.dev.planefinder.service.PlaneFinderService;

import reactor.core.publisher.Flux;

@RestController
public class PlaneFlightController {

	private final PlaneFinderService pfService;
	
	
	public PlaneFlightController(PlaneFinderService pfService) {
		this.pfService = pfService;
	}
	
//	@GetMapping("/aircraft")
//	public Iterable<Aircraft> getCurrentAirCraft() {
//		return pfService.getAirCraft();
//	}
//	
	@GetMapping("/aircraft")
	public Flux<Aircraft> getCurrentAirCraft() {
		System.out.println("####################getCurrentAirCraft###################################");
		return pfService.getAirCraft();
		
		//Flux.fromIterable(pfService.getAirCraft()).delayElements(Duration.ofSeconds(1));
	}
	
	@MessageMapping("acstream")
	public Flux<Aircraft> getCurrentAcStream() {
		System.out.println("####################getCurrentAcStream###################################");
		
		return pfService.getAirCraft().concatWith(
			Flux.interval(Duration.ofSeconds(1))
			.flatMap(l -> pfService.getAirCraft()));
	}
	
}
