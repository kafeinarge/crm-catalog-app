package com.turkcell.crm.catalog.exception;

import com.turkcell.crm.catalog.soap.ResponseMessage;

public class ServiceFaultException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private ResponseMessage responseMessage;

    public ServiceFaultException(String message, ResponseMessage responseMessage) {
        super(message);
        this.responseMessage = responseMessage;
    }

    public ServiceFaultException(String message, Throwable e, ResponseMessage responseMessage) {
        super(message, e);
        this.responseMessage = responseMessage;
    }

    public ResponseMessage getResponseMessage() {
        return responseMessage;
    }

    public void setSResponseMessage(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
    }

}
