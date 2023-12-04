//paquete
package com.example.sdco;
//Librerias

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class s extends AppCompatActivity {
    private Nodo inicio = null;
    private Nodo ultimo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s);
// edit text "et" y boton "bt" encontrados por su id en el layout
        final EditText et = findViewById(R.id.et);

        final Button bt = findViewById(R.id.bt5);
//cuando se da click al boton encontrado en el layout "bt"
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se convierte valor de int a string
                int valor = Integer.parseInt(et.getText().toString());
                //se crea nuevo nodo con el valor escrito en el edit text
                Nodo nuevoNodo = new Nodo(valor);
                if (inicio == null) {
                    inicio = nuevoNodo;
                    ultimo = nuevoNodo;
                } else {
                    ultimo.siguiente = nuevoNodo;
                    ultimo = nuevoNodo;
                }
                et.setText("");
                //llamando al metodo actaualizar salida
                actualizarSalida();
            }
        });
    }

    //metodo actualizar salida
    private void actualizarSalida() {
        StringBuilder resultado = new StringBuilder();
        Nodo imp = inicio;
        while (imp != null) {
            resultado.append(imp.dato).append("\n");
            imp = imp.siguiente;
        }
        //del text view encontrado por id en el layout se coloca el dato (int) convertiso a string
        final TextView tv = findViewById(R.id.tv2);
        tv.setText(resultado.toString());
    }

    //clase nodo
    static class Nodo {
        public int dato;
        public Nodo siguiente;

        public Nodo(int valor) {
            dato = valor;
            siguiente = null;
        }
    }


}