package com.example.user.ks_intern_2017.screen.userList.fragments.list;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.ks_intern_2017.R;
import com.example.user.ks_intern_2017.data.model.User;
import com.example.user.ks_intern_2017.screen.userList.fragments.list.listener.OnPeopleRecyclerItemClickListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by User on 24.07.2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserHolder> {

    private ArrayList<User> users;
    OnPeopleRecyclerItemClickListener onPeopleRecyclerItemClickListener;

    public UserListAdapter(ArrayList<User> users, OnPeopleRecyclerItemClickListener onPeopleRecyclerItemClickListener) {
        this.users = users;
        this.onPeopleRecyclerItemClickListener = onPeopleRecyclerItemClickListener;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_item, parent, false);
        UserHolder userHolder = new UserHolder(view);
        view.setOnClickListener(v -> onPeopleRecyclerItemClickListener.onItemClick(view, userHolder.getAdapterPosition()));


        return userHolder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        User user = users.get(position);
        holder.bindView(user);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public User getItem(int position) {
        return users.get(position);
    }

    class UserHolder extends RecyclerView.ViewHolder {
        TextView tvUsername;
        ImageView ivCategory;
        ImageView ivStatus;
        CardView cv;

        public UserHolder(View itemView) {
            super(itemView);

            cv = (CardView) itemView.findViewById(R.id.card_view);
            tvUsername = (TextView) itemView.findViewById(R.id.tv_username);
            ivCategory = (ImageView) itemView.findViewById(R.id.iv_category);
            ivStatus = (ImageView) itemView.findViewById(R.id.iv_status);

            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        itemView.setBackgroundColor(Color.GRAY);
                        cv.setBackgroundColor(Color.GRAY);
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP||event.getAction() == MotionEvent.ACTION_CANCEL) {
                        itemView.setBackgroundColor(Color.parseColor("#00ffffff"));
                        cv.setBackgroundColor(Color.parseColor("#e7ffffff"));
                    }


                    return false;
                }
            });


        }

        public void bindView(User user) {
            tvUsername.setText(user.getUsername());
            initialImage(ivCategory, user.getCategory());
            initialStatus(ivStatus, user.isOnline());

        }


        private void initialStatus(ImageView imageView, boolean status) {
            if (status) {
                imageView.setImageResource(R.drawable.online_oval);
            } else {
                imageView.setImageResource(R.drawable.disconnect_oval);

            }

        }

        private void initialImage(ImageView imageView, User.Category category) {
            switch (category) {
                case FAMILY:
                    imageView.setImageResource(R.drawable.family);
                    break;
                case FRIENDS:
                    imageView.setImageResource(R.drawable.friends);
                    break;
                case WORK:
                    imageView.setImageResource(R.drawable.work);
                    break;
                case OTHER:
                    imageView.setImageResource(R.drawable.other);
                    break;
            }

        }
    }
}
