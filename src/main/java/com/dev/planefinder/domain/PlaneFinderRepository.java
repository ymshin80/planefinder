package com.dev.planefinder.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlaneFinderRepository extends ReactiveCrudRepository<Aircraft, Long> {

}
