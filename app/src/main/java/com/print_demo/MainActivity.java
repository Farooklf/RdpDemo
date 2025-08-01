package com.print_demo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;

import CTOS.CtPrint;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String TAG = "Saturn1000 Print demo";

        CtPrint print = new CtPrint();

        String print_font;
        int print_x = 0;
        int print_y = 36;
        int Currently_high = 20;
        int ret = 0;
        Bitmap bitmap = null;

//        print.initPage(200);
//        bitmap = print.encodeToBitmap("12ASDFSS34", print.QR_CODE, 150, 150);
//        print.drawImage(bitmap, 0, 0);
//        print.printPage();
//
//        ret = print.roll(10);
//        Log.d(TAG, String.format("Roll ret = %d", ret));
//
//        ret = print.status();
//        Log.d(TAG, String.format("status ret = %d", ret));
//
//        print.setHeatLevel(2);

        print.initPage(100);

        print_font = "PRINT TESTING";
        print.drawText(0, print_y + Currently_high, print_font, print_y, 1, false, (float) 0, false, false);
        print.drawText(0, print_y + Currently_high, print_font, print_y, 1, true, (float) 0, false, false);
        print.drawText(0, print_y + Currently_high, print_font, print_y, 1, false, (float) 0, true, false);
        print.drawText(0, print_y + Currently_high, print_font, print_y, 1, true, (float) 0, false, true);
        Currently_high += print_y;

        //Bitmap image = BitmapFactory.decodeFile("/data/" + "test.jpg");
        //print.drawImage(image, 0, Currently_high);

        print.printPage();
    }
}
