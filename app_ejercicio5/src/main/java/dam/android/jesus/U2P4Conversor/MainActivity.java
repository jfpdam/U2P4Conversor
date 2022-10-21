package dam.android.jesus.U2P4Conversor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btCentimetro, btPulgada, btGiga, btTera, btDolar, btEuro;
    EditText etPulgada, etMoneda, etGiga;
    TextView tvResultado, tvResMoneda, tvResGiga, tvError;

    private static final String DEBUG_TAG = "LogsAndroid-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(DEBUG_TAG, "onCreate");

        setUI();

        if (savedInstanceState != null){
            tvResultado.setText(savedInstanceState.getString("resultado"));
            if (etPulgada.getText().toString().equalsIgnoreCase("0")){
                tvError.setVisibility(View.VISIBLE);
            }
        }
    }

    private void setUI() {
        etPulgada = findViewById(R.id.etValor);
        etGiga = findViewById(R.id.etGigas);
        etMoneda = findViewById(R.id.etMoneda);
        tvResultado = findViewById(R.id.tvResultado);
        tvResGiga = findViewById(R.id.tvResGiga);
        tvResMoneda = findViewById(R.id.tvResMoneda);
        tvError = findViewById(R.id.tvError);
        btCentimetro = findViewById(R.id.btCentimetros);
        btPulgada = findViewById(R.id.btPulgadas);
        btDolar = findViewById(R.id.btDolar);
        btEuro = findViewById(R.id.btEuro);
        btGiga = findViewById(R.id.btGiga);
        btTera = findViewById(R.id.btTera);

        tvError.setVisibility(View.INVISIBLE);

        btPulgada.setOnClickListener(view ->{
           try {
               tvResultado.setText("Resultado: " + conversor(etPulgada.getText().toString(), "p"));
           }catch (Exception e){
               Log.e("LogsConversior", e.getMessage());
           }
        });

        btCentimetro.setOnClickListener(view ->{
            try {
                tvResultado.setText("Resultado: " + conversor(etPulgada.getText().toString(), "c"));
            }catch (Exception e){
                Log.e("LogsConversior", e.getMessage());
            }
        });

        btDolar.setOnClickListener(view ->{
            try {
                tvResMoneda.setText("Resultado: " + conversor(etMoneda.getText().toString(), "d"));
            }catch (Exception e){
                Log.e("LogsConversior", e.getMessage());
            }
        });

        btEuro.setOnClickListener(view ->{
            try {
                tvResMoneda.setText("Resultado: " + conversor(etMoneda.getText().toString(), "e"));
            }catch (Exception e){
                Log.e("LogsConversior", e.getMessage());
            }
        });

        btGiga.setOnClickListener(view ->{
            try {
                tvResGiga.setText("Resultado: " + conversor(etGiga.getText().toString(), "g"));
            }catch (Exception e){
                Log.e("LogsConversior", e.getMessage());
            }
        });

        btTera.setOnClickListener(view ->{
            try {
                tvResGiga.setText("Resultado: " + conversor(etGiga.getText().toString(), "t"));
            }catch (Exception e){
                Log.e("LogsConversior", e.getMessage());
            }
        });
    }

    private String conversor(String valor, String selec) {
        Log.i("Boton", " - centimetros");
        double a = Double.parseDouble(valor);
        double result = 0;
        try {
            switch (selec){
                case "p":
                    if (a >= 1){
                        result = a * 2.54;
                        tvError.setVisibility(View.INVISIBLE);
                    }else{
                        tvError.setVisibility(View.VISIBLE);
                    }
                    break;
                case "c":
                    if (a >= 1){
                        result = a / 2.54;
                        tvError.setVisibility(View.INVISIBLE);
                    }else{
                        tvError.setVisibility(View.VISIBLE);
                    }
                    break;
                case "d":
                    if (a >= 1){
                        result = a * 0.98;
                        tvError.setVisibility(View.INVISIBLE);
                    }else{
                        tvError.setVisibility(View.VISIBLE);
                    }
                    break;
                case "e":
                    if (a >= 1){
                        result = a / 0.98;
                        tvError.setVisibility(View.INVISIBLE);
                    }else{
                        tvError.setVisibility(View.VISIBLE);
                    }
                    break;
                case "g":
                    if (a >= 1){
                        result = a * 1024;
                        tvError.setVisibility(View.INVISIBLE);
                    }else{
                        tvError.setVisibility(View.VISIBLE);
                    }
                    break;
                case "t":
                    if (a >= 1){
                        result = a / 1024;
                        tvError.setVisibility(View.INVISIBLE);
                    }else{
                        tvError.setVisibility(View.VISIBLE);
                    }
                    break;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return String.format("%.2f", result);
    }

    //todo: ¿Qué ocurre con la información específica (un mensaje de error, un resultado de
    //todo: una operación…) que se muestra en los TextView? ¿Por qué?
    //todo: Lo que ocurre es que se destruye y se vuelve a crear, para solucionerlo necesitamos
    //todo: sobrescribir el metodo onSaveInstanceState.

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("resultado", tvResultado.getText().toString());
        Log.i(DEBUG_TAG, "guardado instancia");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(DEBUG_TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(DEBUG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()){
            Log.i(DEBUG_TAG, "onDestroy by the User");
        }else{
            Log.i(DEBUG_TAG, "onDestroy by the Sistem");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(DEBUG_TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(DEBUG_TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(DEBUG_TAG, "onRestart");
    }
}