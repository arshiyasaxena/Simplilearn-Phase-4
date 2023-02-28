package org.Arshiya.fsd.p4.api.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends
	EntityDtoMapper<org.Arshiya.fsd.p4.api.dto.User, org.Arshiya.fsd.p4.api.entity.User> {
	
}
