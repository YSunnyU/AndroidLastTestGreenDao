package com.sunny.androidlasttestgreendao;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.sunny.androidlasttestgreendao.bean.GreenDaoMess;

import java.io.Serializable;

public class AlertActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView alert_image;
    private EditText alert_name;
    private EditText alert_stage;
    private Button alert_btn;
    private Intent intent;
    private GreenDaoMess greenDaoMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        initView();
        initData();
    }

    private void initData() {
        intent = getIntent();
        greenDaoMess = (GreenDaoMess) intent.getSerializableExtra("mess");
        alert_name.setText(greenDaoMess.getName());
        alert_stage.setText(greenDaoMess.getStage());
        Picasso.with(this).load(greenDaoMess.getImage()).into(alert_image);


    }

    private void initView() {
        alert_image = (ImageView) findViewById(R.id.alert_image);
        alert_name = (EditText) findViewById(R.id.alert_name);
        alert_stage = (EditText) findViewById(R.id.alert_stage);
        alert_btn = (Button) findViewById(R.id.alert_btn);
        alert_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alert_btn:
               submit();

                break;
        }
    }

    private void submit() {
        // validate
        String name = alert_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "name不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String stage = alert_stage.getText().toString().trim();
        if (TextUtils.isEmpty(stage)) {
            Toast.makeText(this, "stage不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("messTwo",new GreenDaoMess(greenDaoMess.getImage(),name,stage));
        setResult(8, intent);
        finish();
        // TODO validate success, do something


    }
}
