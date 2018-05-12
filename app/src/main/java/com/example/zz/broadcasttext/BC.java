package com.example.zz.broadcasttext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class BC extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("收到广播",intent.getStringExtra("msg"));
        //abortBroadcast();
        Bundle bundle = new Bundle();
        bundle.putString("test","广播处理的数据");
        setResultExtras(bundle);
    }
}
