package com.lucassilvs.reset_senha.application.controller.dto;

import java.util.Date;

public record UserDto(

        String login,
        String nome,
        String email,
        String cpf,

        String dataNascimento,
        String telefone,
        String senha
) {
}
