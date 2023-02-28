package org.Arshiya.fsd.p4.api.dao;

import java.util.List;

import javax.annotation.Resource;

import org.Arshiya.fsd.p4.api.dto.Choice;
import org.Arshiya.fsd.p4.api.exception.OnlineTestDaoException;
import org.Arshiya.fsd.p4.api.mapper.ChoiceMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ChoiceDaoImpl implements ChoiceDao {

	@Resource
	private ChoiceRepository repository;
	
	@Resource
	private ChoiceMapper mapper;
	
	@Override
	public Choice getChoice(Long id) throws OnlineTestDaoException {
		Choice choice = null;
		
		try {
			choice = repository.findById(id)
					.map(entity -> mapper.toDto(entity))
					.orElse(null);
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
		
		return choice;
	}

	@Override
	@Transactional
	public Choice save(Choice choice, Long questionId) throws OnlineTestDaoException {
		Choice savedChoice = null;
		
		try {
			savedChoice = mapper.toDto(repository.save(mapper.toEntity(choice, questionId)));
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
		
		return savedChoice;
	}

	@Override
	public void remove(List<Long> questionIds) throws OnlineTestDaoException {
		try {
			repository.deleteByQuestionIds(questionIds);
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
	}

}
