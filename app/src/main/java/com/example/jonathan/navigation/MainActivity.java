package com.example.jonathan.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayAdapter <String> listAdpter;
    String  fragmentArray[]= {"FRAGMENT 1","FRAGMENT 2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        listView = (ListView) findViewById(R.id.listview);
        listAdpter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fragmentArray);
        listView.setAdapter(listAdpter);

        listView.setOnClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Fragment fragment;

                switch (position){
                    case 0 :

                        fragment =  new fragmentOne();
                break;
                    case 1:
                        fragment =  new fragmentTwo();
                        break;

                    default:

                        fragment = new fragmentOne();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit();
            }
            };
}
}
