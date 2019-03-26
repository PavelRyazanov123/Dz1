package com.example.user.dz1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyViewHolder> {

    private ArrayList<String> rvItemsList;
    private Context mContext;

    public MyRvAdapter(ArrayList<String> rvItemsList, Context mContext) {
        this.rvItemsList = rvItemsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_rv, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.tvNumbers.setText(rvItemsList.get(i));
        myViewHolder.tvNumbers.setTextColor((changeColor(rvItemsList.get(i))));
        myViewHolder.tvNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = myViewHolder.tvNumbers.getCurrentTextColor();
                String number = (String) myViewHolder.tvNumbers.getText();
                OnClickItemRecycler clickItemRecyclerListener = (OnClickItemRecycler) mContext;
                clickItemRecyclerListener.goFromFragment1ToFragment2(color, number);
            }
        });
    }

    private int changeColor(String item) {
        int color = mContext.getColor(R.color.blue);
        if (Integer.valueOf(item) % 2 == 0)
            color = mContext.getColor(R.color.red);
        return color;
    }

    @Override
    public int getItemCount() {
        return rvItemsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNumbers;

        public MyViewHolder(View view) {
            super(view);
            tvNumbers = view.findViewById(R.id.textview_rv);
        }
    }

    public interface OnClickItemRecycler {
        void goFromFragment1ToFragment2(int color, String number);
    }

    public void AddItem(int size) {
        rvItemsList.add(String.valueOf(size));
        notifyItemInserted(size);
    }
}
