package CountryApi.soap.countryCode.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;


@Data
public class ResEnvelope {

    @JacksonXmlProperty(localName = "Body")
    private Body body;
}
