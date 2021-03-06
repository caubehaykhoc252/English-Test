package com.english_test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.english_test.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	@Query(value = "select * from users where username = :username  and password = :password" , nativeQuery = true)
	UserModel checkLogin(@Param("username") String username , @Param("password") String password);

	@Query(value = "select * from users where username = :username ", nativeQuery = true)
	UserModel checkDuplicate(@Param("username") String username );
	
}
