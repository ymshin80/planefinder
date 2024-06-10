package com.dev.planefinder.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.dev.planefinder.domain.Aircraft;
import com.dev.planefinder.domain.PlaneFinderRepository;
import com.dev.planefinder.utils.FlightGernerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;


@Service
public class PlaneFinderService {

	private final PlaneFinderRepository repository;
	private final FlightGernerator generator;
	
	private URL acURL;
	private final ObjectMapper om;
	
	public PlaneFinderService(PlaneFinderRepository repository, FlightGernerator generator) throws MalformedURLException {
		this.repository = repository;
		this.generator = generator;
		acURL = new URL("http://192.168.1.139/ajax/aircraft");
		om = new ObjectMapper();
	}
	
	
	public Flux<Aircraft> getAirCraft() {
		//기존 소스 
//		List<AirCraft> positions = new ArrayList();
//		
//		
//		
//		JsonNode aircraftNodes = null;
//		
//		try {
//			aircraftNodes = om.readTree(acURL).get("aircraft");
//			
//			
//			aircraftNodes.iterator().forEachRemaining(node -> {
//				try {
//					positions.add(om.treeToValue(node, AirCraft.class));
//					
//				} catch (JsonProcessingException e) {
//					e.printStackTrace();
//				}
//			});
//			
//		} catch (IOException e) {
//			// TODO: handle exception
//			
//			return saveSamplePositions();
//		}
//		
//		if(positions.size() > 0) {
//			positions.forEach(System.out::println);
//			
//			repository.deleteAll();
//			
//			return repository.saveAll(positions);
//		} else {
		//  System.out.println("\n>>> No positions to report, generating and providing sample data.\n");
//			return saveSamplePositions();
//		}
		
		
		
		
		return repository.deleteAll()
				.thenMany(saveSamplePositions());
		
	}
//	private Iterable<Aircraft> saveSamplePositions() {
//		final Random rnd = new Random();
//		repository.deleteAll();
//		for (int i = 0; i < rnd.nextInt(10); i++) {
//			repository.save(generator.generate());
//		}
//
//		return repository.findAll();
//	}
	
	private Flux<Aircraft> saveSamplePositions() {
		final Random rnd = new Random();
		
		return Flux.range(1, rnd.nextInt(10))
				.map(i -> generator.generate())
				.flatMap(repository::save);
	}
}
