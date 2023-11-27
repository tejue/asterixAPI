package com.example.asterix;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("character")
public record AsterixCharacter(String id, String name, int age, String profession) {
}
