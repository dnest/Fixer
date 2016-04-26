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

public class ManualDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "틀린 내용 알리기", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

                Intent intent = new Intent(ManualDetailActivity.this, SendReportActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String nameCode = intent.getStringExtra("nameCode");
        String descript = intent.getStringExtra("descript");

        ((TextView)findViewById(R.id.manualNameCodeText)).setText(nameCode);
        ((TextView)findViewById(R.id.manualDescriptText)).setText(descript);

        ((WebView)findViewById(R.id.manualWebView)).loadUrl(
                "file:///android_asset/" + nameCode + ".html");
        //WebView.loadData(source, "text/html", "UTF-8"
    }

}
