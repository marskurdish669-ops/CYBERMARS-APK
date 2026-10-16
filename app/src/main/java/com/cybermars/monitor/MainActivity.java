package com.cybermars.monitor;

import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.content.Context;
import android.os.BatteryManager;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ScrollView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 40, 32, 32);
        layout.setGravity(Gravity.CENTER_VERTICAL);

        TextView title = new TextView(this);
        title.setText("CYBERMARS");
        title.setTextSize(30);
        title.setGravity(Gravity.CENTER);
        layout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("REMOTE MONITOR");
        subtitle.setTextSize(16);
        subtitle.setGravity(Gravity.CENTER);
        layout.addView(subtitle);

        BatteryManager batteryManager =
            (BatteryManager) getSystemService(Context.BATTERY_SERVICE);

        int level = batteryManager.getIntProperty(
            BatteryManager.BATTERY_PROPERTY_CAPACITY);

        TextView info = new TextView(this);
        info.setText(
            "\nDevice: " + Build.MANUFACTURER + " " + Build.MODEL +
            "\nAndroid: " + Build.VERSION.RELEASE +
            "\nSDK: " + Build.VERSION.SDK_INT +
            "\nBattery: " + (level >= 0 ? level + "%" : "Unavailable") +
            "\n\nThis app displays basic device information locally." +
            "\nNo data is sent to any server."
        );
        info.setTextSize(18);
        info.setPadding(0, 32, 0, 0);
        layout.addView(info);

        scroll.addView(layout);
        setContentView(scroll);
    }
}
