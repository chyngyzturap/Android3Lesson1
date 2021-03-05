package com.pharos.android3lesson1.ui.adapter;

import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.pharos.android3lesson1.R;
import com.pharos.android3lesson1.domain.Card;
import com.pharos.android3lesson1.ui.EmojiGame;


public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {
    private final EmojiGame emojiGame;


    public EmojiAdapter(EmojiGame emojiGame) {
        this.emojiGame = emojiGame;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new EmojiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));

    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    class EmojiHolder extends RecyclerView.ViewHolder{
        private final TextView tvCard;

        public EmojiHolder(@NonNull View itemView){
            super(itemView);
            tvCard = itemView.findViewById(R.id.tv_card_content);
        }

        public void onBind(Card<String> card){
            if (card.isFaceUp()){
                itemView.setBackgroundColor(Color.WHITE);
                tvCard.setText(card.getContent());
            } else {
                itemView.setBackgroundColor(Color.BLUE);
                tvCard.setText("");
            }
            itemView.setOnClickListener(v -> {
                emojiGame.choose(card);
                notifyDataSetChanged();
            });
        }

    }
}
