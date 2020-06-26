package com.claramaria.gamesselector.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.claramaria.gamesselector.R;
import com.claramaria.gamesselector.fragments.MessageFragment;
import com.claramaria.gamesselector.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.MyHolder> {
    private Context mContext;
    private List<User> userList;

    public AdapterUsers(Context mContext, List<User> userList) {
        this.mContext = mContext;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_users, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        User currentUser = userList.get(position);

        holder.mName.setText(currentUser.getUserName());
        holder.mEmail.setText(currentUser.getEmail());
        holder.mPhone.setText(currentUser.getTelephone());

        try {
            Picasso.get().load(currentUser.getImageUrl())
                            // .resize(50, 50)
                            .placeholder(R.drawable.ic_account_circle_black_24dp)
                    .into(holder.mAvatar);
        } catch (Exception e) {
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, MessageFragment.class);
                intent.putExtra("userId", currentUser.getUserId());
                Toast.makeText(mContext, "To be implemented", Toast.LENGTH_SHORT).show();
               /*TODO mContext.startActivity(intent);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        ImageView mAvatar;
        TextView mName;
        TextView mEmail;
        TextView mPhone;

        MyHolder(@NonNull View itemView) {
            super(itemView);

            mAvatar = itemView.findViewById(R.id.circularAvatar);
            mName = itemView.findViewById(R.id.itemName);
            mEmail = itemView.findViewById(R.id.itemEmail);
            mPhone = itemView.findViewById(R.id.itemPhone);
        }
    }
}
