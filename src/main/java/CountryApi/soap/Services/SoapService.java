package CountryApi.soap.Services;


import CountryApi.soap.fullCountryInfo.request.FullCountryInfo;
import CountryApi.soap.fullCountryInfo.response.SoapEnvelopeResponse;
import CountryApi.soap.fullCountryInfo.request.SoapBody;
import CountryApi.soap.fullCountryInfo.request.SoapEnvelope;
import CountryApi.soap.countryCode.request.Body;
import CountryApi.soap.countryCode.request.CountryISOCode;
import CountryApi.soap.countryCode.request.Envelope;
import CountryApi.soap.countryCode.response.ResEnvelope;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static CountryApi.utils.SharedUtils.capitalizeFirstLetter;
import static CountryApi.utils.SharedUtils.isNullOrEmpty;

@Slf4j
@Service
@RequiredArgsConstructor
public class SoapService {


    private  final OkHttpClient okHttpClient;

    @Value("${soap.url}")
    private  String soapUrl;



    public SoapEnvelopeResponse saveCountry(String countryName) {

          if(!isNullOrEmpty(countryName)){
              try {

                  Envelope envelope = new Envelope();
                  envelope.setBody(new Body(new CountryISOCode(capitalizeFirstLetter(countryName))));

                  XmlMapper xmlMapper = new XmlMapper();
                  String xml = xmlMapper.writeValueAsString(envelope);

                  RequestBody body = RequestBody.create(xml, okhttp3.MediaType.parse("text/xml; charset=utf-8"));
                  Request request = new Request.Builder()
                          .url(soapUrl)
                          .post(body)
                          .build();

                  try (Response response = okHttpClient.newCall(request).execute()) {
                      if (!response.isSuccessful()){ throw new Exception("Unexpected code " + response);}
                      String responseBody=response.body().string();

                      ResEnvelope envelopeResponse = xmlMapper.readValue(responseBody, ResEnvelope.class);

                      SoapEnvelopeResponse soapEnvelopeResponse = getCountryFullInformation(envelopeResponse.getBody().getCountryISOCodeResponse().getCountryISOCodeResult());

                      return soapEnvelopeResponse;
                  } catch (Exception e) {
                      throw new RuntimeException(e.getMessage());
                  }
              } catch (IOException e) {
                  throw new RuntimeException(e.getMessage());
              }
          }
          return new SoapEnvelopeResponse();


    }


    public SoapEnvelopeResponse getCountryFullInformation(String countryCode) {




        SoapEnvelopeResponse soapEnvelopeResponse = null;

        if(!isNullOrEmpty(countryCode)){
            try {


                FullCountryInfo fullCountryInfo = new FullCountryInfo(countryCode);
                SoapEnvelope soapEnvelope=new SoapEnvelope();
                soapEnvelope.setBody(new SoapBody(fullCountryInfo));
                XmlMapper xmlMapper = new XmlMapper();
                String xml = xmlMapper.writeValueAsString(soapEnvelope);


                RequestBody body = RequestBody.create(xml, okhttp3.MediaType.parse("text/xml; charset=utf-8"));
                Request request = new Request.Builder()
                        .url(soapUrl)
                        .post(body)
                        .build();

                try (Response response = okHttpClient.newCall(request).execute()) {
                    if (!response.isSuccessful()) throw new Exception("Unexpected code " + response);

                    soapEnvelopeResponse = xmlMapper.readValue(response.body().string(), SoapEnvelopeResponse.class);
                }

            } catch (Exception e){

                e.printStackTrace();}
        }



            return soapEnvelopeResponse;
    }
}
