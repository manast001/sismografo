package com.example.proyectosismo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Historial extends Activity {

	private ListView lista; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);

        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  

        datos.add(new Lista_entrada(R.drawable.s1, "Nivel Menor", "Nivel: Menor. Fecha del Evento: 16/12/2013. Tiempo de Medición: 80 segundos. Grados Richter: 2.9"));
        datos.add(new Lista_entrada(R.drawable.s1, "Nivel Menor", "Nivel: Menor. Fecha del Evento: 01/12/2013. Tiempo de Medición: 51 segundos. Grados Richter: 3.4"));
        datos.add(new Lista_entrada(R.drawable.s2, "Nivel Fuerte", "Nivel: Fuerte. Fecha del Evento: 07/03/2013. Tiempo de Medición: 64 segundos. Grados Richter: 6.1"));
        datos.add(new Lista_entrada(R.drawable.s3, "Nivel Ligero", "Nivel: Ligero. Fecha del Evento: 22/02/2013. Tiempo de Medición: 43 segundos. Grados Richter: 4.5"));
        datos.add(new Lista_entrada(R.drawable.s4, "Nivel Moderado", "Nivel: Moderado. Fecha del Evento: 11/01/2013. Tiempo de Medición: 34 segundos. Grados Richter: 5.6 "));
        datos.add(new Lista_entrada(R.drawable.s6, "Nivel Gran", "Nivel: Gran. Fecha del Evento: 21/12/2012. Tiempo de Medición: 72 segundos. Grados Richter: 8.1"));
        datos.add(new Lista_entrada(R.drawable.s5, "Nivel Mayor", "Nivel: Mayor. Fecha del Evento: 13/07/2012. Tiempo de Medición: 23 segundos. Grados Richter: 7.7"));
        datos.add(new Lista_entrada(R.drawable.s6, "Nivel Gran", "Nivel: Gran. Fecha del Evento: 06/04/2012. Tiempo de Medición: 59 segundos. Grados Richter: 8.5"));

        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.historial, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima()); 

		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo()); 

		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
		        }
			}
		});

        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion); 

                CharSequence texto =  elegido.get_textoDebajo();
                Toast toast = Toast.makeText(Historial.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
        });

    }

}

/*public class Historial extends Activity {
	//  @Override
  //  Intent activar= new Intent(this,SismografoActivity.class);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial);
    }*/



    
    
