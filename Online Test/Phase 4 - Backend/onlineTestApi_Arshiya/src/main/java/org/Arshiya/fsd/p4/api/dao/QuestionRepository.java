package org.Arshiya.fsd.p4.api.dao;

import java.util.List;

import org.Arshiya.fsd.p4.api.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	@Modifying
	@Query(value = "Delete from Question q where id in ?1")
	void deleteByIds(List<Long> questionIds);

}
