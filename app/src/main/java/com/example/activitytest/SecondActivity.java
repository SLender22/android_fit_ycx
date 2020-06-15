package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    //重写了onBackPressed*()方法，也就是按返回键时的方法
    /*public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("back_data","Hello Stupid world!");
        setResult(RESULT_OK,intent);
        finish();
    }*/

    //企业化的活动启动方式
    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("need1",data1);
        intent.putExtra("need2",data2);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //接受上一级活动传输的数据，用intent。getStringExtra（）方法，中间的类型可以改变
        /*Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("SecondActivity",data);*/

        Button button2 =(Button) findViewById(R.id.Button_2);
        button2.setOnClickListener(new View.OnClickListener(){
                  public void onClick(View v){
                      Intent intent = new Intent();
                      intent.putExtra("back_data","Hello stupid World!");
                      setResult(RESULT_OK,intent);
                      finish();
                  }

        }
        );
    }
}
