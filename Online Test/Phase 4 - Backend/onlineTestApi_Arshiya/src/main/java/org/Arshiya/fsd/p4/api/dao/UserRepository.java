package org.Arshiya.fsd.p4.api.dao;

import java.util.Optional;

import org.Arshiya.fsd.p4.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByEmailAndPassword(String email, String password);

}
