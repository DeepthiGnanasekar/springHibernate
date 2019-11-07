package com.deeps.watercanappapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deeps.watercanappapi.model.Availability;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, String> {
	@Query(" from Availability")
	List<Availability> getStock();
}
