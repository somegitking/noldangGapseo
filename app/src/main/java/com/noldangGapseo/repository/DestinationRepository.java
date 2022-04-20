package com.noldangGapseo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.noldangGapseo.domain.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Integer> {
}
