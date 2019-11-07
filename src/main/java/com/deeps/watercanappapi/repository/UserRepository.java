package com.deeps.watercanappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.deeps.watercanappapi.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	@Query(" from UserDetails where mobileNumber = :mobileNumber and setPassword = :setPassword")
	UserDetails login(@Param("mobileNumber") Long mobileNumber, @Param("setPassword") String setPassword);

	@Query(" from UserDetails where mobileNumber = :mobileNumber")
	UserDetails findByMobileNumber(@Param("mobileNumber") Long number);
	
	@Query(" from UserDetails where mobileNumber = :mobileNumber")
	UserDetails findById(@Param("mobileNumber") Long number);
	
}
