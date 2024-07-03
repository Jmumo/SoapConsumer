package CountryApi.Enums;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum ErrorsDefination {

    COUNTRY_NOT_FOUND("Country not found in the database"),
    SUCCESS("Success"),
    EMPTYBODY("The request body is empty"),;

    private final String message;

    public String getMessage() {
        return message;
    }
}
