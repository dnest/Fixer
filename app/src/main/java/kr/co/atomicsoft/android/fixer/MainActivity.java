package kr.co.atomicsoft.android.fixer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
        startActivity(intent);

        Button findErrorButton = (Button)findViewById(R.id.findErrorButton);
        findErrorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FindErrorActivity.class);
                startActivity(intent);
            }
        });

        Button selectManualButton = (Button)findViewById(R.id.selectManualButton);
        selectManualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectFactoryActivity.class);
                startActivity(intent);
            }
        });

        Button sendReportButton = (Button)findViewById(R.id.sendReportButton);
        sendReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SendReportActivity.class);
                startActivity(intent);
            }
        });

        Button exitButton = (Button)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
