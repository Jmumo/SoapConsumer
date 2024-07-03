package CountryApi.soap.fullCountryInfo.response;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "soap:Envelope")
public class SoapEnvelopeResponse {
        @JacksonXmlProperty(localName = "Body")
        private Body body;




}



