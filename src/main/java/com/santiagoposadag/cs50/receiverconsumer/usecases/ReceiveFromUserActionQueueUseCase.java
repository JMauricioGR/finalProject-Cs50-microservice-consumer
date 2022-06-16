package com.santiagoposadag.cs50.receiverconsumer.usecases;

import com.google.gson.Gson;
import com.santiagoposadag.cs50.receiverconsumer.collections.User;
import com.santiagoposadag.cs50.receiverconsumer.repository.UserActionRepository;
import org.springframework.stereotype.Component;

@Component
public class ReceiveFromUserActionQueueUseCase {

    private Gson gson = new Gson();
    private UserActionRepository userActionRepository;

    public ReceiveFromUserActionQueueUseCase(UserActionRepository userActionRepository) {
        this.userActionRepository = userActionRepository;
    }

    public void receiveUser(String message) {

        User user = gson.fromJson(message, User.class);
        userActionRepository.save(user).subscribe();
    }
}
