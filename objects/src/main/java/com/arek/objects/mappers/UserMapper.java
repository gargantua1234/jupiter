package com.arek.objects.mappers;

import com.arek.objects.dto.UserDto;
import com.arek.objects.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(final User user);
}
