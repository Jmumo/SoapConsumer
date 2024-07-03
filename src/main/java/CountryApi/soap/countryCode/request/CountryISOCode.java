package CountryApi.soap.countryCode.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CountryISOCode {

    @JacksonXmlProperty(localName = "web:sCountryName")
    private String sCountryName;
}
