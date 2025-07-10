package com.github.bvb7.userman.controller;

import com.github.bvb7.userman.dto.UserDto;
import com.github.bvb7.userman.mapper.UserMapper;
import com.github.bvb7.userman.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "CRUD operations on the \"User\" ")
@RestController
@RequestMapping("users")
@Slf4j
@Setter(onMethod = @__(@Autowired))
public class UsersController {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Operation(
            summary = "Create user",
            description = "Create ne user"
    )
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto user) {
        var entity = userMapper.map2User(user);
        userRepository.save(entity);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get a list of users",
            description = "Get a list of users"
    )
    @GetMapping
    public List<UserDto> getUsers() {
        return userMapper.mapAll(userRepository.findAll());
    }

    @Operation(
            summary = "Get user by ID",
            description = "Get user by ID"
    )
    @ApiResponse(responseCode = "204", description = "User not found")
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(
            @PathVariable @Parameter(description = "User ID", example = "123", required = true) long id
    ) {
        log.info("User ID is {}", id);
        var user = userRepository.getReferenceById(id);
        return new ResponseEntity<>(userMapper.map(user), HttpStatus.OK);
    }

    @Operation(
            summary = "Update user data",
            description = "Update user data by ID"
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> saveUser(
            @PathVariable @Parameter(description = "User ID", example = "123", required = true) long id,
            @RequestBody UserDto user) {
        var entity = userMapper.map2User(user);
        entity.setId(id);
        userRepository.save(entity);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Delete user data",
            description = "Delete user data by ID"
    )
    public ResponseEntity<?> deleteUser(
            @PathVariable @Parameter(description = "User ID", example = "123", required = true) long id) {
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
