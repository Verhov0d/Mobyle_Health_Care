package com.example.praktikazim.ui.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.praktikazim.R;
import com.example.praktikazim.databinding.FragmentNotificationsBinding;

import java.time.LocalDateTime;
import java.util.Date;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;


    private TextView Rez1;
    private TextView Rez2;
    private TextView Rez3;
    private TextView Rez4;
    private TextView Rez5;
    private TextView Rez6;
    private TextView Rez7;
    private TextView Rez8;
    private TextView TimeV;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        SharedPreferences settings = getActivity().getSharedPreferences("set", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = settings.edit();



        Rez1 = root.findViewById(R.id.it1);
        Rez2 = root.findViewById(R.id.it2);
        Rez3 = root.findViewById(R.id.it3);
        Rez4 = root.findViewById(R.id.it4);
        Rez5 = root.findViewById(R.id.it5);
        Rez6 = root.findViewById(R.id.it6);
        Rez7 = root.findViewById(R.id.it7);
        Rez8 = root.findViewById(R.id.it8);
        TimeV = root.findViewById(R.id.vremya);


        Rez1.setText("Индекс массы тела: " + String.valueOf(settings.getFloat("ims", 010.f)));
        Rez2.setText("Уровень двигательной активности: " + String.valueOf(settings.getInt("dvdvdv", 010)));
        Rez3.setText("Коэффицент выносливости: " + String.valueOf(settings.getFloat("vinesly", 010.f)));
        Rez4.setText("Уровень регуляции сердечно-сосудистой системы: " + String.valueOf(settings.getFloat("ostanovilos", 010.f)));
        Rez5.setText("Жизненный индекс: " + String.valueOf(settings.getFloat("jizninet", 010.f)));
        Rez6.setText("Коэффицент Скибински: " + String.valueOf(settings.getFloat("skiba", 010.f)));
        Rez7.setText("Вегетативный индекс Кердо: " + String.valueOf(settings.getFloat("koreshek", 010.f)));
        Rez8.setText("Индекс функциональных изменений: " + String.valueOf(settings.getFloat("agoniya", 010.f)));

        Date time = new Date();
        navController.getCurrentDestination().setLabel(time.toString());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}