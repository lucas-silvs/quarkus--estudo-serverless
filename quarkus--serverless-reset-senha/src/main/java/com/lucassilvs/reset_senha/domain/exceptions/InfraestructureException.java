package com.lucassilvs.reset_senha.domain.exceptions;

public class InfraestructureException extends ResponseException{
    public InfraestructureException(String message, int statusCode) {
        super(message, LayerExceptionEnum.INFRASTRUCTURE, statusCode);
    }
}
