package CountryApi.soap.countryCode.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Data
@AllArgsConstructor
public class Body {
    @JacksonXmlProperty(localName = "web:CountryISOCode")
    private CountryISOCode countryISOCode;
}
