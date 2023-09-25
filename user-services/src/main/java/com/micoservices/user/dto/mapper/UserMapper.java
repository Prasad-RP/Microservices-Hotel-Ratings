package com.micoservices.user.dto.mapper;

import static com.micoservices.user.utils.FunctionUtil.evalMapper;
import static com.micoservices.user.utils.FunctionUtil.evalMapperCollection;
import static com.micoservices.user.utils.CollectionUtil.newList;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.micoservices.user.dto.User;
import com.micoservices.user.entity.UserMaster;

public class UserMapper {
	private UserMapper() {

	}

	public static final Function<User, Optional<UserMaster>> TO_USER_MASTER = e -> evalMapper(e, UserMaster.class);

	public static final Function<UserMaster, Optional<User>> TO_USER = e -> evalMapper(e, User.class);

	public static final Function<Collection<User>, List<UserMaster>> TO_USER_MASTERS = e -> newList(
			evalMapperCollection(e, UserMaster.class));

	public static final Function<Collection<UserMaster>, List<User>> TO_USERS = e -> newList(
			evalMapperCollection(e, User.class));
}
