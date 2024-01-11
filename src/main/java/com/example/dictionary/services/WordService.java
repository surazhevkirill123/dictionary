package com.example.dictionary.services;

import com.example.dictionary.models.Image;
import com.example.dictionary.models.Word;
import com.example.dictionary.repositories.WordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public void saveWord(Word word, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException  {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            word.addImageToWord(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            word.addImageToWord(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            word.addImageToWord(image3);
        }
        log.info("Saving new Word. EnglishWord: {};", word.getEnglishWord());
        Word wordFromDb = wordRepository.save(word);
        wordFromDb.setPreviewImageId(wordFromDb.getImages().get(0).getId());
        wordRepository.save(word);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteWord(Long id) {
        wordRepository.deleteById(id);
    }

    public Word getWordById(Long id) {
        return wordRepository.findById(id).orElse(null);
    }
}
