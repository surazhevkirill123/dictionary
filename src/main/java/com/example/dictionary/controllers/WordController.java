package com.example.dictionary.controllers;

import com.example.dictionary.models.Word;
import com.example.dictionary.services.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WordController {
    private final WordService wordService;

    @GetMapping("/")
    public String words(Model model){
        model.addAttribute("words",wordService.getWords());
        return "words";
    }

    @GetMapping("/word/{id}")
    public String wordInfo(@PathVariable Long id, Model model){
        model.addAttribute("word",wordService.getWordById(id));
        return "word-info";
    }

    @PostMapping("/word/create")
    public String createWord(Word word){
        wordService.saveWord(word);
        return "redirect:/";
    }

    @PostMapping("/word/delete/{id}")
    public String deleteWord(@PathVariable Long id){
        wordService.deleteWord(id);
        return "redirect:/";
    }
}
