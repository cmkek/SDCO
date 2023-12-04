package com.example.sdco;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class q extends AppCompatActivity {

    private List<Integer> lista;
    private TextView textViewResultado;
    private EditText editTextValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q);

        lista = new ArrayList<>();
        textViewResultado = findViewById(R.id.textViewResultado);
        editTextValor = findViewById(R.id.editTextValor);

        Button buttonAgregar = findViewById(R.id.buttonAgregar);
        Button buttonOrdenar = findViewById(R.id.buttonOrdenar);

        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarValor();
            }
        });

        buttonOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarLista();
            }
        });
    }

    private void agregarValor() {
        String valorStr = editTextValor.getText().toString();

        if (!valorStr.isEmpty()) {
            int valor = Integer.parseInt(valorStr);
            lista.add(valor);
            editTextValor.setText("");
            mostrarLista();
        }
    }

    private void ordenarLista() {
        quickSort(lista, 0, lista.size() - 1);
        mostrarLista();
    }

    private void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;

                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    private void mostrarLista() {
        StringBuilder resultado = new StringBuilder("Lista: ");
        for (int valor : lista) {
            resultado.append(valor).append(" ");
        }

        textViewResultado.setText(resultado.toString());
    }
}
