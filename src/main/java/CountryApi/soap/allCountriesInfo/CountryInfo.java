package CountryApi.soap.allCountriesInfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;


@Data
public class CountryInfo {

    @JacksonXmlProperty(localName = "sISOCode")
    private String sISOCode;

    @JacksonXmlProperty(localName = "sName")
    private String sName;

    @JacksonXmlProperty(localName = "sCapitalCity")
    private String sCapitalCity;

    @JacksonXmlProperty(localName = "sPhoneCode")
    private String sPhoneCode;

    @JacksonXmlProperty(localName = "sContinentCode")
    private String sContinentCode;

    @JacksonXmlProperty(localName = "sCurrencyISOCode")
    private String sCurrencyISOCode;

    @JacksonXmlProperty(localName = "sCountryFlag")
    private String sCountryFlag;

    @JacksonXmlProperty(localName = "Languages")
    private Languages languages;
}
