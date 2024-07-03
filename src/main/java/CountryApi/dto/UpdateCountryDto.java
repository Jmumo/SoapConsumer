package CountryApi.dto;


import CountryApi.domain.Language;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class UpdateCountryDto {
@JsonProperty("sISOCode")
    private String sISOCode;


    @JsonProperty("sName")
    private String sName;

   @JsonProperty("sCapitalCity")
    private String sCapitalCity;
   @JsonProperty("sPhoneCode")
    private String sPhoneCode;
    @JsonProperty("sContinentCode")

    private String sContinentCode;
    @JsonProperty("sCurrencyISOCode")

    private String sCurrencyISOCode;
    @JsonProperty("sCountryFlag")

    private String sCountryFlag;

    @JsonProperty("languages")

    private List<Language> languages;
}
