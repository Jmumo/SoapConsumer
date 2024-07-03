package CountryApi.soap.fullCountryInfo.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class SoapBody {

    @JacksonXmlProperty(localName = "web:FullCountryInfo")
    private FullCountryInfo fullCountryInfo;
}
