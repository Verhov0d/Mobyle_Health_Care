package com.example.praktikazim;

import android.content.Context;
import android.content.SharedPreferences;
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
 * Use the {@link indfunkizm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class indfunkizm extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public indfunkizm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment indfunkizm.
     */
    // TODO: Rename and change types and number of parameters
    public static indfunkizm newInstance(String param1, String param2) {
        indfunkizm fragment = new indfunkizm();
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



    private EditText Didida;
    private EditText Hvatit;
    private EditText Get;
    private EditText Some;
    private EditText Help;
    private EditText Vozr;
    private TextView IBMres;
    private Button buttonIMS;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_indfunkizm, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        SharedPreferences settings = getActivity().getSharedPreferences("set", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = settings.edit();
        Didida = root.findViewById(R.id.artindizm);
        Hvatit = root.findViewById(R.id.serdcindizm);
        Get = root.findViewById(R.id.davlindizm);
        Some = root.findViewById(R.id.rostindizm);
        Help = root.findViewById(R.id.vesindizm);
        IBMres = root.findViewById(R.id.rezindizm);
        buttonIMS = root.findViewById(R.id.indizm);
        int vozrast = Integer.parseInt(settings.getString("vozrast", "3333")) ;
        buttonIMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                if (Didida.getText().toString().isEmpty() || Hvatit.getText().toString().isEmpty() || Get.getText().toString().isEmpty() ||
                        Some.getText().toString().isEmpty() || Help.getText().toString().isEmpty()
                        || Didida.length() == 1 && Didida.getText().toString().contains(".")
                        || Hvatit.length() == 1 && Hvatit.getText().toString().contains(".")
                        || Get.length() == 1 && Get.getText().toString().contains(".")
                        || Some.length() == 1 && Some.getText().toString().contains(".")
                        || Help.length() == 1 && Help.getText().toString().contains(".")) {
                    IBMres.setText("Результат: ОШИБКА");
                } else {
                    float ims = 0;
                    ims = (0.011f * Float.parseFloat(Hvatit.getText().toString())) +
                            (0.014f * Float.parseFloat(Get.getText().toString())) +
                            (0.008f * Float.parseFloat(Didida.getText().toString())) +
                            (0.014f * Float.parseFloat(String.valueOf(vozrast)) ) +
                            (0.009f * Float.parseFloat(Help.getText().toString())) -
                            (0.009f * Float.parseFloat(Some.getText().toString())) - 0.27f;
                    IBMres.setText("Результат: " + ims);
                    editor.putFloat("agoniya", ims);
                    editor.apply();
                    navController.navigate(R.id.indfunkizmotv);
                }
            }
        });
        return root;
    }
}