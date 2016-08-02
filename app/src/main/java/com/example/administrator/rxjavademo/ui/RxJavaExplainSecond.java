package com.example.administrator.rxjavademo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.rxjavademo.R;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * 类描述：RxJava的使用（二）Action
 * 创建人：quzongyang
 * 创建时间：2016/8/2. 12:04
 * 版本：
 */
public class RxJavaExplainSecond extends Activity{
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just("HellowWrold").subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Toast.makeText(RxJavaExplainSecond.this,s,Toast.LENGTH_SHORT).show();
                    }
                });

                //处理onNext()中的内容
                Action1<String> onNextAction = new Action1<String>() {
                    @Override
                    public void call(String s) {
                    }
                };

                //处理onError()中的内容
                Action1<Throwable> onErrorAction = new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                    }
                };

                //处理onCompleted()中的内容
                Action0 onCompletedAction = new Action0() {
                    @Override
                    public void call() {
                    }
                };
               /* Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("hello world");
                        subscriber.onCompleted();
                    }
                }).subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Toast.makeText(RxJavaExplainSecond.this,s,Toast.LENGTH_SHORT).show();
                    }
                });*/
            }
        });
    }
}
