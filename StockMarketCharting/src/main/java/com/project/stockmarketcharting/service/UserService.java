package com.project.stockmarketcharting.service;

import com.project.stockmarketcharting.entity.UserEntity;

public interface UserService {

	public UserEntity createUser(UserEntity user) throws Exception;

	public UserEntity getUser(String username);

	public Boolean deleteUser(Long id);
}
