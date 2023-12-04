//paquete
package com.example.sdco;
//Librerias

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class d extends AppCompatActivity {
    private Nodo inicio = null;
    private Nodo ultimo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
// edit text "et" y boton "bt" encontrados por su id en el layout
        final EditText ed2 = findViewById(R.id.ed2);

        final Button bt3 = findViewById(R.id.bt3);
//cuando se da click al boton encontrado en el layout "bt"
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se convierte valor de int a string
                int valor = Integer.parseInt(ed2.getText().toString());
                //se crea nuevo nodo con el valor escrito en el edit text
                Nodo nuevoNodo = new Nodo(valor);
                if (inicio == null) {
                    inicio = nuevoNodo;
                    ultimo = nuevoNodo;
                } else {
                    nuevoNodo.anterior = ultimo;
                    ultimo.siguiente = nuevoNodo;
                    ultimo = nuevoNodo;

                }
                ed2.setText("");
                //llamando al metodo actaualizar salida
                actualizarSalida();
            }
        });
    }

    //        }
//        while (imp2!=null){
    //  anterior.append(imp2.anterior.dato).append("\n");
    //    imp2=imp2.anterior;
    //      }
    ///
    //estructura final:
    private void actualizarSalida() {
        StringBuilder listaCompleta = new StringBuilder();
        Nodo imp = inicio;

        while (imp != null) {
            listaCompleta.append(imp.dato).append("\n");
            imp = imp.siguiente;
        }

        // Encuentra los TextView en el layout
        final TextView tv3 = findViewById(R.id.tv3);
        final TextView tv4 = findViewById(R.id.tv4);
        final TextView tv5 = findViewById(R.id.tv5);

        // el resultado a cadena en tv3
        tv3.setText(listaCompleta.toString());

        //  nodo anterior y el nodo actual a tv4 y tv5
        if (ultimo != null) {
            tv5.setText("Nodo Actual:\n" + ultimo.dato);

            // caso en el que el nodo anterior es null
            if (ultimo.anterior != null) {
                tv4.setText("Nodo Anterior:\n" + ultimo.anterior.dato);
            } else {
                tv4.setText("Nodo Anterior:\nnull");
            }
        } else {
            // caso en el que el último nodo es null
            tv5.setText("Nodo Actual:\nnull");
            tv4.setText("Nodo Anterior:\nnull");
        }
    }

    //metodo actualizar salida

///estructura inicial
///while (imp != null) {
    //      listaCompleta.append(imp.dato).append("\n");
    //       imp = imp.siguiente;
    //       actual.append(imp.dato).append("\n");
    //       imp = imp.siguiente;

    //clase nodo
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

