package com.example.animal_helpers;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.animal_helpers.models.JobPost;

import java.util.ArrayList;

public class JobPostAdapter extends BaseAdapter {

    ArrayList<JobPost> listViewItemList = new ArrayList<>();
    Context context;
    String[] result = null;
    String mDate = "";

    public JobPostAdapter(){}

    @Override
    public int getCount() { return listViewItemList.size(); }

    @Override
    public Object getItem(int position) { return listViewItemList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        JobPost listViewItem = listViewItemList.get(position);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item,parent,false);
        }

        TextView titleText = convertView.findViewById(R.id.textview_title);
        TextView addressText = convertView.findViewById(R.id.textview_address);
        TextView storeText = convertView.findViewById(R.id.textview_store);
        TextView dateText = convertView.findViewById(R.id.textview_date);

        titleText.setText(listViewItem.getTitle());
        addressText.setText(listViewItem.getAddress());
        storeText.setText(listViewItem.getStore());
        dateText.setText(listViewItem.getDate());

        return convertView;
    }

    public void addItem(String Uid, String title, String address, String store, String date) {
        JobPost item = new JobPost();


        item.setUid(Uid);
        item.setTitle(title);
        item.setAddress(address);
        item.setStore(store);
        item.setDate(date);


        listViewItemList.add(item);
        this.notifyDataSetChanged();
    }
}
