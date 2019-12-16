package com.example.androidproject;

import com.example.androidproject.model.Technologies;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> implements Filterable {
    private List<Technologies> listValues;
    private List<Technologies> listValues1 = new ArrayList<>();

    public class CelluleJava extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;

        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            image = v.findViewById(R.id.icon);
        }
    }

    public MyAdapter(List<Technologies> listValues) {
        this.listValues = listValues;
        this.listValues1 = listValues;
    }

    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listValues = (List<Technologies>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Technologies> filteredResults = null;
                if (constraint.length() == 0) {
                    filteredResults = listValues1;
                } else {
                    filteredResults = getFilteredResults(constraint.toString().toLowerCase());
                }

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }
        };

    }

    protected List<Technologies> getFilteredResults(String constraint) {
        List<Technologies> results = new ArrayList<>();

        for (Technologies item : listValues1) {
            if (item.getName().toLowerCase().contains(constraint)) {
                results.add(item);
            }
        }
        return results;
    }

    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        Technologies currentTechnologies = listValues.get(position);
        final String name = currentTechnologies.getName();
        final String description = currentTechnologies.getDescription();
        final String expansion = currentTechnologies.getExpansion();
        final String age = currentTechnologies.getAge();
        Log.d("YYOO", "onBindViewHolder: "+name);
        holder.txtHeader.setText(name);
        holder.txtFooter.setText(description);;
    }

    @Override
    public int getItemCount() {
        if (listValues1 == null)
            return 0;
        return listValues.size();
    }

}
