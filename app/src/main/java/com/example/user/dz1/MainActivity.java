package com.example.user.dz1;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyRvAdapter.OnClickItemRecycler {

    public static final String NUMBER_KEY = "NUMBER_KEY";
    public static final String COLOR_KEY = "COLOR_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FirstFragment firstFragment = new FirstFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_conteiner, firstFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void goFromFragment1ToFragment2(int color, String number) {
        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(COLOR_KEY, color);
        bundle.putString(NUMBER_KEY, number);
        secondFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_conteiner, secondFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
