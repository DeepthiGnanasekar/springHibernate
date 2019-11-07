package com.deeps.watercanappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.deeps.watercanappapi.model.AdminDetails;

@Repository
public interface AdminRepository extends JpaRepository<AdminDetails, String> {

	@Query(" from AdminDetails where name = :name and password = :password")
	AdminDetails adminLogin(@Param("name") String name, @Param("password") String password);
}
