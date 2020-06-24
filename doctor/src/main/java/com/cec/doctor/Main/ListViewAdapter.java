package com.cec.doctor.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cec.doctor.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<PatientNames> patientNamesList;
    private ArrayList<PatientNames> arraylist;

  ListViewAdapter(Context context, Collection<? extends PatientNames> animalNamesList) {
      //    variables
      this.patientNamesList = (List<PatientNames>) animalNamesList;
      inflater = LayoutInflater.from(context);
      this.arraylist = new ArrayList<>();
      this.arraylist.addAll(animalNamesList);
  }

    public boolean getFilter() {
      return true;
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return patientNamesList.size();
    }

    @Override
    public Object getItem(int position) {
        return patientNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_items, null);
            // Locate the TextViews in listview_item.xml

            holder.name = view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(patientNamesList.get(position).getAnimalName());
        return view;
        }

    // Filter Class
    void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        patientNamesList.clear();
        if (charText.length() == 0) {
            patientNamesList.addAll(arraylist);
        } else {
            for (PatientNames wp : arraylist) {
                if (wp.getAnimalName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    patientNamesList.add(wp);
                }
            }
        notifyDataSetChanged();

    }
  }

}
