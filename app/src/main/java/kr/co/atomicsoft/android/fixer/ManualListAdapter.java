package kr.co.atomicsoft.android.fixer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dnest on 2016. 4. 25..
 */
public class ManualListAdapter extends BaseAdapter {
    private ArrayList<ManualListItem> list = new ArrayList<ManualListItem>();

    public ManualListAdapter(){}


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_error_list_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        //ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.errorNameCodeText) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.errorDescriptText) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ManualListItem item = list.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        //iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(item.getNameCode());
        descTextView.setText(item.getDescript());

        return convertView;
    }

    //public void addItem(Drawable icon, String title, String desc) {
    public void addItem(String title, String desc) {
        ManualListItem item = new ManualListItem();

        //item.setIcon(icon);
        item.setFileName(title);
        item.setNameCode(title);
        item.setDescript(desc);

        list.add(item);
    }
}
