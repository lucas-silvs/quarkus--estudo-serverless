package com.lucassilvs.reset_senha.domain.exceptions;


public class DomainException extends ResponseException{

    public DomainException(String message, int statusCode) {
        super(message, LayerExceptionEnum.DOMAIN, statusCode);
    }

}
