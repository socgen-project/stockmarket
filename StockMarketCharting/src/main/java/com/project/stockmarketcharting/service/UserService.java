package com.project.stockmarketcharting.service;

import com.project.stockmarketcharting.entity.UserEntity;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;

public interface UserService {

	public UserEntity createUser(UserEntity user) throws EntityAlreadyExistsException;

	public UserEntity getUser(String username);

	public void deleteUser(Long id);
}
