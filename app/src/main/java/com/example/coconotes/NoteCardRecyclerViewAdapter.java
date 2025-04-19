package com.example.coconotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteCardRecyclerViewAdapter extends RecyclerView.Adapter<NoteCardRecyclerViewAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    private Context context;
    private ArrayList<NoteCardModel> noteCardModels;

    public NoteCardRecyclerViewAdapter(RecyclerViewInterface recyclerViewInterface, Context context, ArrayList<NoteCardModel> noteCardModels) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.context = context;
        this.noteCardModels = noteCardModels;
    }

    @NonNull
    @Override
    public NoteCardRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_note_row, parent, false);
        return new NoteCardRecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteCardRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.TitleTextView.setText(noteCardModels.get(position).getTitle());
        holder.SubTextView.setText(noteCardModels.get(position).getSubheading());
    }

    @Override
    public int getItemCount() {
        return noteCardModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView TitleTextView;
        public TextView SubTextView;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            TitleTextView = itemView.findViewById(R.id.rowTitleTextView);
            SubTextView = itemView.findViewById(R.id.rowSubTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onNodeClick(position);
                        }
                    }
                }
            });
        }
    }
}
