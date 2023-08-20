package com.lucassilvs.reset_senha.infrastructure.components;

import com.lucassilvs.reset_senha.domain.ports.components.PasswordComponents;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PasswordComponentsImpl implements PasswordComponents {

    @Inject
    private BcryptPasswordComponents bcryptPasswordComponents;



    @Override
    public String criptografarSenha(String senhaPura) {
        return bcryptPasswordComponents.criptografarSenha(senhaPura);
    }
}
