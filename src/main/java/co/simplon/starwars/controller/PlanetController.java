package co.simplon.starwars.controller;

import co.simplon.starwars.model.Planet;
import co.simplon.starwars.repository.PlanetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/planets")
public class PlanetController {

    private PlanetRepository planetRepository;

    public PlanetController(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @PostMapping
    public ResponseEntity<Planet> create(@RequestBody Planet planet) {
        return ResponseEntity.ok(planetRepository.save(planet));
    }

    @GetMapping("/{planetNb}")
    public ResponseEntity<Planet> getOne(@PathVariable int planetNb) {
        return ResponseEntity.ok(planetRepository.findById(planetNb).get());
    }

    @GetMapping
    public ResponseEntity<List<Planet>> getAll() {
        return ResponseEntity.ok(planetRepository.findAll());
    }

    @PutMapping("/{planetNb}")
    public ResponseEntity<?> update(@PathVariable int planetNb, @RequestBody Planet planetToUpdate) {
        try {
            Planet planet = planetRepository.findById(planetNb).get();
            planetToUpdate.setId(planetNb);
            planet = planetToUpdate;
            return ResponseEntity.ok(planetRepository.save(planet));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Planète inexistante coco !");
        }
    }

    @DeleteMapping("/{planetNb}")
    public ResponseEntity<String> delete(@PathVariable int planetNb) {
        Planet planetToDelete = planetRepository.findById(planetNb).get();
        String planetName = planetToDelete.getName();
        planetRepository.delete(planetToDelete);
        return ResponseEntity.ok("La planète " + planetName + " a été supprimée");
    }


}
