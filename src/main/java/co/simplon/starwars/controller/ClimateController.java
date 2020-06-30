package co.simplon.starwars.controller;


import co.simplon.starwars.repository.ClimateRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/climate")
public class ClimateController {

    private ClimateRepository climateRepository;
}
