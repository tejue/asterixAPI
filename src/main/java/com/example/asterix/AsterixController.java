package com.example.asterix;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asterix")
@RequiredArgsConstructor
public class AsterixController {

    private final AsterixService service;

    @GetMapping()
    public List<AsterixCharacter> getAllCharacters() {
        return service.getAllCharacters();
    }

    @GetMapping("/character/{id}")
    public AsterixCharacter getCharacterById(@PathVariable String id) {
        return service.getCharacterById(id);
    }

    @PostMapping()
    public AsterixCharacter saveCharacter(@RequestBody AsterixCharacterDTO character) {
        return service.saveCharacter(character);
    }

    /*
    @PutMapping()
 public AsterixCharacter updateCharacter(AsterixCharacter updatedCharacter) {
        return service.updateCharacter(updatedCharacter);
    }*/

    /*@DeleteMapping("character/{id}")
    public void deleteCharacterById(@PathVariable String id){
        return service.deleteCharacterByID(id);
    }*/
}
