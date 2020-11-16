package com.example.activityforresult_201911273;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text_sub2;
    EditText edit;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);//sub.xml을 레이아웃으로 갖는다.

        edit = (EditText) findViewById(R.id.edit);//문자열을 받을 edit
        Button button_ok = (Button) findViewById(R.id.button_ok);//확인버튼

        //확인 버튼이 눌렸을 때 SubActivity와 SubActivity2로부터 받은 값을 전달해주고 종료, mainActivity로 전환
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();//인탠트 객체 생성
                intent.putExtra("INPUT_TEXT",edit.getText().toString()); //SubActivity로부터 받은 값
                intent.putExtra("INPUT_TEXT2",text_sub2.getText().toString());//SubActivity2로부터 받은 값을 INPUT_TEXT, 2에 저장
                setResult(RESULT_OK,intent);
                finish();//SubAcitivity 종료
            }
        });
        Button button_cancel = (Button) findViewById(R.id.button_cancel);//취소버튼

        //SubActivity를 종료하고 MainActivity로 전환
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);//취소됐음을 알림
                finish();//subActivity종료
            }
        });
        Button button = (Button) findViewById(R.id.button_sub2);//2차 데이터를 입력하고 싶을 때 누르는 버튼
        text_sub2 = (TextView) findViewById(R.id.text_sub2);

        //버튼이 눌리면 SubActivity2로 전환하고 입력받는다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0){
                Intent in = new Intent(SubActivity.this,SubActivity2.class);//SubActivity2 객체 생성
                startActivityForResult(in,GET_STRING);//전환
            }
        });
    }
    //SubActivity2로 부터 문자열을 반환 받았을 때
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {//
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {//문자열을 받았을 떄
            if (resultCode == RESULT_OK) {//확인버튼이 눌렸을 때
                text_sub2.setText(data.getStringExtra("INPUT_TEXT2"));//문자열을 INPUT_TEXT2에 저장
            }
        }
    }
}