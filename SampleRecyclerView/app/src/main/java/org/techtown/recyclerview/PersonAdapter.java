package org.techtown.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends  RecyclerView.Adapter<PersonAdapter.ViewHorder> implements OnPersonItemClickListener{
    ArrayList<Person> items = new ArrayList<>();

    OnPersonItemClickListener listener;

    @Override
    public ViewHorder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item, parent, false);
        return new ViewHorder(itemView, this);
    }

    @Override
    public void onBindViewHolder(PersonAdapter.ViewHorder viewHolder, int position) {
        Person item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  void  addItem(Person item) {
        items.add(item);
    }

    public void setItems(ArrayList<Person> items) {
        this.items = items;
    }

    public  Person getItem(int position) {
        return items.get(position);
    }

    public void setItem(int poistion, Person item) {
        items.set(poistion, item);
    }

    @Override
    public void onItemClick(ViewHorder horder, View view, int position) {
        listener.onItemClick(horder, view, position);
    }

    public void  setOnItemClickListener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    static class ViewHorder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHorder(View itemView, OnPersonItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHorder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Person item) {
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }
    }
}
