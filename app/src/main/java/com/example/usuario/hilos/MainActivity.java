package com.example.usuario.hilos;

import android.app.Activity;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * es para calcular el factorial y hacer con un bucle en vez de recursividad
 *
 * esto para resolver de manera asincrona no nos sirve
 *
 */
public class MainActivity extends Activity {
    private EditText entrada;
    private TextView salida;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //se define el diesño de la interfaz
        entrada = (EditText) findViewById(R.id.entrada);
        salida = (TextView) findViewById(R.id.salida);
    }

    /**
     *
     * @param view
     */
    /*public void calcularOperacion(View view) {
        //obitne un entero de la cajita de entrasda
        int n = Integer.parseInt(entrada.getText().toString());
        //añade al objeto de salida
        salida.append(n +"! = ");
        //aqui llamamos al facotiral
        int res = factorial(n);
        //el resultado se lo añaade a la salida
        salida.append(res +"\n");
    }*/

    public void calcularOperacion(View view) {

        int n = Integer.parseInt(entrada.getText().toString());

        salida.append(n + "! = ");

        MiThread thread = new MiThread(n);
        //lanza la ejecutción y ahce que pase por el metdodo run
        thread.start();
    }

    /**
     * calculamos el factroial
     * @param n
     * @return
     */
    public int factorial(int n) {
        int res=1;
        for (int i=1; i<=n; i++){
            res*=i;
            // utilizamos el metod statactico de la clase systemclock y le dice que cada vuelta un retraso
            // a medida que vayamos metiendo valores grandes se ira retrasando
            // esto es para que android lo intente echar
            //SystemClock.sleep(1000);
        }

        return res;

    }


    public class MiThread extends Thread{
        private int n, res;

        public MiThread(int n){
            this.n = n;

        }
        @Override
        public void run() {
            res = factorial(n);
           // salida.append(res +"\n");

            //ejecutalo en hilo la interfaz de usuario es lo uqe le decimos
            runOnUiThread(new Runnable() {
                @Override public void run() {
                    salida.append(res + "\n");
                }
            });
        }



    }

}
