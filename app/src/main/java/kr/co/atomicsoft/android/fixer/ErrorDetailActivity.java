package kr.co.atomicsoft.android.fixer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class ErrorDetailActivity extends AppCompatActivity {
    String fileName;
    String nameCode;
    String descript;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        fileName = intent.getStringExtra("fileName");
        nameCode = intent.getStringExtra("nameCode");
        descript = intent.getStringExtra("descript");

        ((TextView)findViewById(R.id.errorNameCodeText)).setText(nameCode);
        ((TextView)findViewById(R.id.errorDescriptText)).setText(descript);

        ((WebView)findViewById(R.id.errorWebView)).loadUrl(
                "file:///android_asset/"+fileName+".html");
        //WebView.loadData(source, "text/html", "UTF-8");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "틀린 내용 알리기", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

                Intent intent = new Intent(ErrorDetailActivity.this, SendReportActivity.class);
                intent.putExtra("fileName", fileName);
                intent.putExtra("nameCode", nameCode);
                intent.putExtra("descript", descript);
                startActivity(intent);
            }
        });
    }

}
