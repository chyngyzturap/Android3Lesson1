package com.pharos.android3lesson1.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.pharos.android3lesson1.R;
import com.pharos.android3lesson1.domain.Card;
import com.pharos.android3lesson1.domain.Game;

import java.util.List;

public class EmojiGame extends AppCompatActivity {
    private final Game<String> game;
    private final Context context;


    public EmojiGame(Context context) {
        this.context = context;
        game = new Game<>(List.of("👻", "🎃", "👹"));
    }

    public void choose(Card<String> card){
        game.choose(card);
        if (game.isGameOver()){message();}
    }

    private void message() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.dialog).show();
    }

    public List<Card<String>> getCards(){
        return game.getCards();
    }
}
