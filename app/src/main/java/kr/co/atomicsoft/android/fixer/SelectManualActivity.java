package kr.co.atomicsoft.android.fixer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class SelectManualActivity extends AppCompatActivity {
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_manual);

        list = Arrays.asList(getResources().getStringArray(R.array.manuals));

        ManualListAdapter adapter = new ManualListAdapter();
        ListView listview = (ListView)findViewById(R.id.manualListView);
        listview.setAdapter(adapter);

        for(int n=0; n<list.size(); n++)
        {
            String string = list.get(n);
            String[] splits = string.split("\\|",2);
            adapter.addItem(splits[0], splits[1]);
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectManualActivity.this, ManualDetailActivity.class);
                ListView listview = (ListView) findViewById(R.id.manualListView);
                ManualListItem item = (ManualListItem)listview.getAdapter().getItem(position);
                intent.putExtra("fileName", item.getFileName());
                intent.putExtra("nameCode", item.getNameCode());
                intent.putExtra("descript", item.getDescript());
                startActivity(intent);

            }
        });
    }
}
