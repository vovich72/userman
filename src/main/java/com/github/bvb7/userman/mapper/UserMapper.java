package com.github.bvb7.userman.mapper;


import com.github.bvb7.userman.dto.UserDto;
import com.github.bvb7.userman.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {

    @Mapping(target = "registrationDate", source = "createdAt")
    UserDto map(User user);

    List<UserDto> mapAll(List<User> users);

    @Mapping(target = "createdAt", source = "registrationDate")
    User map2User(UserDto dto);
}
