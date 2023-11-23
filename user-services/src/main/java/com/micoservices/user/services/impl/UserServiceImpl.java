package com.micoservices.user.services.impl;

import static com.micoservices.user.dto.mapper.UserMapper.TO_USER;
import static com.micoservices.user.dto.mapper.UserMapper.TO_USERS;
import static com.micoservices.user.dto.mapper.UserMapper.TO_USER_MASTER;
import static com.micoservices.user.utils.StringUtils.generateRandomUserName;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micoservices.user.dto.Hotel;
import com.micoservices.user.dto.Ratings;
import com.micoservices.user.dto.User;
import com.micoservices.user.entity.UserMaster;
import com.micoservices.user.exception.ResourceNotFoundException;
import com.micoservices.user.repository.UserRepository;
import com.micoservices.user.services.UserServices;
import com.micoservices.user.utils.JsonUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserServices {

	private final UserRepository userRepository;
	private final RestTemplate restTemplate;

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

	@SuppressWarnings({ "rawtypes" })
	@Override
	public Optional<User> getById(String userId) {
		Optional<User> userInfo = TO_USER.apply(userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User ID", userId)));
		try {
			
			/* Getting user ratings with rest template
			 (can be done with rest client but need higher versions).
			URL http://localhost:9193/api/v1/ratings/user can also be work ,
			but when ports get changed , we also need to change the urls .
			So making it dynamic by Using Application Name , since It is 
			registered on Service Registry(Eureka) 
			*/
			
			HashMap ratings = restTemplate.getForObject("http://RATING-SERVICE/api/v1/ratings/user/" + userId,
					HashMap.class);
			List<Ratings> ratingList = JsonUtils.convertJsonToList(ratings.get("DATA"), Ratings.class);

			// Setting each hotel to its associated ratings
			ratingList.forEach(p -> {
				HashMap map = restTemplate.getForObject("http://HOTEL-SERVICE/api/v1/hotels/" + p.getHotelId(),
						HashMap.class);
				Hotel hotel = JsonUtils.convertJsonToObject(map.get("DATA"), Hotel.class);
				p.setHotel(hotel);
			});

			userInfo.ifPresent(u -> u.setRatings(ratingList));
			return userInfo;
		} catch (Exception e) {
			System.err.println(e);
		}
		return userInfo;
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

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List<User> getAll() {
		List<User> users = TO_USERS.apply(userRepository.findAll());
		users.forEach(p -> {
			HashMap ratings = restTemplate.getForObject("http://RATING-SERVICE/api/v1/ratings/user/" + p.getUserId(),
					HashMap.class);
			List<Ratings> ratingList = JsonUtils.convertJsonToList(ratings.get("DATA"), Ratings.class);

			// Setting each hotel to its associated ratings
			ratingList.forEach(r -> {
				HashMap map = restTemplate.getForObject("http://HOTEL-SERVICE/api/v1/hotels/" + r.getHotelId(),
						HashMap.class);
				Hotel hotel = JsonUtils.convertJsonToObject(map.get("DATA"), Hotel.class);
				r.setHotel(hotel);
			});
			p.setRatings(ratingList);
		});

		return users;
	}
}
