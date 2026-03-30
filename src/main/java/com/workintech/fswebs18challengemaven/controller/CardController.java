package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cards")
@CrossOrigin
@RequiredArgsConstructor
public class CardController {

    private final CardRepository cardRepository;

    @GetMapping
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @GetMapping("/byColor/{color}")
    public List<Card> findByColor(@PathVariable String color) {
        return cardRepository.findByColor(color);
    }

    @GetMapping("/byValue/{value}")
    public List<Card> findByValue(@PathVariable int value) {
        return cardRepository.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> findByType(@PathVariable String type) {
        return cardRepository.findByType(type);
    }

    @PostMapping
    public Card save(@RequestBody Card card) {
        CardValidation.validate(card);
        return cardRepository.save(card);
    }

    @PutMapping("/")
    public Card update(@RequestBody Card card) {
        CardValidation.validate(card);
        return cardRepository.update(card);
    }

    @DeleteMapping("/{id}")
    public Card remove(@PathVariable Long id) {
        return cardRepository.remove(id);
    }
}
