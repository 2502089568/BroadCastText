package com.example.zz.broadcasttext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class BC2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String s =intent.getStringExtra("msg");
        Log.d("BC2","reveiver2收到消息"+s);
        Bundle bundle =getResultExtras(true);//是否得到返回值
        String s2 = bundle.getString("test");
        Log.d("BC2","得到处理数据"+s2);
    }
}
