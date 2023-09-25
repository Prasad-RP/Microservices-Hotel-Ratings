package com.micoservices.user.services;

import java.util.List;
import java.util.Optional;

import com.micoservices.user.dto.User;

import jakarta.transaction.Transactional;

@Transactional
public interface UserServices {

	Optional<User> save(User user);

	Optional<User> update(User user);

	Optional<User> getById(String userId);

	List<User> getAll();

	Boolean delete(String userId);

	Boolean existbyId(String userId);

}
