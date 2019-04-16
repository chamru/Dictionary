package com.example.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class MainActivity<map> extends AppCompatActivity {

    public static final String Countries[] = {

            "Nepal" , "Kathmandu",
            "India", "delhi",
            "China", "beijing",
            "Japan","tokiyo",
            "chotu ko ghar","sunakoti",
    };

    private Map<String,String> country;

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.lv);
        country=new HashMap<>();
        for (int i=0; i<Countries.length; i+=2){
            country.put(Countries[i],Countries[i+1]);

        }

        ArrayAdapter countryAdapter = new ArrayAdapter <> (
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<>(country.keySet())

        );
        lv.setAdapter(countryAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String countrys=parent.getItemAtPosition(position).toString();
                String capital=country.get(countrys);
                Toast.makeText(getApplicationContext(),capital.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
