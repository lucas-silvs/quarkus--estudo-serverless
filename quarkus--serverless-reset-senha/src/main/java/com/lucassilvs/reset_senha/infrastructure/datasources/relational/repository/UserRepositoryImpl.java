package com.lucassilvs.reset_senha.infrastructure.datasources.relational.repository;

import com.lucassilvs.reset_senha.domain.models.UserModel;
import jakarta.enterprise.context.ApplicationScoped;
import com.lucassilvs.reset_senha.domain.ports.repositories.UserRepository;

import java.util.Optional;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    private final UserPanacheRepository userPanacheRepository;

    public UserRepositoryImpl(UserPanacheRepository userPanacheRepository) {
        this.userPanacheRepository = userPanacheRepository;
    }

    @Override
    public void resetPassword(String cpf, String newPassword) {

    }

    @Override
    public boolean existByCpf(String cpf) {
        return false;
    }

    @Override
    public Optional<UserModel> getUserByCpf(String cpf) {
        return Optional.empty();
    }
}
