package CountryApi.soap.allCountriesInfo;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class FullCountryInfoAllCountriesResponse {

    @JacksonXmlProperty(localName = "FullCountryInfoAllCountriesResult")
    private FullCountryInfoAllCountriesResult fullCountryInfoAllCountriesResult;
}
