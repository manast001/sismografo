package com.example.proyectosismo;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;



import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

public class SismografoActivity extends Activity {
	int notificationID = 1;
	private XYPlot plot;
	private Number[] grafica = {(float)(Math.random()*10+1),(float)(Math.random()*10+1),(float)(Math.random()*10+1),(float)(Math.random()*10+1)};
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sismografo);
		

		//Creamos nuestra grafica XYPlot recogiendola del XML
        plot = (XYPlot) findViewById(R.id.pot);

        
      //Creamos el Timer
      		Timer timer = new Timer();
      		//Que actue cada 2000 milisegundos
      		//Empezando des de el segundo 0
      		timer.scheduleAtFixedRate(new TimerTask() {
      			@Override
      			public void run() {
      				//La función que queremos ejecutar
      				FuncionParaEsteHilo();
      			}
      		}, 0, 0400);
      		
      			
      		//	timer.cancel();
      		
	}
	
	
	private void FuncionParaEsteHilo()
	{
	    //Esta función es llamada des de dentro del Timer
		//Para no provocar errores ejecutamos el Accion
		//Dentro del mismo Hilo
	    this.runOnUiThread(Accion);
	}
	
	public void displayNotification(Number num){
		Intent i = new Intent(this, NotificationView.class);
		i.putExtra("notificationID", notificationID);
		
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
		NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		
		CharSequence ticker ="Inicio de Sismo";
		CharSequence contentTitle = "Medición de Sismo";
		CharSequence contentText = "Grado Máximo "+ num +" escala Richter";
		Notification noti = new NotificationCompat.Builder(this)
								.setContentIntent(pendingIntent)
								.setTicker(ticker)
								.setContentTitle(contentTitle)
								.setContentText(contentText)
								.setSmallIcon(R.drawable.ic_launcher)
								.addAction(R.drawable.ic_launcher, ticker, pendingIntent)
								//.setVibrate(new long[]{0300} )
								.build();
		nm.notify(notificationID, noti);
	}

	private Runnable Accion = new Runnable() {
	  

		public void run() {
	    	//Actualizamos los numeros del array
	    	for(int a=0;a<grafica.length-1;a++){
	    			//movemos todos los numeros una posicion a la izquierda
					grafica[a] = grafica[a+1];
				}
	    	    float xi =(float)(Math.random()*10+1);
	    	    float max=(Float) grafica[0];
	    	    grafica[grafica.length-1] =xi;
	    	    
	    	    for(int a=0;a<grafica.length-1;a++){
	    	         if(max<(Float)grafica[a]){
	    	        	max =(Float)grafica[a];
	    	        	displayNotification(grafica[a]);    	        
	    	         }
	    	    	
	    	    }
	    	 
	    	 /*  float xi =(float)(Math.random()*10+1);
	    	   float b=7;
	    		if( xi >  b ){
	    			grafica[grafica.length-1] =xi;	
	    			displayNotification(xi);
	    		}*/
	    	 //   grafica[grafica.length-1] = Math.floor(Math.random()*10+1);
	        
				//Cargamos el nuevo array en la clase XYSERIES
				XYSeries series = new SimpleXYSeries(
			                Arrays.asList(grafica),          // SimpleXYSeries takes a List so turn our array into a List
			                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
			                "Series");                             // Set the display title of the series
				 //Le damos formato de líneas
				 LineAndPointFormatter seriesFormat = new LineAndPointFormatter();
			     seriesFormat.setPointLabelFormatter(new PointLabelFormatter());
			//Limpiamos la gráfica
			plot.clear();
			//Añadimos la nueva gráfica
			plot.addSeries(series, seriesFormat);
	        plot.redraw();       
	        
	    }
	    
	};
}