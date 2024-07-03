package gokhancomert.cohortassignmentweek4.Service;
import gokhancomert.cohortassignmentweek4.Dto.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class WeatherService {

    RestTemplate restTemplate = new RestTemplate();

    private String url = "http://api.weatherapi.com/v1";

    @Value("${weatherapi.key}")
    private String key;


    public ResponseEntity<?> getCurrentWeather(Request request){

        ResponseEntity<?> response = restTemplate.getForEntity(url + "/current.json?key=" + key + "&q=" + request.getLocation(), String.class);
        return response;
    }

    //Weekly
    public ResponseEntity<?> getWeatherWeekly(Request request){

        ResponseEntity<?> response = restTemplate.getForEntity(url + "/forecast.json?key=" + key + "&q=" + request.getLocation() + "&days=7&aqi=no&alerts=no",  String.class);
        return response;
    }

    public ResponseEntity<?> getWeatherMonthly(Request request){

        ResponseEntity<?> response = restTemplate.getForEntity(url + "/future.json?key=" + key + "&q=" + request.getLocation() + "&dt="+ LocalDate.now().plusMonths(1),  String.class);
        return response;
    }


}
