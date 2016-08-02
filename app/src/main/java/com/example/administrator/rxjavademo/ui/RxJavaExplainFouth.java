package com.example.administrator.rxjavademo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.rxjavademo.R;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 类描述：RxJava的使用（四）线程控制 —— Scheduler
 * 创建人：quzongyang
 * 创建时间：2016/8/2. 16:18
 * 版本：
 */
public class RxJavaExplainFouth extends Activity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just("Hello", "Word")
                        .subscribeOn(Schedulers.io())//指定 subscribe() 发生在新的线程
                        .observeOn(AndroidSchedulers.mainThread())// 指定 Subscriber 的回调发生在主线程
                        .subscribe(new Action1<String>() {
                            @Override
                            public void call(String s) {

                                Toast.makeText(RxJavaExplainFouth.this, s, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}
