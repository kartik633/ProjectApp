package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MainActivity3 extends AppCompatActivity {


    int pl =0;
    int n=0;
    int desertNumber;
    int price = 0;
    int ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Button btnHa = findViewById(R.id.btnHa);

        TextView whatqu = findViewById(R.id.whatqu);

        Intent intent = getIntent();
        HashMap<String, String> hashMap = (HashMap<String, String>) intent.getSerializableExtra("hashMap");

        ArrayList<En> ob = new ArrayList<>();

        for (String i : hashMap.keySet()) {
                    ob.add(new En(i,hashMap.get(i),"1"));
                }


        Adapter2 adapter2 = new Adapter2(this,ob);
        ListView listView = findViewById(R.id.listma);
        listView.setAdapter(adapter2);


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                En en = ob.get(i);
//
//                n = Integer.parseInt(en.getS3());
//                if(pl!=n)
//                {
//                    en.s3 = String.valueOf(n);
//                }
////                n++;
//                en.s3 = String.valueOf(n);
//
//
//                Toast.makeText(MainActivity3.this,n + " ",Toast.LENGTH_SHORT).show();
//            }
//        });

        btnHa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setContentView(R.layout.dest);
                TextView tvPri,tvqu;
                EditText etCoupon;
                Button btnCheckCoupon;
                Button btnProceedFur;

                tvPri = findViewById(R.id.tvPri);
                tvqu = findViewById(R.id.tvQui);
                etCoupon = findViewById(R.id.etCoupon);
                btnCheckCoupon = findViewById(R.id.btnCheckCoupon);
                btnProceedFur = findViewById(R.id.btnProceedFur);

                int gg = 0;


                for(int i=0;i<ob.size();i++)
                {
                    String nn = ob.get(i).getS2();

                    if(Integer.parseInt(ob.get(i).getS3()) == 0)
                    {
                        gg++;
                    }

                    String end = "";
                    end = nn.substring(0,nn.length()-2);

                    price += Integer.parseInt(end)*Integer.parseInt(ob.get(i).getS3());

//                    Toast.makeText(MainActivity3.this,end + " ",Toast.LENGTH_LONG).show();
                }


                tvqu.setText(String.valueOf(ob.size() - gg));
                tvPri.setText(String.valueOf(price));

                ans = price;

                btnCheckCoupon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nn = etCoupon.getText().toString().trim();
                        if(nn.equals("FIRSTUSER"))
                        {
                            int clc = price/2;

                            etCoupon.setVisibility(View.INVISIBLE);
                            btnCheckCoupon.setVisibility(View.INVISIBLE);
                            ans = clc;

//                            Toast.makeText(MainActivity3.this,"WORKED" ,Toast.LENGTH_SHORT).show();
                            tvPri.setText(String.valueOf(clc));

                        }
                        else
                        {
                            Toast.makeText(MainActivity3.this,"Invalid Code!" + nn,Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                btnProceedFur.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        startActivity(new Intent(MainActivity3.this,MainActivity8.class));

                        Intent intent = new Intent(MainActivity3.this, MainActivity8.class);
                        intent.putExtra("arg", ans+" ");
                        startActivity(intent);
                    }
                });

//                Toast.makeText(MainActivity3.this,price + " ",Toast.LENGTH_LONG).show();

            }
        });

    }

//    public void Decrement(View view) {
//
//        LinearLayout parentRow = (LinearLayout) view.getParent();
//
//        TextView quantityView = (TextView) parentRow.findViewById(R.id.whatqu);
//        String quantityString = quantityView.getText().toString();
//        desertNumber = Integer.parseInt(quantityString);
//        desertNumber -= 1;
//
//        if (desertNumber < 0) {
//            desertNumber = 0;
//            Toast.makeText(MainActivity3.this, "Can not be less than 0",
//                    Toast.LENGTH_SHORT).show();}
//        quantityView.setText(String.valueOf(desertNumber));
//    }
//
//    public void Increment(View view) {
//
//        LinearLayout parentRow = (LinearLayout) view.getParent();
//
//        TextView quantityView = (TextView) parentRow.findViewById(R.id.whatqu);
//        String quantityString = quantityView.getText().toString();
//        desertNumber = Integer.parseInt(quantityString);
//        desertNumber += 1;
//        pl = desertNumber;
//        quantityView.setText(String.valueOf(desertNumber));
//
//
//
//    }


}