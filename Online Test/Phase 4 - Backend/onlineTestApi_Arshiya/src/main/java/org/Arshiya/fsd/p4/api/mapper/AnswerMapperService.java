package org.Arshiya.fsd.p4.api.mapper;

import org.Arshiya.fsd.p4.api.dto.Question;
import org.mapstruct.Mapper;

@Mapper
public interface AnswerMapperService {

	default org.Arshiya.fsd.p4.api.entity.Answer getAnswer(Integer answerIndex, Question questionDTO) {
		if (answerIndex == null || questionDTO == null) {
			return null;
		}
		
		org.Arshiya.fsd.p4.api.entity.Choice choice = new org.Arshiya.fsd.p4.api.entity.Choice();
		choice.setId(questionDTO.getChoices().get(answerIndex).getId());
		
		org.Arshiya.fsd.p4.api.entity.Question question = new org.Arshiya.fsd.p4.api.entity.Question();
		question.setId(questionDTO.getId());
		
		org.Arshiya.fsd.p4.api.entity.Answer answer = new org.Arshiya.fsd.p4.api.entity.Answer();
		answer.setChoice(choice);
		answer.setQuestion(question);
		
		return answer;
	}
	
	static Integer getIndex(org.Arshiya.fsd.p4.api.entity.Answer answer) {
		if (answer == null) {
			return null;
		}
		
		return answer.getQuestion().getChoices().indexOf(answer.getChoice());
	}
	
}
