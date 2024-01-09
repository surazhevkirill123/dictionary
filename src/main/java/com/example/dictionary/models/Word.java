package com.example.dictionary.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Word {
    private Long id;
    private String englishWord;
    private String description;
}
