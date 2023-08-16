package com.lucassilvs.reset_senha.domain.adapters.services;

import com.lucassilvs.reset_senha.domain.exceptions.ApplicationException;
import com.lucassilvs.reset_senha.domain.models.UserModel;
import com.lucassilvs.reset_senha.domain.ports.interfaces.UserServicesPort;
import com.lucassilvs.reset_senha.domain.ports.repositories.UserRepository;

public class UserServicesPortImpl implements UserServicesPort {

    private final UserRepository userRepository;

    public UserServicesPortImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void resetPassword(String identifier, String newPassword) {

        if (!userRepository.existByCpf(identifier))
            throw new ApplicationException(String.format("Usuário com CPF %s não encontrado", identifier), 404);

        try {
            userRepository.resetPassword(identifier, newPassword);
        } catch (Exception e) {
            throw new ApplicationException("Erro ao resetar senha", 500);
        }
    }

    @Override
    public UserModel getUser(String cpf) {
        return userRepository.getUserByCpf(cpf).orElseThrow(() -> new ApplicationException(String.format("Usuário com CPF %s não encontrado", cpf), 404));
    }
}
