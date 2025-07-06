package com.example.praktikazim.ui.dashboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.praktikazim.R;
import com.example.praktikazim.databinding.FragmentDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView txt = root.findViewById(R.id.vozrast);

        Button bt = root.findViewById(R.id.dashb);
        SharedPreferences settings = getActivity().getSharedPreferences("set", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = settings.edit();
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        txt.setText(settings.getString("vozrast", "18"));

        Button[] buttons = {root.findViewById(R.id.butIMT),root.findViewById(R.id.butUrDvigAct),root.findViewById(R.id.butKoefVinos),
                root.findViewById(R.id.butUrRegSerdc),root.findViewById(R.id.butLifeIndex),root.findViewById(R.id.butSkibinski),
                root.findViewById(R.id.butKerdo),root.findViewById(R.id.butIndexFuncIzm)};
        buttons[0].setOnClickListener(view -> {
            if(txt.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Введите свой возраст", Toast.LENGTH_SHORT).show();
            }
            else if((Integer.parseInt(txt.getText().toString()) < 16) || (Integer.parseInt(txt.getText().toString()) > 99)){
                Toast.makeText(getContext(), "Введите корректный возраст", Toast.LENGTH_SHORT).show();
            }
            else {
                editor.putString("vozrast", txt.getText().toString());
                editor.apply();
                navController.navigate(R.id.masstel);
            }

        });
        buttons[1].setOnClickListener(view -> {
            if(txt.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Введите свой возраст", Toast.LENGTH_SHORT).show();
            }
            else if((Integer.parseInt(txt.getText().toString()) < 16) || (Integer.parseInt(txt.getText().toString()) > 99)){
                Toast.makeText(getContext(), "Введите корректный возраст", Toast.LENGTH_SHORT).show();
            }
            else {
                editor.putString("vozrast", txt.getText().toString());
                editor.apply();
                navController.navigate(R.id.dvigakt);
            }
        });
        buttons[2].setOnClickListener(view -> {
            if(txt.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Введите свой возраст", Toast.LENGTH_SHORT).show();
            }
            else if((Integer.parseInt(txt.getText().toString()) < 16) || (Integer.parseInt(txt.getText().toString()) > 99)){
                Toast.makeText(getContext(), "Введите корректный возраст", Toast.LENGTH_SHORT).show();
            }
            else {
                editor.putString("vozrast", txt.getText().toString());
                editor.apply();
                navController.navigate(R.id.vinosl);
            }
        });
        buttons[3].setOnClickListener(view -> {
            if(txt.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Введите свой возраст", Toast.LENGTH_SHORT).show();
            }
            else if((Integer.parseInt(txt.getText().toString()) < 16) || (Integer.parseInt(txt.getText().toString()) > 99)){
                Toast.makeText(getContext(), "Введите корректный возраст", Toast.LENGTH_SHORT).show();
            }
            else {
                editor.putString("vozrast", txt.getText().toString());
                editor.apply();
                navController.navigate(R.id.serdsist);
            }
        });
        buttons[4].setOnClickListener(view -> {
            if(txt.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Введите свой возраст", Toast.LENGTH_SHORT).show();
            }
            else if((Integer.parseInt(txt.getText().toString()) < 16) || (Integer.parseInt(txt.getText().toString()) > 99)){
                Toast.makeText(getContext(), "Введите корректный возраст", Toast.LENGTH_SHORT).show();
            }
            else {
                editor.putString("vozrast", txt.getText().toString());
                editor.apply();
                navController.navigate(R.id.jiznind);
            }
        });
        buttons[5].setOnClickListener(view -> {
            if(txt.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Введите свой возраст", Toast.LENGTH_SHORT).show();
            }
            else if((Integer.parseInt(txt.getText().toString()) < 16) || (Integer.parseInt(txt.getText().toString()) > 99)){
                Toast.makeText(getContext(), "Введите корректный возраст", Toast.LENGTH_SHORT).show();
            }
            else {
                editor.putString("vozrast", txt.getText().toString());
                editor.apply();
                navController.navigate(R.id.skibinski);
            }
        });
        buttons[6].setOnClickListener(view -> {
            if(txt.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Введите свой возраст", Toast.LENGTH_SHORT).show();
            }
            else if((Integer.parseInt(txt.getText().toString()) < 16) || (Integer.parseInt(txt.getText().toString()) > 99)){
                Toast.makeText(getContext(), "Введите корректный возраст", Toast.LENGTH_SHORT).show();
            }
            else {
                editor.putString("vozrast", txt.getText().toString());
                editor.apply();
                navController.navigate(R.id.kerdo);
            }
        });
        buttons[7].setOnClickListener(view -> {
            if(txt.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Введите свой возраст", Toast.LENGTH_SHORT).show();
            }
            else if((Integer.parseInt(txt.getText().toString()) < 16) || (Integer.parseInt(txt.getText().toString()) > 99)){
                Toast.makeText(getContext(), "Введите корректный возраст", Toast.LENGTH_SHORT).show();
            }
            else {
                editor.putString("vozrast", txt.getText().toString());
                editor.apply();
                navController.navigate(R.id.indfunkizm);
            }
        });
        bt.setOnClickListener(view -> {
            if(txt.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Введите свой возраст", Toast.LENGTH_SHORT).show();
            }
            else if((Integer.parseInt(txt.getText().toString()) < 16) || (Integer.parseInt(txt.getText().toString()) > 99)){
                Toast.makeText(getContext(), "Введите корректный возраст", Toast.LENGTH_SHORT).show();
            }
            else {
                editor.putString("vozrast", txt.getText().toString());
                editor.apply();
                navController.navigate(R.id.masstel);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}