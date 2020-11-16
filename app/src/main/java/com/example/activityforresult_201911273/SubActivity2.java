package com.example.activityforresult_201911273;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class SubActivity2 extends AppCompatActivity {
    EditText edit2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);//sub2.xml을 레이아웃으로 갖는다

        edit2 = (EditText) findViewById(R.id.sub2_edit);
        Button button_ok2 = (Button) findViewById(R.id.button_ok2);//확인버튼
        //확인 버튼이 눌리면 SubActivity2를 종료하고 문자열을 전달
        button_ok2.setOnClickListener(new View.OnClickListener() {//확인버튼이 눌렸을때
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();//새 인텐트 객체 생성
                intent.putExtra("INPUT_TEXT2", edit2.getText().toString());//문자열 전달
                setResult(RESULT_OK, intent);//확인 버튼이 눌렸음을 알려줌
                finish();//SubActivity2종료
            }
        });
        Button button_cancel2 = (Button) findViewById(R.id.button_cancel2);//취소버튼
        //취소 버튼이 눌리면 취소되었음을 알려주고 종료
        button_cancel2.setOnClickListener(new View.OnClickListener() {//
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();//subActivity2종료
            }
        });
    }
}