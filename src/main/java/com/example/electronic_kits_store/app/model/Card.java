package com.example.electronic_kits_store.app.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
public class Card {
    private long SESSION_ID;
    private List<CardItem> cardItems;
}
