package com.example.administrator.rxjavademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.rxjavademo.ui.RxJavaExplainFirst;
import com.example.administrator.rxjavademo.ui.RxJavaExplainFouth;
import com.example.administrator.rxjavademo.ui.RxJavaExplainSecond;
import com.example.administrator.rxjavademo.ui.RxJavaExplainThird;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {
    public String TAG = this.getClass().getName();
    private String[] activity_names;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        activity_names = getResources().getStringArray(R.array.activity_names);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, activity_names));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    startActivity(new Intent(MainActivity.this, RxJavaExplainFirst.class));
                }else if(position == 1){
                    startActivity(new Intent(MainActivity.this, RxJavaExplainSecond.class));
                }else if(position == 2){
                    startActivity(new Intent(MainActivity.this, RxJavaExplainThird.class));
                }else if(position == 3){
                    startActivity(new Intent(MainActivity.this, RxJavaExplainFouth.class));
                }
            }
        });

    }
}
