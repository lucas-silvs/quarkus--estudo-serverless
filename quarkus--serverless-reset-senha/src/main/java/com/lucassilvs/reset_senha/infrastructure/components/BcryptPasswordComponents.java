package com.lucassilvs.reset_senha.infrastructure.components;


import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BcryptPasswordComponents {
    public  String criptografarSenha(String senhaPura){
        return BcryptUtil.bcryptHash(senhaPura);
    }

}


