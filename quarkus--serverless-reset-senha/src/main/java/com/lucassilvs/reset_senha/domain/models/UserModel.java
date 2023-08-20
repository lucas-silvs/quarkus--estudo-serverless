package com.lucassilvs.reset_senha.domain.models;

import java.time.LocalDateTime;
import java.util.Date;

public record UserModel(
        Long id,
        String login,
        String nome,
        String email,
        String cpf,
        LocalDateTime dataNascimento,
        String telefone,
        String senha

) {

}
