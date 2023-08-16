package com.lucassilvs.reset_senha.domain.exceptions;

public class EntrypointException extends ResponseException{
    public EntrypointException(String message, int statusCode){
        super(message, LayerExceptionEnum.ENTRYPOINT, statusCode);
    }
}
