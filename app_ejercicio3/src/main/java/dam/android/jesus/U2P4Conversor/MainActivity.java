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

    Button btCentimetro, btPulgada;
    EditText etValor;
    TextView tvResultado, tvError;

    private static final String DEBUG_TAG = "LogsAndroid-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(DEBUG_TAG, "onCreate");

        setUI();

        if (savedInstanceState != null){
            tvResultado.setText(savedInstanceState.getString("resultado"));
            if (etValor.getText().toString().equalsIgnoreCase("0")){
                tvError.setVisibility(View.VISIBLE);
            }
        }
    }

    private void setUI() {
        etValor = findViewById(R.id.etValor);
        tvResultado = findViewById(R.id.tvResultado);
        btCentimetro = findViewById(R.id.btCentimetros);
        btPulgada = findViewById(R.id.btPulgadas);
        tvError = findViewById(R.id.tvError);
        tvError.setVisibility(View.INVISIBLE);

        btPulgada.setOnClickListener(view ->{
           try {
               tvResultado.setText("Resultado: " + convertitPulgadas(etValor.getText().toString()));
           }catch (Exception e){
               Log.e("LogsConversior", e.getMessage());
           }
        });

        btCentimetro.setOnClickListener(view ->{
            try {
                tvResultado.setText("Resultado: " + convertitCentimetros(etValor.getText().toString()));
            }catch (Exception e){
                Log.e("LogsConversior", e.getMessage());
            }
        });
    }

    private String convertitPulgadas(String Pulgadas) {
        Log.i("Boton", " - Pulgadas");
        double a = Double.parseDouble(Pulgadas);
        double result = 0;
        try {
            if (a >= 1){
                result = Double.parseDouble(Pulgadas) * 2.54;
                tvError.setVisibility(View.INVISIBLE);
            }else{
                tvError.setVisibility(View.VISIBLE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return String.format("%.2f", result);
    }

    private String convertitCentimetros(String centimetros) {
        Log.i("Boton", " - centimetros");
        double a = Double.parseDouble(centimetros);
        double result = 0;
        try {
            if (a >= 1){
                result = Double.parseDouble(centimetros) / 2.54;
                tvError.setVisibility(View.INVISIBLE);
            }else{
                tvError.setVisibility(View.VISIBLE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return String.format("%.2f", result);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("resultado", tvResultado.getText().toString());
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