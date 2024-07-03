package CountryApi.soap.fullCountryInfo.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@Data
public class FullCountryInfo {

    @JacksonXmlProperty(localName = "web:sCountryISOCode")
    private String sCountryISOCode;
}
