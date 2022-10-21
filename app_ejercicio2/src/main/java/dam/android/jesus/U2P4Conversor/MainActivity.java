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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}