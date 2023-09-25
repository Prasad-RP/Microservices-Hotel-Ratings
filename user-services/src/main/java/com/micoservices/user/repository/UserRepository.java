package com.micoservices.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micoservices.user.entity.UserMaster;

@Repository
public interface UserRepository extends JpaRepository<UserMaster, String> {

}
