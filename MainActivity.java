package com.example.w0143446.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] web = {
            "Image 1",
            "Image 2",
            "Image 3",
            "Image 4",
            "Image 5",
            "Image 6",
            "Image 7"
    } ;
    Integer[] imageId = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomList adapter = new CustomList(MainActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " + position, Toast.LENGTH_SHORT).show();
                //create a new intent, pass image, send intent
                //Intent myintent = getIntent();
                Intent myIntent = new Intent(MainActivity.this, FullscreenActivity.class);

                myIntent.putExtra("web", web[+ position]);
                //System.out.println(getResources(imageId[+ position]));
                myIntent.putExtra("image", (Integer) imageId[position]);
                startActivity(myIntent); //no result expected back
            }
        });
    }
}