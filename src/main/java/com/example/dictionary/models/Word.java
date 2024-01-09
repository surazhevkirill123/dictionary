package com.example.dictionary.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "words")
@Data
@AllArgsConstructor
@NoArgsConstructor //
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "englishWord")
    private String englishWord;
    @Column(name = "description", columnDefinition = "text")
    private String description;
}
