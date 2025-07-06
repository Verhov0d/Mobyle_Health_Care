package com.example.praktikazim;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class msotv extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private TextView RezM;
    private Button Hvatit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_msotv, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        SharedPreferences settings = getActivity().getSharedPreferences("set", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = settings.edit();

        RezM = root.findViewById(R.id.vivodm);
        float ims = settings.getFloat("ims", 010.f);
        RezM.setText("Результат: " + ims);
        if (ims > 30.0) RezM.setTextColor(Color.parseColor("#FFF80000"));
        else if (ims > 25.0 || ims < 18.0)
            RezM.setTextColor(Color.parseColor("#FFFF9900"));
        else RezM.setTextColor(Color.parseColor("#FF31B550"));

        Hvatit = root.findViewById(R.id.prod1);
        Hvatit.setOnClickListener(view -> {
            navController.navigate(R.id.dvigakt);
        });

        return root;
    }
}