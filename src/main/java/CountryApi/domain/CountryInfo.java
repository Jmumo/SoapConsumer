package CountryApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "COUNTRIES")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryInfo extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,unique = true)
    private String sISOCode;

    @Column(nullable = false,unique = true)
    private String sName;

    private String sCapitalCity;

    @Column(nullable = false,unique = true)
    private String sPhoneCode;

    private String sContinentCode;


    private String sCurrencyISOCode;

    private String sCountryFlag;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Language> languages;


}
