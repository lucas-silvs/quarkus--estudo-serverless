package com.lucassilvs.reset_senha.application.controller.impl;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lucassilvs.reset_senha.application.controller.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserEventHandler implements RequestHandler<UserDto, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEventHandler.class);

    @Override
    public String handleRequest(UserDto input, Context context) {

        LOGGER.info("Received request with name {}", input.nome());
        return "finalizada";
    }
}
