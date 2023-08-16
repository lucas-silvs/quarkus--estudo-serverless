package com.lucassilvs.reset_senha.domain.exceptions;


public class ApplicationException extends ResponseException {
    public ApplicationException(String message, int statusCode) {
        super(message, LayerExceptionEnum.APPLICATION, statusCode);
    }
}
