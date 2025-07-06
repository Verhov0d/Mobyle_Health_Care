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
import android.widget.EditText;
import android.widget.TextView;


public class masstel extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private EditText Ves;
    private EditText Rost;
    private TextView IBMres;
    private Button buttonIMS;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_masstel, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        SharedPreferences settings = getActivity().getSharedPreferences("set", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = settings.edit();

        Ves = root.findViewById(R.id.vesm);
        Rost = root.findViewById(R.id.rostm);
        IBMres = root.findViewById(R.id.rezm);
        buttonIMS = root.findViewById(R.id.massa);
        buttonIMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                if (Ves.getText().toString().isEmpty() || Rost.getText().toString().isEmpty() || Ves.length() == 1 && Ves.getText().toString().contains(".")
                        || Rost.length() == 1 && Rost.getText().toString().contains(".")) {
                    IBMres.setText("Результат: ОШИБКА");
                } else {
                    float ims = 0;
                    ims = Float.parseFloat(Ves.getText().toString()) /
                            (Float.parseFloat(Rost.getText().toString()) *
                                    Float.parseFloat(Rost.getText().toString()));
                    ims = ims * 100;
                    ims = Math.round(ims);
                    ims = ims / 100;
                    IBMres.setText("Результат: " + ims);

                    editor.putFloat("ims", ims);
                    editor.apply();
                    navController.navigate(R.id.msotv);

                }
            }
        });
        return root;
    }
}