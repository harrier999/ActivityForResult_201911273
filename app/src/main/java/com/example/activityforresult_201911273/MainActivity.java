package com.example.activityforresult_201911273;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text;
    TextView text2;
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_main);//activity_main.xml를 레이아웃으로 갖는다

        Button button = (Button) findViewById(R.id.button); //SubActivity 실행 버튼
        text = (TextView) findViewById(R.id.text); //SubActivity의 입력값을 받는다
        text2 = (TextView) findViewById(R.id.text2); //SubActivity2의 입력값을 받는다

        //버튼이 눌리면 SubActivity를 실행하기위한 intent 객체를 생성하고 값을 받아온다
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0){
                Intent in = new Intent(MainActivity.this,SubActivity.class);//SubActivity객체 생성
                startActivityForResult(in,GET_STRING);//엑티비티 전환
            }
        });
    }
    @Override//엑티비티를 전환하고 결과값을 받아왔을 때
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {//string을 받아왔을 떄
            if (resultCode == RESULT_OK) {//확인 버튼이 눌렸을 때
                text.setText(data.getStringExtra("INPUT_TEXT")); //subActivity에서 받은 값을 text에 저장
                text2.setText(data.getStringExtra("INPUT_TEXT2"));//subActivity2에서 받은 값을 text2에 저장
            }
        }
    }

}