package CountryApi.soap.countryCode.response;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class CountryISOCodeResponse {
    @JacksonXmlProperty(localName = "CountryISOCodeResult")
    private String countryISOCodeResult;
}
