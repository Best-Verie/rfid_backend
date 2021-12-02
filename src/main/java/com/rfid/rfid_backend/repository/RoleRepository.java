package com.rfid.rfid_backend.repository;


import com.rfid.rfid_backend.enumerations.ERoleName;
import com.rfid.rfid_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(ERoleName roleName);
}
