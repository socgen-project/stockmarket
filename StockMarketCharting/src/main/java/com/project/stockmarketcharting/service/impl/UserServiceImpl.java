package com.project.stockmarketcharting.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarketcharting.dao.UserRepository;
import com.project.stockmarketcharting.entity.UserEntity;
import com.project.stockmarketcharting.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserEntity createUser(UserEntity user) throws Exception {
		UserEntity existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser != null) {
			logger.info("User Already Exists");
			throw new Exception("User Already Exists");
		} else {
			existingUser = userRepository.save(user);
		}
		return existingUser;
	}

	@Override
	public UserEntity getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Boolean deleteUser(Long id) {
		try {
			userRepository.getById(id);
			userRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

}
