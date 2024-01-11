package com.example.dictionary.controllers;

import com.example.dictionary.models.Word;
import com.example.dictionary.services.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class WordController {
    private final WordService wordService;

    @GetMapping("/")
    public String words(@RequestParam(name = "englishWord", required = false) String englishWord, Model model){
        model.addAttribute("words",wordService.getWords(englishWord));
        return "words";
    }

    @GetMapping("/word/{id}")
    public String wordInfo(@PathVariable Long id, Model model){
        Word word = wordService.getWordById(id);
        model.addAttribute("word",wordService.getWordById(id));
        model.addAttribute("images", word.getImages());
        return "word-info";
    }

    @PostMapping("/word/create")
    public String createWord(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                             @RequestParam("file3") MultipartFile file3, Word word) throws IOException {
        wordService.saveWord(word, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/word/delete/{id}")
    public String deleteWord(@PathVariable Long id){
        wordService.deleteWord(id);
        return "redirect:/";
    }
}
