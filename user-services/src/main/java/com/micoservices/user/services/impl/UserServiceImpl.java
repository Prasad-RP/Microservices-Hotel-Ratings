package com.micoservices.user.services.impl;

import static com.micoservices.user.dto.mapper.UserMapper.TO_USER;
import static com.micoservices.user.dto.mapper.UserMapper.TO_USERS;
import static com.micoservices.user.dto.mapper.UserMapper.TO_USER_MASTER;
import static com.micoservices.user.utils.StringUtils.generateRandomUserName;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.micoservices.user.dto.User;
import com.micoservices.user.entity.UserMaster;
import com.micoservices.user.exception.ResourceNotFoundException;
import com.micoservices.user.repository.UserRepository;
import com.micoservices.user.services.UserServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserServices {

	private final UserRepository userRepository;

	@Override
	public Optional<User> save(User user) {
		Optional<UserMaster> master = TO_USER_MASTER.apply(user);
		// generating random and unique user ID
		master.get().setUserId(generateRandomUserName());
		return TO_USER.apply(userRepository.save(master.get()));
	}

	@Override
	public Optional<User> update(User user) {
		existbyId(user.getUserId());
		Optional<UserMaster> master = TO_USER_MASTER.apply(user);
		return TO_USER.apply(userRepository.save(master.get()));
	}

	@Override
	public Optional<User> getById(String userId) {
		return TO_USER.apply(userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User ID", userId)));
	}

	public Boolean delete(String userId) {
		existbyId(userId);
		userRepository.deleteById(userId);
		return true;
	}

	@Override
	public Boolean existbyId(String userId) {
		if (userRepository.existsById(userId))
			return true;
		else
			throw new ResourceNotFoundException("User", "User ID", userId);
	}

	@Override
	public List<User> getAll() {
		return TO_USERS.apply(userRepository.findAll());
	}

}
