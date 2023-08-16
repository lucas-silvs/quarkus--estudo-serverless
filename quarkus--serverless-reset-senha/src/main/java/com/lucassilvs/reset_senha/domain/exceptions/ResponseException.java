package com.lucassilvs.reset_senha.domain.exceptions;


public abstract class ResponseException extends RuntimeException{

    private final int statusCode;
    private final String message;

    private final LayerExceptionEnum layerException;


    protected ResponseException(String message, LayerExceptionEnum layerException, int statusCode) {
        this.message = message;
        this.layerException = layerException;
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public LayerExceptionEnum getLayerException() {
        return layerException;
    }
}
