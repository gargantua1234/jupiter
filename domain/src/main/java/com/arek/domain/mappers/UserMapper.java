package com.arek.domain.mappers;

import com.arek.domain.dto.UserDto;
import com.arek.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(final User user);
}
