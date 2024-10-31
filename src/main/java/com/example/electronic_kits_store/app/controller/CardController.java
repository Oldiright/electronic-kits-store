package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.service.CardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;


    @PostMapping
    @ResponseBody
    public ResponseEntity<?> addCardItem(HttpServletRequest request, HttpServletResponse response,
                                          @RequestParam Long id) {
        cardService.addCardItem(request, response, id);;
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<?> deleteCardItem(HttpServletRequest request, HttpServletResponse response,
                                         @RequestParam Long id) {
        cardService.deleteCardItem(request, response, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
