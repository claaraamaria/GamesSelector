package com.claramaria.ludsim.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.claramaria.ludsim.R;
import com.claramaria.ludsim.model.GameInfo;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    private final OnItemClickListener mListener;
    private ArrayList<GameInfo> mList;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;

        ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.title);
            mTextView2 = itemView.findViewById(R.id.description_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public AdapterRecyclerView(Context context, ArrayList<GameInfo> list, OnItemClickListener listener) {
        mList = list;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view, mListener);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        GameInfo currentItem = mList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getTitle());
        holder.mTextView2.setText(currentItem.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
