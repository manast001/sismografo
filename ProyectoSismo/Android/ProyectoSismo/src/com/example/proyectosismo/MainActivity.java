package com.example.proyectosismo;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;


public class MainActivity extends Activity {
	
  //  @Override
  //  Intent activar= new Intent(this,SismografoActivity.class);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
   //     Button miBoton= (Button) findViewById(R.id.button1);
  //      Button miBoton2= (Button) findViewById(R.id.button2);
  //      Button miBoton3= (Button) findViewById(R.id.button3);
        
 //       miBoton.setOnClickListener(new OnClickListener() {//evento click boton 1
        	
	//		@Override
	//		public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
//			txt = (TextView) findViewById(R.id.label);
//			txt.setText("Pantalla sismógrafo");
			
			
//	     	startActivity(activar);
//			}
	//		Intent Activar Sismógrafo= new Intent(this,sismografo.class);
	//		startActivity(Activar Sismógrafo);
	//	});
        
      /*  miBoton2.setOnClickListener(new OnClickListener() {//evento click boton 2
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			txt = (TextView) findViewById(R.id.label);
			txt.setText("Accediendo al Historial");
				
			}
		});
        
        miBoton3.setOnClickListener(new OnClickListener() {//evento click boton 3
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
		//	txt = (TextView) findViewById(R.id.label);
		//	txt.setText("Entrando a configuraciones");
				//Intent activar= new Intent(this,SismografoActivity.class);
		     	//startActivity(activar);	
			}
		});*/
    }

   public void PantallaHistorial(View v)
    {
    	Intent historial_string= new Intent(this,Historial.class);
     	startActivity(historial_string);
    }
    
    public void PantallaSismografo(View v)
    {
    	Intent activar= new Intent(this,SismografoActivity.class);
     	startActivity(activar);
    }

    public void PantallaConfig(View v)
    {
    	Intent X= new Intent(this,Config.class);
     	startActivity(X);
    }
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}