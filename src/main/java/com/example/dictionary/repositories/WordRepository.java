package com.example.dictionary.repositories;

import com.example.dictionary.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word,Long> {
    List<Word> findAllByEnglishWord(String englishWord);
}
