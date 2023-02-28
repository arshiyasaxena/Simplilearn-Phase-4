package org.Arshiya.fsd.p4.api.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface QuizMapperService {

	static org.Arshiya.fsd.p4.api.entity.Quiz findById(Long id) {
		if (id == null) {
			return null;
		}
		
		org.Arshiya.fsd.p4.api.entity.Quiz quiz = new org.Arshiya.fsd.p4.api.entity.Quiz();
		quiz.setId(id);
		
		return quiz;
	}
	
}
