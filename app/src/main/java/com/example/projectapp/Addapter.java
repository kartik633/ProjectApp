package com.example.projectapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Addapter extends ArrayAdapter<Ent> {

    private Context context;
    private List<Ent> mEnglish;

    public Addapter(Context a, ArrayList<Ent> b)
    {
        super(a,0,b);
        context = a;
        mEnglish = b;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tts,parent,false);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvDes = view.findViewById(R.id.tvDes);
        TextView tvPrice = view.findViewById(R.id.tvPrice);
        ImageView imgView = view.findViewById(R.id.imgView);

        tvName.setText(mEnglish.get(position).getS2());
        tvDes.setText(mEnglish.get(position).getS3());
        tvPrice.setText(mEnglish.get(position).getS4());

        imgView.setImageResource(mEnglish.get(position).getS1());

        return view;

    }

}
