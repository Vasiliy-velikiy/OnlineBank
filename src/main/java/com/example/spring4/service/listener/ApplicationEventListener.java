package com.example.spring4.service.listener;

import com.example.spring4.domain.event.UserCreateEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author dkotov
 * @since 07.12.2021
 */
@Component
public class ApplicationEventListener {

    @EventListener(UserCreateEvent.class)
    public void onEvent(final UserCreateEvent event) {
        System.out.println(event.getEmail());
    }
}
