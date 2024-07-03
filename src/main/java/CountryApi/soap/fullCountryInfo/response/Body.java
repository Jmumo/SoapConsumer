package CountryApi.soap.fullCountryInfo.response;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Body {

    @JacksonXmlProperty(localName = "FullCountryInfoResponse")
    private FullCountryInfoResponse fullCountryInfoResponse;
}
