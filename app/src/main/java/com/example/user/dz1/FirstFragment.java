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

    private ArrayList<String> mRvItemList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private MyRvAdapter mRvAdapter;
    private final String LIST_KEY = "RECYCLER_ITEM_LIST";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment_layout, container, false);
        Button addItemButton = view.findViewById(R.id.button_add_item);
        mRecyclerView = view.findViewById(R.id.rv);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        }
        mRvAdapter = new MyRvAdapter(mRvItemList, getActivity());
        mRecyclerView.setAdapter(mRvAdapter);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newSize = mRvItemList.size() + 1;
                mRvAdapter.AddItem(newSize);
                mRecyclerView.smoothScrollToPosition(newSize);
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(LIST_KEY, mRvItemList);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            initData(mRvItemList);
        } else {
            mRvItemList = savedInstanceState.getStringArrayList(LIST_KEY);
        }
    }

    private void initData(ArrayList<String> rvItemList) {
        for (int i = 1; i < 101; i++) {
            rvItemList.add(i + "");
        }
    }
}

