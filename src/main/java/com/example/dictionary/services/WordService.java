package com.example.dictionary.services;

import com.example.dictionary.models.Word;
import com.example.dictionary.repositories.WordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;

    public List<Word> getWords(String englishWord) {
        if (englishWord != null) return wordRepository.findAllByEnglishWord(englishWord);
        return wordRepository.findAll();
    }

    public void saveWord(Word word) {
        log.info("Saving new {}", word);
        wordRepository.save(word);
    }

    public void deleteWord(Long id) {
        wordRepository.deleteById(id);
    }

    public Object getWordById(Long id) {
        return wordRepository.findById(id).orElse(null);
    }
}
