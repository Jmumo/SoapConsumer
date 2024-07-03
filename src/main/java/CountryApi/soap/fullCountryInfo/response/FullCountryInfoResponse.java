package CountryApi.soap.fullCountryInfo.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;


@Data
public class FullCountryInfoResponse {

    @JacksonXmlProperty(localName = "FullCountryInfoResult")
    private FullCountryInfoResult fullCountryInfoResult;
}
