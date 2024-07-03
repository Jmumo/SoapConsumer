package CountryApi.soap.allCountriesInfo;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class FullCountryInfoAllCountriesResult {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "tCountryInfo")
    private List<CountryInfo> tCountryInfo;
}
