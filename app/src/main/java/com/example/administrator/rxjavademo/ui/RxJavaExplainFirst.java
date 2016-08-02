package com.example.administrator.rxjavademo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * 类描述：RxJava的使用（一）基本用法
 * 创建人：quzongyang
 * 创建时间：2016/8/2. 11:45
 * 版本：
 */
public class RxJavaExplainFirst extends Activity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subscriber<String> observer = new Subscriber<String>() {
                    @Override
                    public void onStart() {
                        Toast.makeText(RxJavaExplainFirst.this, "start", Toast.LENGTH_SHORT).show();
                        super.onStart();
                    }

                    @Override
                    public void onCompleted() {
                        Toast.makeText(RxJavaExplainFirst.this, "Complete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxJavaExplainFirst.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(String s) {
                        Toast.makeText(RxJavaExplainFirst.this, s, Toast.LENGTH_SHORT).show();
                    }
                };
                 /*Observer<String> observer = new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(RxJavaExplainFirst.this,"Complete",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxJavaExplainFirst.this,"Error",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNext(String s) {
                        Toast.makeText(RxJavaExplainFirst.this,s,Toast.LENGTH_SHORT).show();
                    }
                 };*/

                Observable<String> observable1 = Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Hello");
                        subscriber.onNext("World");
                        subscriber.onCompleted();
                    }
                });


                Observable observable2 = Observable.just("Hello", "World");

                String[] words = {"Hello", "World"};
                Observable observable3 = Observable.from(words);

                List<String> list = new ArrayList<String>();
                list.add("Hellow");
                list.add("Wrold");
                Observable observable4 = Observable.from(list);

                observable1.subscribe(observer);
            }
        });


    }
}
