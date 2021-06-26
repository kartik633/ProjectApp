package com.example.projectapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter2 extends ArrayAdapter<En> {

    private Context context;
    private List<En> mKs;

    public Adapter2(Context a,ArrayList<En> b)
    {
        super(a,0,b);
        context = a;
        mKs = b;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food,parent,false);

        TextView whatfoo = view.findViewById(R.id.whatfoo);
        TextView whatpri = view.findViewById(R.id.whatpri);
        TextView whatqu = view.findViewById(R.id.whatqu);
        Button plus = view.findViewById(R.id.addplus);
        Button minus = view.findViewById(R.id.minus);


        whatfoo.setText(mKs.get(position).getS1());
        whatpri.setText(mKs.get(position).getS2());
        whatqu.setText(mKs.get(position).getS3());
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oo = mKs.get(position).getS3();
                int ch = Integer.parseInt(oo);
                ch=ch+1;
                mKs.get(position).setS3(String.valueOf(ch));
                whatqu.setText(String.valueOf(ch));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oo = mKs.get(position).getS3();
                int ch = Integer.parseInt(oo);
                if(ch == 0)
                {
                    ch = 0;
                    mKs.get(position).setS3(String.valueOf(ch));
                    whatqu.setText(String.valueOf(ch));
                }
                else
                {
                    ch=ch-1;
                    mKs.get(position).setS3(String.valueOf(ch));
                    whatqu.setText(String.valueOf(ch));
                }
            }
        });

        return view;

    }



}
