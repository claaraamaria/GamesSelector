package com.claramaria.gamesselector;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.claramaria.gamesselector.activities.ListBallGames;
import com.claramaria.gamesselector.activities.ListBoardGames;
import com.claramaria.gamesselector.activities.ListCardGames;
import com.claramaria.gamesselector.activities.ListDrinkingGames;
import com.claramaria.gamesselector.activities.ListInteractiveGames;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<ListItemData> mList;

    public interface OnItemClickListener {
        void onItemClick(int position, Context context);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;

        ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position, v.getContext());
                        }
                    }
                }
            });
        }
    }

    public RecyclerViewAdapter(ArrayList<ListItemData> list) {
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        OnItemClickListener mListener = new OnItemClickListener() {
            @Override
            public void onItemClick(int position, Context context) {
                Intent myIntent;
                switch (position) {
                    case 0:
                        myIntent = new Intent(context, ListBallGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 1:
                        myIntent = new Intent(context, ListBoardGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 2:
                        myIntent = new Intent(context, ListDrinkingGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 3:
                        myIntent = new Intent(context, ListCardGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 4:
                        myIntent = new Intent(context, ListInteractiveGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                }
            }
        };
        return new ViewHolder(view, mListener);
    }

    private void startActivityForResult(Intent myIntent, int index) {
        //TODO figure out how call others Activity
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItemData currentItem = mList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
