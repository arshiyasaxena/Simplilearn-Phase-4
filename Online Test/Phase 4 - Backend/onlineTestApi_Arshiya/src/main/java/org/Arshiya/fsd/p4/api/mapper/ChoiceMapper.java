package org.Arshiya.fsd.p4.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { QuestionMapperService.class })
public interface ChoiceMapper extends
	EntityDtoMapper<org.Arshiya.fsd.p4.api.dto.Choice, org.Arshiya.fsd.p4.api.entity.Choice> {

	@Mapping(expression = "java(QuestionMapperService.findById(questionId))", target = "question")
	org.Arshiya.fsd.p4.api.entity.Choice toEntity(org.Arshiya.fsd.p4.api.dto.Choice dto, Long questionId);
	
	org.Arshiya.fsd.p4.api.dto.Choice toDto(org.Arshiya.fsd.p4.api.entity.Choice entity);
	
}
