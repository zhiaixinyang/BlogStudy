package com.mdove.app1;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aaa(View view) {
//        Intent resolveIntent = getPackageManager().getLaunchIntentForPackage("com.mdove.app2");// 这里的packname就是从上面得到的目标apk的包名
//        // 启动目标应用
//        startActivity(resolveIntent);
        Intent toStart = new Intent(Intent.ACTION_VIEW);
        toStart.setClassName("com.mdove.app2", "com.mdove.app2.SBActivity");
        startActivity(toStart);
    }
}
