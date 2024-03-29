package external.ws;

import eu.nites.esb.iec.common.message.base.IecMessage;
import eu.nites.esb.iec.common.message.meterservicerequest.ObjectFactory;
import eu.nites.esb.iec.common.message.reply.ReplyMessage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 */
@WebService(name = "SendMeterReadings", targetNamespace = "http://meterreadings.ws.esb.nites.eu/")
@XmlSeeAlso({
        ObjectFactory.class
})
public interface SendMeterReadings {

    /**
     * @param iecMessage
     * @return returns eu.nites.esb.ws.meterreadings.ReplyMessage
     */
    @WebMethod(operationName = "CreateMeterReadings")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "CreateMeterReadings", targetNamespace = "http://meterreadings.ws.esb.nites.eu/", className = "eu.nites.esb.ws.meterreadings.CreateMeterReadings")
    @ResponseWrapper(localName = "CreateMeterReadingsResponse", targetNamespace = "http://meterreadings.ws.esb.nites.eu/", className = "eu.nites.esb.ws.meterreadings.CreateMeterReadingsResponse")
    @Action(input = "http://meterreadings.ws.esb.nites.eu/SendMeterReadings/CreateMeterReadingsRequest", output = "http://meterreadings.ws.esb.nites.eu/SendMeterReadings/CreateMeterReadingsResponse")
    public ReplyMessage createMeterReadings(
            @WebParam(name = "IECMessage", targetNamespace = "")
                    IecMessage iecMessage);

    /**
     * @param iecMessage
     * @return returns eu.nites.esb.ws.meterreadings.ReplyMessage
     */
    @WebMethod(operationName = "UpdateMeterReadings")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "UpdateMeterReadings", targetNamespace = "http://meterreadings.ws.esb.nites.eu/", className = "eu.nites.esb.ws.meterreadings.UpdateMeterReadings")
    @ResponseWrapper(localName = "UpdateMeterReadingsResponse", targetNamespace = "http://meterreadings.ws.esb.nites.eu/", className = "eu.nites.esb.ws.meterreadings.UpdateMeterReadingsResponse")
    @Action(input = "http://meterreadings.ws.esb.nites.eu/SendMeterReadings/UpdateMeterReadingsRequest", output = "http://meterreadings.ws.esb.nites.eu/SendMeterReadings/UpdateMeterReadingsResponse")
    public ReplyMessage updateMeterReadings(
            @WebParam(name = "IECMessage", targetNamespace = "")
                    IecMessage iecMessage);

    /**
     * @param iecMessage
     * @return returns eu.nites.esb.ws.meterreadings.ReplyMessage
     */
    @WebMethod(operationName = "CreatedMeterReadings")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "CreatedMeterReadings", targetNamespace = "http://meterreadings.ws.esb.nites.eu/", className = "eu.nites.esb.ws.meterreadings.CreatedMeterReadings")
    @ResponseWrapper(localName = "CreatedMeterReadingsResponse", targetNamespace = "http://meterreadings.ws.esb.nites.eu/", className = "eu.nites.esb.ws.meterreadings.CreatedMeterReadingsResponse")
    @Action(input = "http://meterreadings.ws.esb.nites.eu/SendMeterReadings/CreatedMeterReadingsRequest", output = "http://meterreadings.ws.esb.nites.eu/SendMeterReadings/CreatedMeterReadingsResponse")
    public ReplyMessage createdMeterReadings(
            @WebParam(name = "IECMessage", targetNamespace = "")
                    IecMessage iecMessage);

    /**
     * @param iecMessage
     * @return returns eu.nites.esb.ws.meterreadings.ReplyMessage
     */
    @WebMethod(operationName = "UpdatedMeterReadings")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "UpdatedMeterReadings", targetNamespace = "http://meterreadings.ws.esb.nites.eu/", className = "eu.nites.esb.ws.meterreadings.UpdatedMeterReadings")
    @ResponseWrapper(localName = "UpdatedMeterReadingsResponse", targetNamespace = "http://meterreadings.ws.esb.nites.eu/", className = "eu.nites.esb.ws.meterreadings.UpdatedMeterReadingsResponse")
    @Action(input = "http://meterreadings.ws.esb.nites.eu/SendMeterReadings/UpdatedMeterReadingsRequest", output = "http://meterreadings.ws.esb.nites.eu/SendMeterReadings/UpdatedMeterReadingsResponse")
    public ReplyMessage updatedMeterReadings(
            @WebParam(name = "IECMessage", targetNamespace = "")
                    IecMessage iecMessage);

}
