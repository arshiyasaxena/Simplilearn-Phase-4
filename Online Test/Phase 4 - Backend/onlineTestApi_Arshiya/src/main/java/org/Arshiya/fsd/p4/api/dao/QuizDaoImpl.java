package org.Arshiya.fsd.p4.api.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.Arshiya.fsd.p4.api.dto.Category;
import org.Arshiya.fsd.p4.api.dto.Quiz;
import org.Arshiya.fsd.p4.api.dto.User;
import org.Arshiya.fsd.p4.api.exception.OnlineTestDaoException;
import org.Arshiya.fsd.p4.api.mapper.CategoryMapper;
import org.Arshiya.fsd.p4.api.mapper.QuizMapper;
import org.Arshiya.fsd.p4.api.mapper.UserMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuizDaoImpl implements QuizDao {

	@Resource
	private QuizRepository repository;
	
	@Resource
	private QuizMapper mapper;
	
	@Resource
	private CategoryMapper categoryMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public Quiz getQuiz(Long id) throws OnlineTestDaoException {
		Quiz quiz = null;
		
		try {
			quiz = repository.findById(id)
					.map(entity -> mapper.toDto(entity))
					.orElse(null);
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
		
		return quiz;
	}

	@Override
	@Transactional
	public Quiz save(Quiz quiz) throws OnlineTestDaoException {
		Quiz savedQuiz = null;
		
		try {
			org.Arshiya.fsd.p4.api.entity.Quiz entity = mapper.toEntity(quiz);
			
			if (quiz.getImage() != null && !quiz.getImage().isEmpty()) {
				entity.setImage(IOUtils.toByteArray(quiz.getImage().getInputStream()));
			}
			
			savedQuiz = mapper.toDto(repository.save(entity));
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
		
		return savedQuiz;
	}

	@Override
	public List<Quiz> getQuizzesByCategory(Category category) throws OnlineTestDaoException {
		List<Quiz> quizzes = null;
		
		try {
			quizzes = repository.findByCategory(categoryMapper.toEntity(category))
					.stream()
					.map(entity -> mapper.toDto(entity))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
		
		return quizzes;
	}

	@Override
	public List<Quiz> getQuizzesByTester(User user) throws OnlineTestDaoException {
		List<Quiz> quizzes = null;
		
		try {
			quizzes = repository.findByTester(userMapper.toEntity(user))
					.stream()
					.map(entity -> mapper.toDto(entity))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
		
		return quizzes;
	}

	@Override
	@Transactional
	public void remove(Long id) throws OnlineTestDaoException {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
	}

	@Override
	public byte[] getQuizImage(Long id) throws OnlineTestDaoException {
		byte[] image = null;
		
		try {
			org.Arshiya.fsd.p4.api.entity.Quiz quiz = repository.findWithImageAttachedById(id);
			image = quiz.getImage();
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
		
		return image;
	}

}
