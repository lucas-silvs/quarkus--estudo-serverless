package com.lucassilvs.reset_senha.domain.models;

import java.util.Date;

public record UserModel(
        Long id,
        String login,
        String nome,
        String email,
        String cpf,
        Date dataNascimento,
        String telefone,
        String senha

) {

}
