package com.example.torneoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

public class InicioFragment extends Fragment {

    public InicioFragment() {
        // Constructor público requerido vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento
        View view = inflater.inflate(R.layout.activity_inicio_fragment, container, false);

        MaterialButton btnRegistrate = view.findViewById(R.id.btnRegistrateAqui);

        btnRegistrate.setOnClickListener(v -> {
            // Acceder a la MainActivity para cambiar la selección del Bottom Navigation
            if (getActivity() != null) {
                BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
                if (bottomNav != null) {
                    // Cambia al ítem de destino (por ejemplo, el de las Bases o Acceso)
                    // Asegúrate de usar el ID correcto que definiste en tu bottom_nav_menu.xml
                    bottomNav.setSelectedItemId(R.id.nav_bases);
                }
            }
        });

        // Opcional: Si deseas reproducir el GIF animado usando la librería Glide:
        // ImageView ivGif = view.findViewById(R.id.ivKombatGif);
        // Glide.with(this).load(R.drawable.kombat).into(ivGif);

        return view;
    }
}