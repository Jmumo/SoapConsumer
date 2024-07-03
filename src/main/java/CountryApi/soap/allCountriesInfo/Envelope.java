package CountryApi.soap.allCountriesInfo;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Envelope {


    @JacksonXmlProperty(localName = "Body")
    private Body body;

}
