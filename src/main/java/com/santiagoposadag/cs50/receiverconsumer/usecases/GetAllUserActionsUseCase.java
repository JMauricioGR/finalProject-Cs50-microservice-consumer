package com.santiagoposadag.cs50.receiverconsumer.usecases;

import com.santiagoposadag.cs50.receiverconsumer.dto.UserDto;
import com.santiagoposadag.cs50.receiverconsumer.helpers.UserMapper;
import com.santiagoposadag.cs50.receiverconsumer.repository.UserActionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class GetAllUserActionsUseCase implements Function<String, Flux<UserDto>> {

    private UserActionRepository userActionRepository;
    private UserMapper mapper;

    public GetAllUserActionsUseCase(UserActionRepository userActionRepository) {
        this.userActionRepository = userActionRepository;
    }

    @Override
    public Flux<UserDto> apply(String s) {
        return userActionRepository.findAll().map(mapper.fromUserToUserDto());
    }
}
