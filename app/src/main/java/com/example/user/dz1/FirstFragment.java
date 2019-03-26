package com.example.user.dz1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private ArrayList<String> rvItemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyRvAdapter myRvAdapter;
    private final String LIST_KEY = "RECYCLER_ITEM_LIST";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment_layout, container, false);
        Button addItemButton = view.findViewById(R.id.button_add_item);
        recyclerView = view.findViewById(R.id.rv);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        }
        myRvAdapter = new MyRvAdapter(rvItemList, getActivity());
        recyclerView.setAdapter(myRvAdapter);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newSize = rvItemList.size() + 1;
                myRvAdapter.AddItem(newSize);
                recyclerView.smoothScrollToPosition(newSize);
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(LIST_KEY, rvItemList);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            initData(rvItemList);
        } else {
            rvItemList = savedInstanceState.getStringArrayList(LIST_KEY);
        }
    }

    private void initData(ArrayList<String> rvItemList) {
        for (int i = 1; i < 101; i++) {
            rvItemList.add(i + "");
        }
    }
}

