package com.example.torneoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BasesFragment extends Fragment {

    public BasesFragment() {
        // Constructor público requerido vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Infla el diseño fragment_bases.xml
        return inflater.inflate(R.layout.activity_bases_fragment, container, false);
    }
}