package com.example.user.dz1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import static com.example.user.dz1.MainActivity.COLOR_KEY;
import static com.example.user.dz1.MainActivity.NUMBER_KEY;

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.second_fragment_layout,container,false);
        TextView textView = view.findViewById(R.id.tv_fragment2);
        Bundle bundle=getArguments();
        if (bundle!=null){
            textView.setText(bundle.getString(NUMBER_KEY));
            textView.setTextColor(bundle.getInt(COLOR_KEY));
        }
        return view;
    }
}
