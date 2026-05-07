package com.example.proyectoregistroqr;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TablaAsistencias {
    private String id;
    private String matricula;
    private String fecha;

    public TablaAsistencias(String id, String matricula, String fecha) {
        this.id = id;
        this.matricula = matricula;
        this.fecha = fecha;
    }

    public String getId() { return id; }
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}