package CountryApi.utils;

import CountryApi.dto.HttpResponse;

public class SharedUtils {

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }


    public static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }


    public static HttpResponse emptyBody() {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setStatusCode(200);
        httpResponse.setBody("Empty Body");
        return httpResponse;
    }
}
