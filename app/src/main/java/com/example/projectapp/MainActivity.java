package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String number = "";

//    @Override
//    public void onBackPressed() {
//        moveTaskToBack(true);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Ent> ob = new ArrayList<>();
        ob.add(new Ent(R.drawable.chickenkababti,"Chicken Kabab Tikka","Chicken Tikka Kebab are tender cooked chunks of chicken marinated in yogurt and spices that is cooked to perfection with mixed peppers and onions. ","500rs"));
        ob.add(new Ent(R.drawable.chickenkeema,"Chicken Keema","Chicken Keema Matar Recipe (Indian Chicken Mince Curry) – popular Indian chicken keema curry recipe made using ground chicken, peas and curry spices.","240rs"));
        ob.add(new Ent(R.drawable.chickenbiryani,"Chicken Biryani","A world-renowned Indian dish, biryani takes time and practice to make but is worth every bit of the effort. ","180rs"));
        ob.add(new Ent(R.drawable.chickensoup,"Chicken soup","The classic chicken soup consists of a clear chicken broth, often with pieces of chicken or vegetables; common additions are pasta, noodles, dumplings, or grains such as rice and barley.","80rs"));
        ob.add(new Ent(R.drawable.chickenkorma,"Chicken Korma","Korma curries are spiced not for heat, but for flavor. Rather than cumin and black pepper, korma goes for flavors such as cardamom and cinnamon.","200rs"));

        ob.add(new Ent(R.drawable.fishkababtik,"Fish Kabab Tikka"," It is made by marinating the pieces in spices and yoghurt and cooking them in a tandoor.","430rs"));
        ob.add(new Ent(R.drawable.fishkeema,"Fish Keema","Fish fillets that are boneless and skinless works best for keema recipe.","410rs"));
        ob.add(new Ent(R.drawable.fishbiryani,"Fish Biryani","Long-grained rice (like basmati) flavored with fragrant spices such as saffron and layered with lamb, chicken, fish, or vegetables and a thick gravy.","180rs"));
        ob.add(new Ent(R.drawable.fishsoup,"Fish soup","Cioppino, bourride, brodetto, cacciucco, zarzuela, gumbo. Fish soup. Shellfish stew. Beyond a wealth in tradition, what they have in common is the use of several varieties of fish or seafood cooked in one pot with vegetables and aromatics.","120rs"));
        ob.add(new Ent(R.drawable.fishkorma,"Fish Korma","A delicious recipe to turn white fish fillets into a heavenly curry. This tempting dish features a korma paste made using garlic, chilli, cumin and turmeric.","120rs"));

        ob.add(new Ent(R.drawable.soup,"Soup","a liquid dish, typically savoury and made by boiling meat, fish, or vegetables etc. in stock or water.","380rs"));
        ob.add(new Ent(R.drawable.pannertikka,"Panner Tikka","Paneer Tikka is popular Indian appetizer made with cubes of paneer & veggies marinated with yogurt and spices. ","200rs"));
        ob.add(new Ent(R.drawable.vegbiryani,"Veg Biryani","Vegetable biryani is an aromatic rice dish made by cooking basmati rice with mix veggies, herbs & biryani spices. ","180rs"));
        ob.add(new Ent(R.drawable.pannerpalak,"Panner palak","This palak paneer tastes just like the Indian restaurant! Rich and creamy, made from spinach and the creamy Indian cheese, paneer, this curry is a healthy vegetarian dinner","200rs"));
        ob.add(new Ent(R.drawable.rice,"Rice","Rice, (Oryza sativa), edible starchy cereal grain and the grass plant (family Poaceae) by which it is produced.","80rs"));

        Button btnSubmit = findViewById(R.id.submit);
        HashMap<String, String> capitalCities = new HashMap<String, String>();


        Addapter addapter = new Addapter(this,ob);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(addapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Ent ent = ob.get(i);


//                number += ent.getS4();

                capitalCities.put(ent.getS2(),ent.getS4());

//                number += "Item : " + ent.getS2() + "\n" + "Price : " + ent.getS4() + "\n";


//                if(ent.getUrl() == "43")
//                {
//                    Toast.makeText(Monday.this,"No URL Please Check",Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(ent.getUrl()));
//                    startActivity(intent);
//
//                }



            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                setContentView(R.layout.activity_main2);
//
//                String kks = "";
//
//                for (String i : capitalCities.keySet()) {
//                    kks+=i + "  " + capitalCities.get(i) + "\n";
//                }
//
//                TextView textView = findViewById(R.id.textView);
//                textView.setText(kks);

                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                intent.putExtra("hashMap", capitalCities);
                startActivity(intent);
//                finish();

            }
        });
        


    }
}