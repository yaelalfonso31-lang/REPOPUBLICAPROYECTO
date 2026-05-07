package com.example.proyectoregistroqr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AsistenciaAdapter extends RecyclerView.Adapter<AsistenciaAdapter.ViewHolder> {

    private List<Asistencia> listaAsistencias;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onEditarClick(int position);
        void onEliminarClick(int position);
    }

    public AsistenciaAdapter(List<Asistencia> listaAsistencias, OnItemClickListener listener) {
        this.listaAsistencias = listaAsistencias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asistencia, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Asistencia asistencia = listaAsistencias.get(position);
        holder.tvMatricula.setText(asistencia.getMatricula());
        holder.tvFecha.setText(asistencia.getFecha());
    }

    @Override
    public int getItemCount() {
        return listaAsistencias.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMatricula, tvFecha;
        Button btnEditar, btnEliminar;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            tvMatricula = itemView.findViewById(R.id.tvMatricula);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            btnEditar = itemView.findViewById(R.id.btnEditar);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);

            btnEditar.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onEditarClick(position);
                    }
                }
            });

            btnEliminar.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onEliminarClick(position);
                    }
                }
            });
        }
    }
}