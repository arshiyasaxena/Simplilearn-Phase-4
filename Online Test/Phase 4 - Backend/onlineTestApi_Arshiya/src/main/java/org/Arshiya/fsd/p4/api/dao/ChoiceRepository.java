package org.Arshiya.fsd.p4.api.dao;

import java.util.List;

import org.Arshiya.fsd.p4.api.entity.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {

	@Modifying
	@Query(value = "Delete from Choice c where c.question.id in ?1")
	void deleteByQuestionIds(List<Long> questionIds);
	
}
