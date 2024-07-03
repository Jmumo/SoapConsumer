package CountryApi.soap.allCountriesInfo;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class Languages {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "tLanguage")
    private List<Language> tLanguage;
}
