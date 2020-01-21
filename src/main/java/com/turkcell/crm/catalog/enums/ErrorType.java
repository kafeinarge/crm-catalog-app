package com.turkcell.crm.catalog.enums;

public enum ErrorType {
    SERVICE_NOT_FOUND("404", "ERROR");

    private String resultCode;
    private String resultMessage;

    ErrorType(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public String getResultCode() {
        return resultCode;
    }
}
