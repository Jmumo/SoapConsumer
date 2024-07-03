package CountryApi.soap.fullCountryInfo.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;


@Data
public class FullCountryInfoResult {

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

    @JacksonXmlElementWrapper(localName = "Languages")
    @JacksonXmlProperty(localName = "tLanguage")
    private List<Language> languages;
}
