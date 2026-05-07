package com.example.proyectoregistroqr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class GestionActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AsistenciaAdapter adapter;
    private List<Asistencia> listaAsistencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        recyclerView = findViewById(R.id.recyclerViewAsistencias);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Datos de prueba (Aquí luego conectarás tu base de datos)
        listaAsistencias = new ArrayList<>();
        listaAsistencias.add(new Asistencia("1", "201912345", "2026-04-10"));
        listaAsistencias.add(new Asistencia("2", "202054321", "2026-04-10"));

        adapter = new AsistenciaAdapter(listaAsistencias, new AsistenciaAdapter.OnItemClickListener() {
            @Override
            public void onEditarClick(int position) {
                mostrarDialogoEditar(position);
            }

            @Override
            public void onEliminarClick(int position) {
                mostrarDialogoEliminar(position);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    // 5.1 Pantalla emergente de confirmación de editar/actualizar
    private void mostrarDialogoEditar(int position) {
        Asistencia asistencia = listaAsistencias.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Editar Asistencia");

        // Usamos un layout simple integrado con un EditText para que puedan modificar la matrícula
        final EditText inputMatricula = new EditText(this);
        inputMatricula.setText(asistencia.getMatricula());
        builder.setView(inputMatricula);

        builder.setPositiveButton("Actualizar", (dialog, which) -> {
            String nuevaMatricula = inputMatricula.getText().toString();
            // Actualizas el modelo
            asistencia.setMatricula(nuevaMatricula);
            // Notificas a la tabla que hubo un cambio para que se redibuje
            adapter.notifyItemChanged(position);
            Toast.makeText(GestionActivity.this, "Registro actualizado", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    // 5.2 Pantalla emergente de confirmación de eliminar
    private void mostrarDialogoEliminar(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmar Eliminación");
        builder.setMessage("¿Estás seguro de que deseas eliminar este registro?");

        builder.setPositiveButton("Eliminar", (dialog, which) -> {
            listaAsistencias.remove(position);
            // Animación de eliminación del RecyclerView
            adapter.notifyItemRemoved(position);
            Toast.makeText(GestionActivity.this, "Registro eliminado", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}