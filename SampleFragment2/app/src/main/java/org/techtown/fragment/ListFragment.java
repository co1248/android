package org.techtown.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import javax.security.auth.callback.Callback;


public class ListFragment extends Fragment {

    public static interface ImageSelection{
        public void onImageSelected(int position);
    }

    public ImageSelection callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof ImageSelection) {
            callback = (ImageSelection) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        Button button = rootview.findViewById(R.id.button);
        Button button2 = rootview.findViewById(R.id.button2);
        Button button3 = rootview.findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onImageSelected(0);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onImageSelected(1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onImageSelected(2);
            }
        });


        return rootview;
    }
}