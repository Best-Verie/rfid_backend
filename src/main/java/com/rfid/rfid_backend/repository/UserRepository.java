package com.rfid.rfid_backend.repository;


import com.rfid.rfid_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String usernameOrMobileOrEmail);

	Optional<User> findByEmailOrUsernameOrMobile(String login, String login2, String login3);

	boolean existsByEmail(String email);

	boolean existsByMobile(String mobile);

}
