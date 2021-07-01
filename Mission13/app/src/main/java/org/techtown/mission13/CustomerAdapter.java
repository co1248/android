package org.techtown.mission13;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHorder> implements OnCustomerItemClickListener{
    ArrayList<Customer> items = new ArrayList<>();
    OnCustomerItemClickListener listener;

    @Override
    public ViewHorder onCreateViewHolder(ViewGroup parent, int viewType) {  //처음실행
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.customer_item, parent, false);
        return new ViewHorder(itemView, this);
    }

    @Override
    public void onBindViewHolder(CustomerAdapter.ViewHorder holder, int position) { //리스트 스크롤할때 뷰에맞는 정보를 보여줌
        Customer item = items.get(position);
        holder.setItem(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    void  addItem(Customer item) {
        items.add(item);
    }

    public  Customer getItem(int position) {
        return items.get(position);
    }

    @Override
    public void onItemClick(ViewHorder holder, View view, int position) {
        listener.onItemClick(holder, view, position); //익명객체의 listener

    }

    public void setOnItemClickListener(OnCustomerItemClickListener listener) { //익명객체 listener
        this.listener = listener;
    }

    static class ViewHorder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        TextView textView3;
        ImageView imageView;

        public ViewHorder(View itemView, OnCustomerItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition(); //우리가 누른 뷰의 리스트를 인덱스값으로 알려준다
                    listener.onItemClick(ViewHorder.this, v, position); //이 줄의 listener는 CustomerAdapter 자신
                }
            });

        }
        public  void  setItem(Customer item) {
            textView.setText(item.getName());
            textView2.setText(item.getBirth());
            textView3.setText(item.getMobile());
            imageView.setImageResource(item.getResId());
        }
    }
}
