package CountryApi.soap.fullCountryInfo.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JacksonXmlRootElement(localName = "soapenv:Envelope")
public class SoapEnvelope {

    @JacksonXmlProperty(localName = "soapenv:Header")
    private SoapHeader header;

    @JacksonXmlProperty(localName = "soapenv:Body")
    private SoapBody body;



    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:soapenv")
    private String soapenvNamespace = "http://schemas.xmlsoap.org/soap/envelope/";

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:web")
    private String webNamespace = "http://www.oorsprong.org/websamples.countryinfo";

}
