package CountryApi.soap.allCountriesInfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;


@Data
public class Body {

    @JacksonXmlProperty(localName = "FullCountryInfoAllCountriesResponse")
    private FullCountryInfoAllCountriesResponse fullCountryInfoAllCountriesResponse;
}
