package com.lucassilvs.reset_senha.domain.adapters.services;

import com.lucassilvs.reset_senha.domain.exceptions.ApplicationException;
import com.lucassilvs.reset_senha.domain.models.UserModel;
import com.lucassilvs.reset_senha.domain.ports.components.PasswordComponents;
import com.lucassilvs.reset_senha.domain.ports.interfaces.UserServicesPort;
import com.lucassilvs.reset_senha.domain.ports.repositories.UserRepository;
import com.lucassilvs.reset_senha.infrastructure.components.BcryptPasswordComponents;

public class UserServicesPortImpl implements UserServicesPort {

    private final UserRepository userRepository;

    private final PasswordComponents passwordComponents;

    public UserServicesPortImpl(UserRepository userRepository, PasswordComponents passwordComponents) {
        this.userRepository = userRepository;
        this.passwordComponents = passwordComponents;
    }

    @Override
    public void resetPassword(String identifier, String newPassword) {

        if (!userRepository.existByCpf(identifier))
            throw new ApplicationException(String.format("Usuário com CPF %s não encontrado", identifier), 404);
        try {
            String newPasswordEncoded = passwordComponents.criptografarSenha(newPassword);
            userRepository.resetPassword(identifier, newPasswordEncoded);
        } catch (Exception e) {
            throw new ApplicationException(String.format("Erro ao resetar senha: %s",e.getMessage()), 500);
        }
    }

    @Override
    public UserModel getUser(String cpf) {
        return userRepository.getUserByCpf(cpf).orElseThrow(() -> new ApplicationException(String.format("Usuário com CPF %s não encontrado", cpf), 404));
    }
}
