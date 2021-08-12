package com.arek.jupiter.mappers;

import com.arek.jupiter.dtos.UserDto;
import com.arek.jupiter.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto userToUserDto(final User user);

}
