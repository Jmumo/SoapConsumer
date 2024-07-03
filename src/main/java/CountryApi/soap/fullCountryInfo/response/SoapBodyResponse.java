package CountryApi.soap.fullCountryInfo.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class SoapBodyResponse {
    @JacksonXmlProperty(localName = "m:FullCountryInfoResponse", namespace = "http://www.oorsprong.org/websamples.countryinfo")
    private FullCountryInfoResponse fullCountryInfoResponse;
}
