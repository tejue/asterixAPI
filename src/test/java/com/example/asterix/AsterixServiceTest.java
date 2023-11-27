package com.example.asterix;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AsterixServiceTest {
    AsterixRepo characterRepo = mock(AsterixRepo.class);
    IdService idService = mock(IdService.class);
    AsterixService characterService = new AsterixService(characterRepo, idService);

    @Test
    void testGetAllCharacters_whenCalled_thenReturnAllCharacters() {
        //GIVEN
        List<AsterixCharacter> characters = List.of(new AsterixCharacter("123", "Buberix", 12, "Bubi"));
        when(characterRepo.findAll()).thenReturn(characters);
        //WHEN
        List<AsterixCharacter> actual = characterService.getAllCharacters();
        //THEN
        List<AsterixCharacter> expected = List.of(new AsterixCharacter("123", "Buberix", 12, "Bubi"));
        verify(characterRepo).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void testSaveCharacter_whenNewCharacter_thenReturnNewCharacter() {
        //GIVEN
        AsterixCharacterDTO characterDTO = new AsterixCharacterDTO("Buberix", 12, "Bubi");
        AsterixCharacter characterToSave = new AsterixCharacter("test-id", "Buberix", 12, "Bubi");

        when(characterRepo.save(characterToSave)).thenReturn(characterToSave);
        when(idService.randomId()).thenReturn("test-id");
        //WHEN
        AsterixCharacter actual = characterService.saveCharacter(characterDTO);
        //THEN
        AsterixCharacter expected = new AsterixCharacter("test-id", "Buberix", 12, "Bubi");
        assertEquals(expected, actual);
    }
}