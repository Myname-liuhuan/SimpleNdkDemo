package com.example.simplendkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double forTime = 100000000;
    TextView tv;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.textView01);
        Button button01=(Button)findViewById(R.id.button01);
//        tv.setText(stringFromJNI());

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double duration =timeforc(forTime);
                //下面计算Java做相同的操作需要的时间
                double start =System.currentTimeMillis();
                while(forTime>0){
                    int a=1,b=1;
                    a=a+b;
                    forTime--;
                }
                double end=System.currentTimeMillis();
                double temp=(end-start)/1000;
                double abc=temp/duration;

                StringBuffer str=new StringBuffer();
                str.append("运行一亿次for循环计算两数相加的时间分别是:\n");
                str.append("C++: "+String.valueOf(duration)+"秒\n");
                str.append("Java:"+String.valueOf(temp)+"秒\n");
                str.append("结果是C++的运行速度是Java的"+String.valueOf(abc)+"倍");

                tv.setText(str);
            }
        });



    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native double timeforc(double forTimea);
}
