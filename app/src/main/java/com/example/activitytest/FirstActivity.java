package com.example.activitytest;
        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;
       /*Activity类的7个回调方法
        * onCreate()，活动第一次被创建的时候调用
        * onStart()，活动由不可见变为可见的时候调用
        * onResume()，活动准备好和用户进行交互的时候调用，此时活动一定位于栈顶，并且处于运行状态
        * onPause()，系统准备去启动或者恢复另一个活动时候调用，通常会将一些小号CPU资源释放掉，以及保存一些关键数据
        * onStop(),在活动完全不可见的时候调用，和onPause()主要区别数，如果新启动的活动是一个对话框式的活动，前者不会执行，后者会执行
        * onDestory(),销毁之前调用
        * onRestart()，停止状态变为运行状态之前调用，也就是活动被重新启动了*/
public class FirstActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//创建菜单
       getMenuInflater().inflate(R.menu.main,menu);
       return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {//加载菜单menu，給菜单按钮设置动作
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You click the add button",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You click the remove button",Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }

    @Override//接受上一个活动回传的数据
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
                   switch(requestCode){
                       case 1:
                           if(resultCode==RESULT_OK){
                               String str = data.getStringExtra("back_data");
                               Log.d("FirstActivity",str);
                           }
                       default:
                   }
    }

    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.first_layout);//加载布局
            Button button1 = (Button) findViewById(R.id.Button_1);
            button1.setOnClickListener(new View.OnClickListener() {//按钮监听器
                @Override
                public void onClick(View v) {

                    //隐式intent跳转，ACTION_VIEW为常置动作，跳转网页作用
                    //ACtion_VIEW在注册文件里的初始值为android.intent.action.VIEW
                    //android:scheme是指其域名即http之类的，android:host是网址。
                    //Uri.parse方法是把字符串形式的网址变成Uri对象的形式，再用setData存入。
                    /*Intent intent =  new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.baidu.com"));
                    startActivity(intent);*/

                    //显式intent传输，向下一个活动传输数据
                    /*Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                    String data  = "Hello Stupid world";
                    intent.putExtra("extra_data",data);
                    startActivity(intent);*/

                    //向上一个活动返回数据的startActivyForResult方法
                    Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                    startActivityForResult(intent,1);
                }
            });
    }
}