package com.bird_brown.progressapp01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンのオブジェクトの取得とイベントリスナ登録
        Button b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //ProgressBarのオブジェクトを取得
        ProgressBar bar = (ProgressBar)findViewById(R.id.progressBar1);

        //TextViewのオブジェクトを取得
        TextView text = (TextView)findViewById(R.id.textView1);

        //プログレスバーの現在値を取得
        int nowValue = bar.getProgress();

        //プログレスバーの最大値を取得
        int maxValue = bar.getMax();

        if (nowValue == maxValue) { //現在地と最大値が同じ
            nowValue = 0;
        } else { //現在値と最大値が同じでない
            bar.setVisibility(View.VISIBLE); //プログレスバー表示
            nowValue++;
        }

        String s;

        if (nowValue == 0) { //現在値が「０」
            bar.setVisibility(View.GONE); //プログレスバー非表示
            s = "ボタンを押してください。";
        } else { //現在地が「０」でない
            s = "現在処理中..." + nowValue;
        }

        //プログレスバーに現在値を設定
        bar.setProgress(nowValue);

        //TextViewに文字列を表示
        text.setText(s);
    }
}
