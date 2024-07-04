package CountryApi.services.impl;

import CountryApi.Enums.ErrorsDefination;
import CountryApi.Repositories.CountryInfoRepository;
import CountryApi.domain.CountryInfo;
import CountryApi.dto.CreateCountryDto;
import CountryApi.dto.HttpResponse;
import CountryApi.dto.UpdateCountryDto;
import CountryApi.services.CountryApiService;
import CountryApi.soap.Services.SoapService;
import CountryApi.soap.fullCountryInfo.response.SoapEnvelopeResponse;
import CountryApi.utils.SharedUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryApiImpl implements CountryApiService {

    private final SoapService soapService;

    private final CountryInfoRepository countryInfoRepository;


    @Override
    public HttpResponse saveCountry(CreateCountryDto createCountryDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpResponse httpResponse = new HttpResponse();
        
        if(!SharedUtils.isNullOrEmpty(createCountryDto.getName())) {

            log.info("Saving country: {}", createCountryDto);

            SoapEnvelopeResponse soapEnvelopeResponse = soapService.saveCountry(createCountryDto.getName());

            if(soapEnvelopeResponse.getBody().getFullCountryInfoResponse().getFullCountryInfoResult().getSName().equals(ErrorsDefination.COUNTRY_NOT_FOUND.getMessage())){
                httpResponse.setStatusMessage("Country not found in the database");
                log.info("The requested {} Country not found in the database",createCountryDto.getName());
            }else {

                log.info("The requested {} Country found in the database",createCountryDto.getName());

                httpResponse.setStatusCode(200);

                String jsonString = objectMapper.writeValueAsString(soapEnvelopeResponse.getBody().getFullCountryInfoResponse().getFullCountryInfoResult());

                CountryInfo countryInfo = objectMapper.readValue(jsonString, CountryInfo.class);



                log.info("Saving country to Local DataBase: {}", countryInfo);

                countryInfoRepository.save(countryInfo);

                httpResponse.setBody(soapEnvelopeResponse.getBody().getFullCountryInfoResponse().getFullCountryInfoResult().getSName());

            }

            return httpResponse;
        }
         httpResponse.setBody("Null body");

        return httpResponse;
    }

    @Override
    public HttpResponse getCountry(String name) {

        CountryInfo countryInfo = countryInfoRepository.findBysName(name.toUpperCase());

        HttpResponse httpResponse = new HttpResponse();

        if (countryInfo == null && !SharedUtils.isNullOrEmpty(name)) {
            log.info("Country with the following name is not available: {}", name);
            httpResponse.setBody("CountryInfo not found for name: " + name);
            return httpResponse;
        }

        if (countryInfo != null) {
            httpResponse.setBody(countryInfo.toString());
        }

        return httpResponse;


    }

    @Override
    public HttpResponse getCountryById(Long id) {

        HttpResponse httpResponse = new HttpResponse();


        CountryInfo countryInfo = countryInfoRepository.findById(id).orElse(null);

        if (countryInfo == null) {
            log.info("Country with the following id is not available: {}", id);
            httpResponse.setBody("CountryInfo not found for id: " + id);
        }

        if (countryInfo != null) {
            httpResponse.setBody(countryInfo.toString());
        }
       return httpResponse;
    }

    @Override
    public HttpResponse deleteCountryById(Long id) {
        HttpResponse httpResponse = new HttpResponse();

        CountryInfo countryInfo = countryInfoRepository.findById(id).orElse(null);

        if (countryInfo == null) {
            log.info("Country with the following id is not available: {}", id);
            httpResponse.setBody("CountryInfo not found for id: " + id);
            return httpResponse;
        }

        countryInfoRepository.deleteById(countryInfo.getId());
        httpResponse.setBody("Country deleted for the following id: " + id);

        if(!countryInfoRepository.existsById(id)) {
            httpResponse.setBody("Country deleted for id: " + id);
        }

        return httpResponse;
    }

    @Override
    public HttpResponse updateCountryById(UpdateCountryDto updateCountryDto) {

        HttpResponse httpResponse = new HttpResponse();
        CountryInfo existingCountryInfo = countryInfoRepository.findBysName(updateCountryDto.getSName());

        if(!(existingCountryInfo == null) && !SharedUtils.isNullOrEmpty(existingCountryInfo.getId().toString())){
            log.info("Country with the following name is available: {}", updateCountryDto.getSName());
            BeanUtils.copyProperties(updateCountryDto, existingCountryInfo, "id");
            CountryInfo UpdatedCountryInfo = countryInfoRepository.save(existingCountryInfo);
            httpResponse.setBody(UpdatedCountryInfo.toString());
        }else {
            log.info("Country with the following name is not available: {}", updateCountryDto.getSName());
            httpResponse.setBody("Country with the following name is not available: " + updateCountryDto.getSName());
        }

        return httpResponse;
    }
}
