package kr.co.atomicsoft.android.fixer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class FindErrorActivity extends AppCompatActivity {
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_error);

        Button button = (Button)findViewById(R.id.findErrorButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindErrorCode();
            }
        });

        list = Arrays.asList(getResources().getStringArray(R.array.errors));
    }


    private void FindErrorCode() {

        String key = ((EditText)findViewById(R.id.findErrorText)).getText().toString();

        // Adapter 생성
        ErrorListAdapter adapter = new ErrorListAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        ListView listview = (ListView) findViewById(R.id.errorListView);
        listview.setAdapter(adapter);

        for(int n=0; n<list.size(); n++) {
            String str = list.get(n);
            if (str.contains(key))
            {
                String[] splits = str.split("\\|", 2);
                adapter.addItem(splits[0], splits[1]);
            }
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FindErrorActivity.this, ErrorDetailActivity.class);
                ListView listview = (ListView) findViewById(R.id.errorListView);
                ErrorListItem item = (ErrorListItem)listview.getAdapter().getItem(position);
                intent.putExtra("nameCode", item.getNameCode());
                intent.putExtra("descript", item.getDescript());
                startActivity(intent);
            }
        });
    }
}
