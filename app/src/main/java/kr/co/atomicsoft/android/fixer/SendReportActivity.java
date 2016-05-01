package kr.co.atomicsoft.android.fixer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SendReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_report);

        Intent intent = getIntent();
        String fileName = intent.getStringExtra("fileName");
        String nameCode = intent.getStringExtra("nameCode");
        String descript = intent.getStringExtra("descript");

        ((TextView)findViewById(R.id.reportNameCodeText)).setText(nameCode);
        ((TextView)findViewById(R.id.reportDescriptText)).setText(descript);

        Button button = (Button)findViewById(R.id.sendButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
