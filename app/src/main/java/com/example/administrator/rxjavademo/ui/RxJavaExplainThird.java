package com.example.administrator.rxjavademo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.rxjavademo.R;
import com.example.administrator.rxjavademo.bean.Student;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 类描述：RxJava的使用（三）转换——map、flatMap
 * 创建人：quzongyang
 * 创建时间：2016/8/2. 14:45
 * 版本：
 */
public class RxJavaExplainThird extends Activity{

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //多次使用map，想用几个用几个
                Observable.just("Hello", "World")
                        //使用map进行转换，参数1：转换前的类型，参数2：转换后的类型
                        .map(new Func1<String, Integer>() {//将String类型的转化为Integer类型的哈希码
                            @Override
                            public Integer call(String s) {
                                return s.hashCode();
                            }
                        })
                        .map(new Func1<Integer, String>() {//将转化后得到的Integer类型的哈希码再转化为String类型
                            @Override
                            public String call(Integer integer) {
                                return integer.intValue() + "-->";
                            }
                        })
                        .subscribe(new Action1<String>() {
                            @Override
                            public void call(String s) {
                                Toast.makeText(RxJavaExplainThird.this,s, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
