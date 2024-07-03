package CountryApi.services;

import CountryApi.dto.CreateCountryDto;
import CountryApi.dto.HttpResponse;
import CountryApi.dto.UpdateCountryDto;
import com.fasterxml.jackson.core.JsonProcessingException;


public interface CountryApiService {

    HttpResponse saveCountry(CreateCountryDto createCountryDto) throws JsonProcessingException;

    HttpResponse getCountry(String name);

    HttpResponse getCountryById(Long id);

    HttpResponse deleteCountryById(Long id);

    HttpResponse updateCountryById(UpdateCountryDto updateCountryDto);
}
