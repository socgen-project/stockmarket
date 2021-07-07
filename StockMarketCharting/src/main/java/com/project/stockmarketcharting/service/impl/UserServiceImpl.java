package com.project.stockmarketcharting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.stockmarketcharting.dao.UserRepository;
import com.project.stockmarketcharting.entity.UserEntity;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;
import com.project.stockmarketcharting.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserEntity createUser(UserEntity user) throws EntityAlreadyExistsException {
		UserEntity existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser != null) {
			throw new EntityAlreadyExistsException("User");
		} else {
			existingUser = userRepository.save(user);
		}
		return existingUser;
	}

	@Override
	public UserEntity getUser(String username) {
		UserEntity user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.getById(id);
		userRepository.deleteById(id);
	}

}
