package com.lucassilvs.reset_senha.domain.ports.interfaces;

import com.lucassilvs.reset_senha.domain.models.UserModel;

public interface UserServicesPort {


    void resetPassword(String identifier, String newPassword);

    UserModel getUser(String identifier);


}
