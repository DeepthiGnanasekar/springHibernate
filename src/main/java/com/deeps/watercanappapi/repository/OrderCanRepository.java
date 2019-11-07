package com.deeps.watercanappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.deeps.watercanappapi.model.OrderDetails;

public interface OrderCanRepository extends JpaRepository<OrderDetails, String> {

	@Query(" from OrderDetails where Mobile_Number = :Mobile_Number order by id desc")
	int findByOrderId(long Mobile_Number);

	@Query(" from OrderDetails where id = :id")
	OrderDetails findById(@Param("id")int id);
}
