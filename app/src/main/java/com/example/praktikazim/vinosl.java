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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link vinosl#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vinosl extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public vinosl() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vinosl.
     */
    // TODO: Rename and change types and number of parameters
    public static vinosl newInstance(String param1, String param2) {
        vinosl fragment = new vinosl();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    private EditText Ser;
    private EditText Dist;
    private EditText Sist;
    private TextView IBMres;
    private Button buttonIMS;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_vinosl, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        SharedPreferences settings = getActivity().getSharedPreferences("set", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = settings.edit();
        Ser = root.findViewById(R.id.sedcvin);
        Dist = root.findViewById(R.id.distdav);
        Sist = root.findViewById(R.id.sistdav);
        IBMres = root.findViewById(R.id.rezkef);
        buttonIMS = root.findViewById(R.id.kef);
        buttonIMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                if (Ser.getText().toString().isEmpty() || Dist.getText().toString().isEmpty() || Sist.getText().toString().isEmpty()
                        || Ser.length() == 1 && Ser.getText().toString().contains(".") || Dist.length() == 1 && Dist.getText().toString().contains(".")
                                || Sist.length() == 1 && Sist.getText().toString().contains(".")) {
                    IBMres.setText("Результат: ОШИБКА");
                } else {
                    float ims = 0;
                    ims = (Float.parseFloat(Ser.getText().toString()) * 10) /
                            (Float.parseFloat(Dist.getText().toString()) -
                                    Float.parseFloat(Sist.getText().toString()));
                    editor.putFloat("vinesly", ims);
                    editor.apply();
                    navController.navigate(R.id.vinosotv);
                }
            }
        });
        return root;
    }
}