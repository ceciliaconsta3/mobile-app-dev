package com.zybooks.c196.UI;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zybooks.c196.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder>{

    // viewholder tells the adapter everything in each list item
    class TermViewHolder extends RecyclerView.ViewHolder{
        private final TextView termItemView;
        private TermViewHolder(View itemView){ // this is the constructor
            super(itemView);
            termItemView = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                }
            });
        }
    }

    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
