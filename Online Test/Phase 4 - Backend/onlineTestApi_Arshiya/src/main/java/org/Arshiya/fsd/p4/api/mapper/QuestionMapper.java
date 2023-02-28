package org.Arshiya.fsd.p4.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { QuizMapperService.class, AnswerMapperService.class })
public interface QuestionMapper extends
	EntityDtoMapper<org.Arshiya.fsd.p4.api.dto.Question, org.Arshiya.fsd.p4.api.entity.Question> {
	
	@Mapping(expression = "java(QuizMapperService.findById(quizId))", target = "quiz")
	org.Arshiya.fsd.p4.api.entity.Question toEntity(org.Arshiya.fsd.p4.api.dto.Question dto, Long quizId);
	
	@Mapping(source = "answer", target = "answerIndex")
	org.Arshiya.fsd.p4.api.dto.Question toDto(org.Arshiya.fsd.p4.api.entity.Question entity);
	
}
