package org.Arshiya.fsd.p4.api.dao;

import java.util.List;

import org.Arshiya.fsd.p4.api.dto.Category;
import org.Arshiya.fsd.p4.api.exception.OnlineTestDaoException;

public interface CategoryDao {

	List<Category> getCategories() throws OnlineTestDaoException;
	
}
