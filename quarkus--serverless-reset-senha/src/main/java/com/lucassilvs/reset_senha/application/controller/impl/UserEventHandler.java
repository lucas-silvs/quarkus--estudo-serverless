package com.lucassilvs.reset_senha.application.controller.impl;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lucassilvs.reset_senha.application.controller.dto.UserDto;
import com.lucassilvs.reset_senha.application.controller.mapper.UserDtoMapper;
import com.lucassilvs.reset_senha.domain.ports.interfaces.UserServicesPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserEventHandler implements RequestHandler<UserDto, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEventHandler.class);

    private final UserServicesPort userServicesPort;

    private final UserDtoMapper userDtoMapper = UserDtoMapper.INSTANCE;

    public UserEventHandler(UserServicesPort userServicesPort) {
        this.userServicesPort = userServicesPort;
    }

    @Override
    public String handleRequest(UserDto input, Context context) {
        UserDto userDto = userDtoMapper.map(userServicesPort.getUser(input.cpf()));
        LOGGER.info("Received request with name {}", input.nome());
        LOGGER.info("ID do usuário: {}", userDto.id());

        LOGGER.info("Realizando reset de senha para o usuário {}", userDto.nome());
        userServicesPort.resetPassword(userDto.cpf(), input.senha());

        return String.format("Senha resetada com sucesso para o usuário %s", userDto.nome());
    }
}
