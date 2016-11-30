package com.liamgoodwin.eddiebullcupcakes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liamgoodwin.eddiebullcupcakes.CupcakesFragment;
import com.liamgoodwin.eddiebullcupcakes.R;

import java.util.ArrayList;

class CupcakeAdapter extends ArrayAdapter<CupcakesFragment.CupcakeItem> {

    CupcakeAdapter(Context context, ArrayList<CupcakesFragment.CupcakeItem> names) {
        super(context, R.layout.single_row, names);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater CupcakeInflater = LayoutInflater.from(getContext());
        View customView = CupcakeInflater.inflate(R.layout.single_row, parent, false);

        CupcakesFragment.CupcakeItem singleCupcake = getItem(position);
        TextView nameText = (TextView) customView.findViewById(R.id.cupcakeName);
        ImageView image = (ImageView) customView.findViewById(R.id.cupcakeImage);

        nameText.setText(singleCupcake.getName());
        image.setImageResource(R.drawable.cupcake1);
        return customView;
    }
}
