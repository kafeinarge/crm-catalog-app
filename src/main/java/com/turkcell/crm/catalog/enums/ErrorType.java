package com.turkcell.crm.catalog.enums;

public enum ErrorType {
    SUCCESS("200", "success"),
    SERVICE_ERROR("460", "service fail");

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
