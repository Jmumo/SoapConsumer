package CountryApi.soap.allCountriesInfo;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Language {

    @JacksonXmlProperty(localName = "sISOCode")
    private String sISOCode;

    @JacksonXmlProperty(localName = "sName")
    private String sName;
}
