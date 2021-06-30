package com.haritagenelmudurlugu.haritadergisi.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.haritagenelmudurlugu.haritadergisi.R;
import com.haritagenelmudurlugu.haritadergisi.model.Makale;

import java.util.ArrayList;
import java.util.Locale;

public class MakaleArrayAdapter extends ArrayAdapter<Makale> {

    private int listItemLayout;

    private ArrayList<Makale> myList;  // for loading main list

    private ArrayList<Makale> arraylist=null;

    public MakaleArrayAdapter(Context context, int layoutId, ArrayList<Makale> itemList) {
        super(context, layoutId, itemList);
        listItemLayout = layoutId;
        this.myList =itemList;
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(myList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Makale item = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(listItemLayout, parent, false);
            viewHolder.item = (TextView) convertView.findViewById(R.id.label);
            convertView.setTag(viewHolder); // view lookup cache stored in tag
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.item.setText(item.getFullText());



        // Return the completed view to render on screen
        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        myList.clear();
        if (charText.length() == 0) {
            myList.addAll(arraylist);
        }
        else
        {
            for (Makale wp : arraylist) {
                if (wp.getFullText().toLowerCase(Locale.getDefault()).contains(charText)) {
                    myList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

    public  Makale getItemInPosition(int position)
    {
        return  this.myList.get(position);

    }

    // The ViewHolder, only one item for simplicity and demonstration purposes, you can put all the views inside a row of the list into this ViewHolder
    private static class ViewHolder {
        TextView item;
    }
}