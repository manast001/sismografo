package com.example.proyectosismo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;

public class Config extends Activity {

	TimePicker timePicker;
	Button boton;
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        
        timePicker= (TimePicker) findViewById(R.id.tpTiempo);
        boton= (Button) findViewById(R.id.btBoton);
    }
}