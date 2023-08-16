package com.lucassilvs.reset_senha.domain.exceptions;

public enum LayerExceptionEnum {

    DOMAIN("Domain Layer"),
    APPLICATION("Application Layer"),
    ENTRYPOINT("Entrypoint Layer"),
    INFRASTRUCTURE("Infrastructure Layer");

    private final String displayName;

    LayerExceptionEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
