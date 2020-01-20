package com.turkcell.crm.catalog.handler;

import com.turkcell.crm.catalog.exception.ServiceFaultException;
import com.turkcell.crm.catalog.soap.ResponseMessage;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.namespace.QName;

public class DetailSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {

    private static final QName CODE = new QName("statusCode");
    private static final QName MESSAGE = new QName("message");

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        logger.warn("Exception processed ", ex);
        if (ex instanceof ServiceFaultException) {
            ResponseMessage responseMessage = ((ServiceFaultException) ex).getResponseMessage();
            SoapFaultDetail detail = fault.addFaultDetail();
            detail.addFaultDetailElement(CODE).addText(responseMessage.getStatusCode());
            detail.addFaultDetailElement(MESSAGE).addText(responseMessage.getMessage());
        }
    }
}
