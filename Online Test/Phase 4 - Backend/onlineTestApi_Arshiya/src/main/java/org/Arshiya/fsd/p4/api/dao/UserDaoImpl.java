package org.Arshiya.fsd.p4.api.dao;

import javax.annotation.Resource;

import org.Arshiya.fsd.p4.api.dto.User;
import org.Arshiya.fsd.p4.api.exception.OnlineTestDaoException;
import org.Arshiya.fsd.p4.api.mapper.UserMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	private UserRepository repository;
	
	@Resource
	private UserMapper mapper;

	@Override
	public User getUser(String email) throws OnlineTestDaoException {
		User user = null;
		
		try {
			user = repository.findById(email)
					.map(entity -> mapper.toDto(entity))
					.orElse(null);
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
		
		return user;
	}

	@Override
	public User getUser(String email, String password) throws OnlineTestDaoException {
		User user = null;
		
		try {
			user = repository.findByEmailAndPassword(email, password)
					.map(entity -> mapper.toDto(entity))
					.orElse(null);
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
		
		return user;
	}

	@Override
	@Transactional
	public User save(User user) throws OnlineTestDaoException {
		User savedUser = null;
		
		try {
			savedUser = mapper.toDto(repository.save(mapper.toEntity(user)));
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
		
		return savedUser;
	}
	
}
