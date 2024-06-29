package com.pioneers.medmartbck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pioneers.medmartbck.model.User;

public interface UserRepository extends JpaRepository <User, Long>{

}
