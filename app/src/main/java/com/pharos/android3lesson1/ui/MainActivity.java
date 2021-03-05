package com.pharos.android3lesson1.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.pharos.android3lesson1.R;
import com.pharos.android3lesson1.domain.Card;
import com.pharos.android3lesson1.ui.adapter.EmojiAdapter;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       RecyclerView recyclerView = findViewById(R.id.rv_cards);
      EmojiAdapter emojiAdapter = new EmojiAdapter(new EmojiGame(this));
        recyclerView.setAdapter(emojiAdapter);
    }

}