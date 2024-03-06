package com.example.new16personalities;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonalityAdapter extends RecyclerView.Adapter<PersonalityAdapter.PersonalityViewHolder> {
    ArrayList<Personality> personality;

    public PersonalityAdapter(ArrayList<Personality> personality) {
        this.personality = personality;
    }

    @NonNull
    @Override
    public PersonalityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PersonalityViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.personality_layout,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull PersonalityViewHolder holder, int position) {
        Personality thePersonality=personality.get(position);
        holder.txtAuthour.setText(personality.get(position).number);
        holder.txtTitle.setText(personality.get(position).title);
        holder.txtSynopsis.setText(personality.get(position).type);
        holder.txtISBN.setText(personality.get(position).description);


        Resources res=holder.itemView.getContext().getResources();
        int id=res.getIdentifier("@drawable/"+thePersonality.cover,"drawable", "com.example.new16personalities");
        holder.imgcover.setImageResource(id);


    }


    @Override
    public int getItemCount() {
        return personality.size();
    }


    public class PersonalityViewHolder extends RecyclerView.ViewHolder {

        TextView txtAuthour, txtISBN,txtSynopsis, txtTitle;
        ImageView imgcover;

        public PersonalityViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAuthour=itemView.findViewById(R.id.txtAuthor);
            txtISBN=itemView.findViewById(R.id.txtISBN);
            txtSynopsis=itemView.findViewById(R.id.txtSynopsis);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            imgcover=itemView.findViewById(R.id.imgCover);

        }
    }
}