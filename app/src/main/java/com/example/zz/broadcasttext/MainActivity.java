package com.example.zz.broadcasttext;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BC3 bc3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cast(View view){
        Toast.makeText(this,"广播已发送",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("msg","这是一条广播");
        intent.setAction("BC_One");//静态注册时要<intent-filter><action android:name="BC_One"/></intent-filter>
        sendBroadcast(intent);
    }
//有序广播
    public void cast2(View view){
        Toast.makeText(this,"广播已发送",Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent();
        intent2.putExtra("msg","这是一条有序广播");
        intent2.setAction("BC_Two");//静态注册时要<intent-filter><action android:name="BC_One"/></intent-filter>
        sendOrderedBroadcast(intent2,null);
    }
//异步广播
    public void cast3(View view){
        Toast.makeText(this,"广播已发送",Toast.LENGTH_SHORT).show();
        Intent intent3 = new Intent();
        intent3.putExtra("msg","这是一条异步广播");
        intent3.setAction("BC_Three");//静态注册时要<intent-filter><action android:name="BC_One"/></intent-filter>
        sendStickyBroadcast(intent3);
        IntentFilter filter =new IntentFilter();
        filter.addAction("BC_Three");
        bc3 = new BC3();
        registerReceiver(bc3,filter);
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bc3);//动态注册一定要注销掉
    }
}
