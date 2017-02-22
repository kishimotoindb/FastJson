package com.example.root.fastjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/*
 * 问题列表：
 * 1.Json.toJsonString(Map<String,String>)和Json.toJsonString(Map<String,Object>)分别返回的是什么格式的
 *   字符串?
 *   结论:
 *   见onCreate()方法中问题1部分
 *
 *
 * 2.fastjson将数据解析为何种类型，与value是不是被双引号包裹没有关系，其根据传入的对象中相应字段的类型，决定将value解析为何种类型。
 *
 * 3.Json.parse(jsonString)解析出来的是什么?
 * 结论:
 * String json = "{'a':1,'b':2}";
 * Json.parse(json)
 * map包含两个元素:1.<a,1> 2.<b,2>
 */


public class MainActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mTv = (TextView) findViewById(R.id.tv);
//        Person cui = new Person("cui", 112);
////        Log.i("xiong", "JSON.toJSON(cui)" + JSON.toJSON(cui));
//        Log.i("xiong", "JSON.toJSONString(cui)" + JSON.toJSONString(cui));
//        Map<String, Object> map =  (Map<String, Object>) JSON.parse(JSON.toJSONString(cui));

        //问题1
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "string1");
        map.put("key2", "string2");
        map.put("key3", "string3");
        String s = JSON.toJSONString(map); //s={"key2":"string2","key1":"string1","key3":"string3"}

        Person a = new Person("a", 1);
        Person b = new Person("b", 2);
        Person c = new Person("c", 3);
        HashMap<String, Person> map1 = new HashMap<>();
        map1.put("p1", a);
        map1.put("p2", b);
        map1.put("p3", c);
        String s1 = JSON.toJSONString(map1); //s1={"p3":{"age":3,"name":"c"},"p2":{"age":2,"name":"b"},"p1":{"age":1,"name":"a"}}

        //2.用于判断：fastjson解析的数据类型是根据对象还是json本身
//        String json2="{\"a\":\"1.2\"}";
////        A a = JSON.parseObject(json2, A.class);
//        B b = JSON.parseObject(json2, B.class);
//        C c = JSON.parseObject(json2, C.class);

        //问题3
//        String json = "{'a':1,'b':2}";
//        Map<String, Object> map = (Map<String, Object>) JSON.parse(json); // map包含两个元素:1.<a,1> 2.<b,2>
//        Object parse = JSON.parse(json);// parse()这个方法返回的Object就是Map类型
    }
}

//2.用于判断：fastjson解析的数据类型是根据对象还是json本身
class A {
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

//2.用于判断：fastjson解析的数据类型是根据对象还是json本身
class B {
    String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}

//2.用于判断：fastjson解析的数据类型是根据对象还是json本身
class C {
    double a;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }
}