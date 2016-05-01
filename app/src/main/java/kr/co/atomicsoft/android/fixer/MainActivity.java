package kr.co.atomicsoft.android.fixer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
        startActivity(intent);

        ImageButton findErrorButton = (ImageButton)findViewById(R.id.findErrorButton);
        findErrorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FindErrorActivity.class);
                intent.putExtra("category", "0");
                startActivity(intent);
            }
        });

        ImageButton selectManualButton = (ImageButton)findViewById(R.id.selectManualButton);
        selectManualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectFactoryActivity.class);
                startActivity(intent);
            }
        });

        ImageButton findSysVarButton = (ImageButton)findViewById(R.id.findSysVarButton);
        findSysVarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FindErrorActivity.class);
                intent.putExtra("category", "1");
                startActivity(intent);
            }
        });

        ImageButton sendReportButton = (ImageButton)findViewById(R.id.sendReportButton);
        sendReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SendReportActivity.class);
                intent.putExtra("fileName", "");
                intent.putExtra("nameCode", "담당자에게...");
                intent.putExtra("descript", "틀린 내용을 적어주세요.");
                startActivity(intent);
            }
        });

        ImageButton exitButton = (ImageButton)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
