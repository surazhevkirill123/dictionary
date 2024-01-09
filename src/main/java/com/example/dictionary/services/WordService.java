package com.example.dictionary.services;

import com.example.dictionary.models.Word;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {
    private List<Word> words = new ArrayList<>();
    private long ID = 0;

    {
        words.add(new Word(++ID,"behold","behold – определения\n" +
                "ARCHAIC\n" +
                "LITERARY\n" +
                "Глагол\n" +
                "1\n" +
                "see or observe (a thing or person, especially a remarkable or impressive one).\n" +
                "the botanical gardens were a wonder to behold"));
        words.add(new Word(++ID,"behold","behold – определения\n" +
                "ARCHAIC\n" +
                "LITERARY\n" +
                "Глагол\n" +
                "1\n" +
                "see or observe (a thing or person, especially a remarkable or impressive one).\n" +
                "the botanical gardens were a wonder to behold"));
    }

    public List<Word> getWords() {
        return words;
    }

    public void saveWord(Word word){
        word.setId(++ID);
        words.add(word);
    }

    public void deleteWord(Long id){
        words.removeIf(word -> word.getId().equals(id));
    }

    public Object getWordById(Long id) {
        for (Word word:words){
            if(word.getId().equals(id))
                return word;
        }
        return null;
    }
}
