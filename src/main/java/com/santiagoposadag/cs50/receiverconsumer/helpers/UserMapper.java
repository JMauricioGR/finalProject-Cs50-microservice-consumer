package com.santiagoposadag.cs50.receiverconsumer.helpers;

import com.santiagoposadag.cs50.receiverconsumer.collections.User;
import com.santiagoposadag.cs50.receiverconsumer.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper {

    public Function<User, UserDto> fromUserToUserDto() {

        return user -> {
            UserDto userDto = new UserDto();
            userDto.setUserId(user.getUserId());
            userDto.setUserName(user.getUserName());
            userDto.setUserLastName(user.getUserLastName());
            userDto.setRoutingKey(user.getRoutingKey());
            return userDto;
        };
    }

    public Function<UserDto, User> fromUserDtoToUser() {
        return userDto -> {
            User user = new User();
            user.setUserId(userDto.getUserId());
            user.setUserName(userDto.getUserName());
            user.setUserLastName(userDto.getUserLastName());
            user.setRoutingKey(userDto.getRoutingKey());
            return user;
        };
    }

}
