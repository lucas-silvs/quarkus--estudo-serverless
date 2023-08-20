package com.lucassilvs.reset_senha.infrastructure.datasources.relational.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UserEntity extends PanacheEntityBase {

        @Id
        private Long id;
        private String login;
        private String nome;
        private String email;
        private String cpf;
        private String dataNascimento;
        private String telefone;
        private String senha;

        public UserEntity() {
        }

        public UserEntity(String login, String nome, String email, String cpf, String dataNascimento, String telefone, String senha) {
            this.login = login;
            this.nome = nome;
            this.email = email;
            this.cpf = cpf;
            this.dataNascimento = dataNascimento;
            this.telefone = telefone;
            this.senha = senha;
        }

    public Long getId() {
        return id;
    }

    public static UserEntity of(String login, String nome, String email, String cpf, String dataNascimento, String telefone, String senha) {
            return new UserEntity(login, nome, email, cpf, dataNascimento, telefone, senha);
        }

        public String getLogin() {
            return login;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public String getCpf() {
            return cpf;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public String getTelefone() {
            return telefone;
        }

        public String getSenha() {
            return senha;
        }

}
