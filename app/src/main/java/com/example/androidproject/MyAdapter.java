package com.example.androidproject;

import com.example.androidproject.model.Technologies;

import java.util.List;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> {
    private List<Technologies> listValues;

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
    }

    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        Technologies currentTechnologies = listValues.get(position);
        final String name = currentTechnologies.getName();
        final String description = currentTechnologies.getDescription();
        final String expansion = currentTechnologies.getExpansion();
        final String age = currentTechnologies.getAge();

        holder.txtHeader.setText(name);
        holder.txtFooter.setText(description);
        holder.txtFooter.setText(expansion);
        holder.txtFooter.setText(age);
    }

    @Override
    public int getItemCount() {
        return listValues.size();
    }

}
