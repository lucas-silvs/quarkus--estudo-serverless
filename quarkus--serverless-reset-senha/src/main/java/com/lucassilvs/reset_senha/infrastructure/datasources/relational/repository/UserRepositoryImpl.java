package com.lucassilvs.reset_senha.infrastructure.datasources.relational.repository;

import com.lucassilvs.reset_senha.domain.models.UserModel;
import com.lucassilvs.reset_senha.infrastructure.datasources.relational.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import com.lucassilvs.reset_senha.domain.ports.repositories.UserRepository;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    private final UserPanacheRepository userPanacheRepository;

    public UserRepositoryImpl(UserPanacheRepository userPanacheRepository) {
        this.userPanacheRepository = userPanacheRepository;
    }


    @Transactional
    public void resetPassword(String cpf, String newPassword) {
        userPanacheRepository.update("senha = ?1 where cpf = ?2", newPassword, cpf);
    }

    @Override
    public boolean existByCpf(String cpf) {
        return userPanacheRepository.existByCpf(cpf);
    }

    @Override
    public Optional<UserModel> getUserByCpf(String cpf) {
        UserEntity entity = userPanacheRepository.buscarPeloCpfCnpj(cpf);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(entity.getDataNascimento(), formatter);

        return Optional.of(
                new UserModel(
                        entity.getId(),
                        entity.getLogin(),
                        entity.getNome(),
                        entity.getEmail(),
                        entity.getCpf(),
                        dateTime,
                        entity.getTelefone(),
                        null)
        );
    }
}
