package CountryApi.dto;


import lombok.Data;

@Data
public class HttpResponse {
    private int statusCode;
    private String statusMessage;
    private String body;
}
