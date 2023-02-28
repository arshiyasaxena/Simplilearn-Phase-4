package org.Arshiya.fsd.p4.api.dao;

import java.util.List;

import javax.annotation.Resource;

import org.Arshiya.fsd.p4.api.dto.Question;
import org.Arshiya.fsd.p4.api.exception.OnlineTestDaoException;
import org.Arshiya.fsd.p4.api.mapper.AnswerMapperService;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDaoImpl implements AnswerDao {

	@Resource
	AnswerRepository repository;
	
	@Resource
	AnswerMapperService mapper;
	
	@Override
	public void save(Integer answerIndex, Question question) throws OnlineTestDaoException {
		try {
			repository.save(mapper.getAnswer(answerIndex, question));
		} catch (Exception e) {
			throw new OnlineTestDaoException(e.getMessage());
		}
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
