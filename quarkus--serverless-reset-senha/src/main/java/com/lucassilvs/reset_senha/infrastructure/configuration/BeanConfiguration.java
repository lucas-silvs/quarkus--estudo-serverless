package com.lucassilvs.reset_senha.infrastructure.configuration;

import com.lucassilvs.reset_senha.domain.adapters.services.UserServicesPortImpl;
import com.lucassilvs.reset_senha.domain.ports.components.PasswordComponents;
import com.lucassilvs.reset_senha.domain.ports.interfaces.UserServicesPort;
import com.lucassilvs.reset_senha.domain.ports.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class BeanConfiguration {

    @Produces
    @ApplicationScoped
    public UserServicesPort userServicesPort(UserRepository userRepository, PasswordComponents passwordComponents){
        return new UserServicesPortImpl(userRepository, passwordComponents);
    }
}
