package gokhancomert.cohortassignmentweek4.Controller;

import gokhancomert.cohortassignmentweek4.Dto.Request;
import gokhancomert.cohortassignmentweek4.Service.WeatherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("weather/api")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;


    @GetMapping("current")
    public ResponseEntity<?> getCurrentWeather(@Valid @RequestBody Request request){

        return weatherService.getCurrentWeather(request);

    }

    @GetMapping("weekly")
    public ResponseEntity<?> getWeeklyWeather(@Valid @RequestBody Request request){

        return weatherService.getWeatherWeekly(request);

    }

    @GetMapping("monthly")
    public ResponseEntity<?> getMonthlyWeather(@Valid @RequestBody Request request){

        return weatherService.getWeatherMonthly(request);

    }

}
