package com.example.torneoapp;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ReglasFragment extends Fragment {

    public ReglasFragment() {
        // Constructor público requerido vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_reglas_fragment, container, false);

        // Al usar Html.fromHtml internamente, los TextViews procesarán
        // automáticamente las etiquetas <b> que pusimos en strings.xml
        // para dar el efecto de "negrita" a las palabras clave.

        return view;
    }
}