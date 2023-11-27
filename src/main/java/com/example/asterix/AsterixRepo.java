package com.example.asterix;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface AsterixRepo extends MongoRepository<AsterixCharacter, String> {

    //Map<String, AsterixCharacter> characterMap = new HashMap<>();

    //public List<AsterixCharacter> getAllCharacters() {
    //    return new ArrayList<>(characterMap.values());
    //}

    //public AsterixCharacter save(AsterixCharacter character) {
    //    return character;
    //}
}
