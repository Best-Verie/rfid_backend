package com.rfid.rfid_backend.controller;


import com.rfid.rfid_backend.model.Role;
import com.rfid.rfid_backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class UserRoleController {
    @Autowired
    public RoleRepository roleRepository;

    @GetMapping
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Role role){
        roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }
}
