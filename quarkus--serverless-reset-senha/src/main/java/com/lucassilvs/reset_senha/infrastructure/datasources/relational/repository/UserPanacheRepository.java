package com.lucassilvs.reset_senha.infrastructure.datasources.relational.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import com.lucassilvs.reset_senha.infrastructure.datasources.relational.entity.UserEntity;

@ApplicationScoped
public class UserPanacheRepository implements PanacheRepository<UserEntity> {

    @Inject
    EntityManager em;

    @Transactional
    public void cadastrarUsuario(UserEntity novoUsuario) {
        em.persist(novoUsuario);
    }

    public UserEntity buscarPeloCpfCnpj(String cpf){
        return find("cpf", cpf).firstResult();
    }
}
