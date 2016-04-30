package kr.co.atomicsoft.android.fixer;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindErrorActivity extends AppCompatActivity {
    List<String> list;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_error);

        String findText = "";
        Intent intent = getIntent();
        category = intent.getStringExtra("category");

        if(category.contains("1")) {
            findText = getString(R.string.sys_var);
            TextView textView = (TextView) findViewById(R.id.errorCodeText);
            textView.setText(findText);

            try {
                InputStream is = getAssets().open("sysvars.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                if (list == null) list = new ArrayList<String>();
                String str;
                while ((str = br.readLine()) != null) {
                    list.add(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                AssetManager assetManager = getApplicationContext().getAssets();
                InputStream is = assetManager.open("factories.xml");
                XmlPullParserFactory factory = null;

                factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xrp = factory.newPullParser();
                xrp.setInput(is, "UTF-8");
                BufferedReader reader = new BufferedReader((new InputStreamReader(is)));

            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            list = Arrays.asList(getResources().getStringArray(R.array.errors));
        }

        Button button = (Button)findViewById(R.id.findErrorButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listView;

                if (category.contains("1")) {
                    listView = GetSysvarList();
                } else {
                    listView = GetErrorList();
                }

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(FindErrorActivity.this, ErrorDetailActivity.class);
                        ListView listview = (ListView) findViewById(R.id.errorListView);
                        ErrorListItem item = (ErrorListItem)listview.getAdapter().getItem(position);
                        intent.putExtra("fileName", item.getFileName());
                        intent.putExtra("nameCode", item.getNameCode());
                        intent.putExtra("descript", item.getDescript());
                        startActivity(intent);
                    }
                });
            }
        });

    }

    private ListView GetSysvarList() {

        String key = ((EditText)findViewById(R.id.findErrorText)).getText().toString();

        // 리스트뷰 참조 및 Adapter달기
        ListView listView = (ListView) findViewById(R.id.errorListView);

        // Adapter 생성
        SysvarListAdapter adapter = new SysvarListAdapter() ;

        listView.setAdapter(adapter);

        for(int n=0; n<list.size(); n++) {
            String str = list.get(n);
            if (str.contains(key))
            {
                String[] splits = str.split("\\|", 3);
                adapter.addItem(splits[0], splits[1], splits[2]);
            }
        }

        return listView;


    }

    private ListView GetErrorList() {

        String key = ((EditText)findViewById(R.id.findErrorText)).getText().toString();

        // 리스트뷰 참조 및 Adapter달기
        ListView listView = (ListView) findViewById(R.id.errorListView);

        // Adapter 생성
        ErrorListAdapter adapter = new ErrorListAdapter() ;

        listView.setAdapter(adapter);

        for(int n=0; n<list.size(); n++) {
            String str = list.get(n);
            if (str.contains(key))
            {
                String[] splits = str.split("\\|", 2);
                adapter.addItem(splits[0], splits[1]);
            }
        }

        return listView;

    }
}
