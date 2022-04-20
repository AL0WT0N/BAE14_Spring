package com.qa.baespring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.baespring.domain.User;

@Repository
public interface UserRepo extends JpaRepository <User, Long> {

}