package org.Arshiya.fsd.p4.api.dao;

import java.util.List;

import org.Arshiya.fsd.p4.api.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
	@Modifying
	@Query(value = "Delete from Answer a where a.question.id in ?1")
	void deleteByQuestionIds(List<Long> questionIds);
	
}
