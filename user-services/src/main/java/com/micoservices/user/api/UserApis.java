package com.micoservices.user.api;

import static com.micoservices.user.constants.ApiUrls.BASE_USER;
import static com.micoservices.user.constants.ApiUrls.DY_USER_ID;
import static com.micoservices.user.enums.ApiKey.DATA;
import static com.micoservices.user.enums.ApiKey.SUCCESS;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micoservices.user.dto.User;
import com.micoservices.user.services.UserServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_USER)
public class UserApis {

	private final UserServices userServices;

	@PostMapping
	ResponseEntity<Map<Object, Object>> createUser(@RequestBody User user) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, userServices.save(user));
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping(DY_USER_ID)
	ResponseEntity<Map<Object, Object>> getUserById(@PathVariable String userId) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, userServices.getById(userId));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping
	ResponseEntity<Map<Object, Object>> getAllUsers() {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, userServices.getAll());
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PutMapping
	ResponseEntity<Map<Object, Object>> updateUser(@RequestBody User user) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, userServices.update(user));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@DeleteMapping(DY_USER_ID)
	ResponseEntity<Map<Object, Object>> deleteUser(@PathVariable String userId) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, userServices.delete(userId));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
