package com.dev.planefinder.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import io.r2dbc.spi.ConnectionFactory;

@Component
public class DbConxInit {

	
	@Bean
	public ConnectionFactoryInitializer initializer(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(
			new ResourceDatabasePopulator(new ClassPathResource("schema.sql"))
		);
		
		
		return initializer;
		
	}
	
	
	public CommandLineRunner init(PlaneFinderRepository repo) {
		return args ->  {
			repo.save(new Aircraft("SAL001", "N12345", "SAL001", "LJ",
                    30000, 30, 300,
                    38.7209228, -90.4107416))
					.thenMany(repo.findAll())
                    .subscribe(System.out::println);
		};
	}
}
