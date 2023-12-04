package com.example.sdco;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b extends AppCompatActivity {

    private List<Integer> lista;
    private TextView textViewResultado;
    private EditText editTextValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        lista = new ArrayList<>();
        textViewResultado = findViewById(R.id.textViewResultado);
        editTextValor = findViewById(R.id.editTextValor);

        Button buttonAgregar = findViewById(R.id.buttonAgregar);
        Button buttonOrdenar = findViewById(R.id.buttonOrdenar);

        buttonAgregar.setOnClickListener(view -> agregarValor());
        buttonOrdenar.setOnClickListener(view -> ordenarLista());
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
        Collections.sort(lista);
        mostrarLista();
    }

    private void mostrarLista() {
        StringBuilder resultado = new StringBuilder("Lista: ");
        for (int valor : lista) {
            resultado.append(valor).append(" ");
        }

        textViewResultado.setText(resultado.toString());
    }
}
