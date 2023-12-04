package com.example.sdco;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class c extends AppCompatActivity {
    private Nodo inicio = null;
    private Nodo ultimo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);


        final EditText ed3 = findViewById(R.id.ed3);
        final Button bt4 = findViewById(R.id.bt4);


        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int valor = Integer.parseInt(ed3.getText().toString());

                Nodo nuevoNodo = new Nodo(valor);
                if (inicio == null) {
                    inicio = nuevoNodo;
                    ultimo = nuevoNodo;

                    ultimo.siguiente = inicio;
                    inicio.anterior = ultimo;
                } else {
                    nuevoNodo.anterior = ultimo;
                    ultimo.siguiente = nuevoNodo;
                    ultimo = nuevoNodo;

                    ultimo.siguiente = inicio;
                    inicio.anterior = ultimo;
                }
                ed3.setText("");

                actualizarSalida();
            }
        });
    }


    private void actualizarSalida() {
        StringBuilder resultado = new StringBuilder();
        Nodo imp = inicio;

        do {
            resultado.append(imp.dato).append("\n");
            imp = imp.siguiente;
        } while (imp != inicio);

        // Encuentra los TextView en el layout
        final TextView tvAnterior = findViewById(R.id.tvAnterior);
        final TextView tvActual = findViewById(R.id.tvActual);
        final TextView tvSiguiente = findViewById(R.id.tvSiguiente);

        // el resultado a cadena en tvAnterior
        tvAnterior.setText(resultado.toString());

        //  nodo anterior y el nodo actual a tvActual y tvSiguiente
        if (ultimo != null) {
            tvActual.setText("Nodo Actual:\n" + ultimo.dato);

            // caso en el que el nodo anterior es null
            if (ultimo.anterior != null) {
                tvSiguiente.setText("Nodo Anterior:\n" + ultimo.anterior.dato);
            } else {
                tvSiguiente.setText("Nodo Anterior:\nnull");
            }
        } else {
            // caso en el que el último nodo es null
            tvActual.setText("Nodo Actual:\nnull");
            tvSiguiente.setText("Nodo Anterior:\nnull");
        }
    }

    // clase nodo
    static class Nodo {
        public int dato;
        public Nodo siguiente;
        public Nodo anterior;

        public Nodo(int valor) {
            dato = valor;
            siguiente = null;
            anterior = null;
        }
    }
}
