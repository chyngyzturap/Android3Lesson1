package com.pharos.android3lesson1.domain;

import android.content.Context;
import android.os.Build;
import android.os.Vibrator;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Handler;
import android.view.View;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Game<Content> extends AppCompatActivity {
    private final List<Card<Content>> cards = new ArrayList<>();
    private boolean isGameOver = false;

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Game(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>((i * 2) + 1, false, false, contents.get(i)));
            cards.add(new Card<>(i * 2, false, false, contents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<Content> card) {
        card.setFaceUp(!card.isFaceUp());
        checkPairs(card);
        remove();
        gameFinished();
    }

    private void gameFinished() {
        if (cards.isEmpty()) {
            setGameOver(true);
        }
    }


    private void checkPairs(Card<Content> card) {
        for (Card<Content> anotherCard : cards) {
            if (card.isFaceUp() && anotherCard.isFaceUp()) {
                if (card.equals(anotherCard) && card.getId() != anotherCard.getId()) {
                    card.setMatched(true);
                    anotherCard.setMatched(true);
                    Log.d("tag", "MATCH!");
                }
            }
        }
        remove();
    }

    private void remove() {
        List<Card<Content>> resultCards = new ArrayList<>(cards);
        for (Card<Content> c : cards) {
            if (c.isMatched()) {
                resultCards.remove(c);
            }
        }
        cards.clear();
        cards.addAll(resultCards);
    }

    public List<Card<Content>> getCards() {
        return cards;
    }
}
