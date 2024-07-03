package CountryApi.soap.countryCode.request;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data

@JacksonXmlRootElement(localName = "soap:Envelope")
public class Envelope {

    @JacksonXmlProperty(localName = "soap:Header")
    private String header;

    @JacksonXmlProperty(localName = "soap:Body")
    private Body body;



    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:soap")
    private String soapenvNamespace = "http://www.w3.org/2003/05/soap-envelope";

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:web")
    private String webNamespace = "http://www.oorsprong.org/websamples.countryinfo";
}
