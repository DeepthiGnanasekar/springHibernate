package com.deeps.watercanappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.deeps.watercanappapi.model.ReserveDetails;

@Repository

public interface ReserveCanRepository extends JpaRepository<ReserveDetails, String> {

	@Query(" from ReserveDetails where Mobile_Number = :Mobile_Number order by id desc")
	int findByOrderId(long Mobile_Number);
	
	@Query(" from ReserveDetails where id = :id")
    ReserveDetails findByReserveId(@Param("id")int id);
	
	@Query(" from ReserveDetails where id = :id")
    ReserveDetails findByReserveOrderId(@Param("id")int id);
	
	@Query(" from ReserveDetails where id = :id")
	ReserveDetails findByCancelId(@Param("id")int id);

	@Query(" from ReserveDetails where number = :number and status != 'Ordered' ")
	ReserveDetails findByRepeatReserveId(@Param("number")long number);

	@Query(" from ReserveDetails where number = :number and reservedOrder = 0")
	Integer findByRepeatId(@Param("number")long number);
}
