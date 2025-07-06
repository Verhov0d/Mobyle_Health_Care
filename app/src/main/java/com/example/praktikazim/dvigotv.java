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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dvigotv#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dvigotv extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public dvigotv() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dvigotv.
     */
    // TODO: Rename and change types and number of parameters
    public static dvigotv newInstance(String param1, String param2) {
        dvigotv fragment = new dvigotv();
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





    private TextView IBMres;
    private Button Next;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_dvigotv, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        SharedPreferences settings = getActivity().getSharedPreferences("set", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = settings.edit();

        IBMres = root.findViewById(R.id.textView2);
        Next = root.findViewById(R.id.prod2);

        int ims = settings.getInt("dvdvdv", 010);
        int smn = ims * 365;
        if (ims < 7500) {
            IBMres.setTextColor(Color.parseColor("#FFF80000"));
            IBMres.setText("Число шагов в год: " + smn + ", сидячая работа");
        } else if (ims < 10000 && ims >= 7500) {
            IBMres.setTextColor(Color.parseColor("#ffa500"));
            IBMres.setText("Число шагов в год: " + smn + ", несколько активная работа");
        } else if (ims < 12500 && ims >= 10000) {
            IBMres.setTextColor(Color.parseColor("#FF008000"));
            IBMres.setText("Число шагов в год: " + smn + ", активный образ жизни");
        } else if (ims >= 12500) {
            IBMres.setTextColor(Color.parseColor("#FF9400D3"));
            IBMres.setText("Число шагов в год: " + smn + ", очень активный образ жизни");
        }

        Next.setOnClickListener(view -> {
            navController.navigate(R.id.vinosl);
        });

        return root;
    }
}