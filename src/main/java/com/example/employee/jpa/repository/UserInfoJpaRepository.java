package com.example.employee.jpa.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.employee.jpa.model.UserInfo;
import com.example.employee.jpa.service.EmployeeJpaService;

public interface UserInfoJpaRepository extends JpaRepository<UserInfo, Integer>{
	Optional<UserInfo> findByName(String username);

	
	
}
