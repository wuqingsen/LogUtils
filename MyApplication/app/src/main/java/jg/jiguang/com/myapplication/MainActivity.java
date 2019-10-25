package jg.jiguang.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import jg.jiguang.com.myapplication.utils.LogFileUtils;
import jg.jiguang.com.myapplication.utils.LogUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText logEdit, titleEdit;
    private Button logButton, checkButton;
    TextView tv_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logEdit = (EditText) findViewById(R.id.et_log);
        titleEdit = (EditText) findViewById(R.id.et_title);
        logButton = (Button) findViewById(R.id.btn_log);
        tv_log = (TextView) findViewById(R.id.tv_log);
        checkButton = (Button) findViewById(R.id.btn_check);
        logButton.setOnClickListener(this);
        checkButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_log:
                String title = titleEdit.getText().toString().trim();
                String log = logEdit.getText().toString().trim();
                //添加日志
                LogUtils.i(title, log);
                Toast.makeText(MainActivity.this, "添加日志成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_check:
                //取出日志
                tv_log.setText(LogFileUtils.readLogText());
                break;
        }
    }
}
