package com.example.asterix;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AsterixService {

    private final AsterixRepo repo;
    private final IdService idService;

    //public List<AsterixCharacter> getAllCharacters() {
    //    return repo.getAllCharacters();
    //}
    public List<AsterixCharacter> getAllCharacters() {
        return repo.findAll();
    }

    /*public AsterixCharacter saveCharacter(AsterixCharacterDTO character) {
        AsterixCharacter newCharacter = new AsterixCharacter(UUID.randomUUID().toString(), character.name(), character.age(), character.profession());
        return repo.save(newCharacter);
    }*/

    public AsterixCharacter saveCharacter(AsterixCharacterDTO character) {
        AsterixCharacter newCharacter = new AsterixCharacter(idService.randomId(), character.name(), character.age(), character.profession());
        return repo.save(newCharacter);
    }

    public AsterixCharacter getCharacterById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Character not found"));
    }

/*    public void deleteCharacterByID(String id) {
        return repo.deleteById(id);
    }*/

    /*public AsterixCharacter updateCharacter(String id, String n, AsterixCharacter characterUpdate) {
    Optional<AsterixCharacter> characterToUpdate =  repo.findById(id);
    if(characterToUpdate.isPresent()) {
        repo.save()
    }

    return null;
    }

    public Character updateCharacter(String id, String name) {
        Optional<Character> findC=repo.findById(id);
        if(findC.isPresent()){
            return repo.save(findC.get().withName(name));
        }
        throw new RuntimeException("Not found!");
    }

    public Character putCharacter(String id, Character character) {
        Character existingCharacter = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        Character updatedCharacter = existingCharacter
                .withName(character.name())
                .withAge(character.age())
                .withOccupation(character.occupation());
        return repo.save(updatedCharacter);
    }*/


}
