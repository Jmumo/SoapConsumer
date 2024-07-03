package CountryApi.domain;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "LANGUAGES")
public class Language extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sISOCode;

    private String sName;



}
