package com.lucassilvs.reset_senha.domain.ports.repositories;

import com.lucassilvs.reset_senha.domain.models.UserModel;

import java.util.Optional;

public interface UserRepository {

    void resetPassword(String cpf, String newPassword);

    boolean existByCpf(String cpf);

    Optional<UserModel> getUserByCpf(String cpf);



}
