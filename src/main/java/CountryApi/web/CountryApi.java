package CountryApi.web;


import CountryApi.dto.CreateCountryDto;
import CountryApi.dto.HttpResponse;
import CountryApi.dto.UpdateCountryDto;
import CountryApi.services.CountryApiService;
import CountryApi.utils.SharedUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static CountryApi.utils.SharedUtils.emptyBody;
import static CountryApi.utils.SharedUtils.isNullOrEmpty;

@RestController
@Slf4j
@RequestMapping("/api/v1")

public class CountryApi {


    private final CountryApiService countryApiService;



    public CountryApi(CountryApiService countryApiService) {
        this.countryApiService = countryApiService;
    }


    @PostMapping(produces = "application/json")
    public HttpResponse createCountry(@RequestBody CreateCountryDto createCountryDto) throws JsonProcessingException {

        if (isNullOrEmpty(createCountryDto.getName())) {
            return emptyBody();
        }
        return countryApiService.saveCountry(createCountryDto);
    }


    @PostMapping(path = "/country", produces = "application/json")
    public HttpResponse getCountryInformation(@RequestBody CreateCountryDto createCountryDto) {
        if (isNullOrEmpty(createCountryDto.getName())) {
            return emptyBody();
        }

        return countryApiService.getCountry(createCountryDto.getName());
    }



    @GetMapping(path = "/country/{id}", produces = "application/json")
    public HttpResponse getCountryInformationById(@PathVariable Long id) {
        if (isNullOrEmpty(id.toString())) {
            return emptyBody();
        }
        return countryApiService.getCountryById(id);
    }

    @DeleteMapping(path = "/country/{id}", produces = "application/json")
    public HttpResponse deleteCountryInformationById(@PathVariable Long id) {
        if (isNullOrEmpty(id.toString())) {
            return emptyBody();
        }
        return countryApiService.deleteCountryById(id);
    }


    @PutMapping(path = "/updatecountry", produces = "application/json")
    public HttpResponse updateCountryInformationById(@RequestBody UpdateCountryDto updateCountryDto) {
        if (isNullOrEmpty(updateCountryDto.toString())) {
            return emptyBody();
        }
        return countryApiService.updateCountryById(updateCountryDto);
    }


}
