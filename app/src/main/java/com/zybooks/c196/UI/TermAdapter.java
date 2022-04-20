package com.zybooks.c196.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zybooks.c196.Entity.Term;
import com.zybooks.c196.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//TODO: Need to point itemView/termListItem to its respective courseList
public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder>{

    // viewholder tells the adapter everything in each list item
    class TermViewHolder extends RecyclerView.ViewHolder{
        private final TextView termItemView;

        private TermViewHolder(View itemView){ // this is the constructor
            super(itemView);
            termItemView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Term current = mTerms.get(position);// it wants position in list of items, that means we need to tell it where the items are and create the list
                    Intent intent = new Intent(context, TermDetail.class); // now to send information and change it from the current area to another screen
                    intent.putExtra("id", current.getTermID()); // to receive lots of key/value pairs on that intent
                    intent.putExtra("name", current.getTermName());
                    intent.putExtra("startDate", current.getStartDate());
                    intent.putExtra("endDate", current.getEndDate());
                    // need to send the Extras to the actual screen  which shoud display on termlistItem click
                    // enables us to go to the next screen
                    context.startActivity(intent);
                }
            });
        }
    }


    private List<Term> mTerms;
    private final Context context;
    private final LayoutInflater mInflater;

    // constructor for the adapter - the other is for the view holder
    // this inflates the layout with the itemview items
    public TermAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_term_list, parent, false);
        return new TermViewHolder(itemView);
    }

    // this is where you put things on the textview
    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
         if(mTerms != null){
             Term current = mTerms.get(position);
             String name = current.getTermName();
             holder.termItemView.setText(name);
         } else {
             holder.termItemView.setText("No term name");
         }
    }

// call this method from the activity to tell it which terms we want to show
    public void setTerms(List<Term> terms){
        mTerms = terms;
        notifyDataSetChanged();
    }



//    TODO: input validation that will not allow you to delete a term if it contains >1 courses

    @Override
    public int getItemCount() {
        // in case there aren't any records in the database
        if(mTerms != null){
            return mTerms.size();
        } else {
            return 0;
        }

    }
}
