package org.Arshiya.fsd.p4.api.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapperService {

	default org.Arshiya.fsd.p4.api.entity.User findById(String id) {
		if (id == null) {
			return null;
		}
		
		org.Arshiya.fsd.p4.api.entity.User user = new org.Arshiya.fsd.p4.api.entity.User();
		user.setEmail(id);
		
		return user;
	}
	
	default String findByUser(org.Arshiya.fsd.p4.api.entity.User user) {
		if (user == null) {
			return null;
		}
		
		return user.getEmail();
	}
	
}
