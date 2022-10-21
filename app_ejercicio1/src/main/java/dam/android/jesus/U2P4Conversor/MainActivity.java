package dam.android.jesus.U2P4Conversor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btCentimetro, btPulgada;
    EditText etValor;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();

        if (savedInstanceState != null){
            tvResultado.setText(savedInstanceState.getString("resultado"));
        }
    }

    private void setUI() {
        etValor = findViewById(R.id.etValor);
        tvResultado = findViewById(R.id.tvResultado);
        btCentimetro = findViewById(R.id.btCentimetros);
        btPulgada = findViewById(R.id.btPulgadas);

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

    private String convertitPulgadas(String centimetros) {
        double pulgadaValue = Double.parseDouble(centimetros) * 2.54;
        return String.valueOf(pulgadaValue);
    }

    private String convertitCentimetros(String pulgada) {
        double pulgadaValue = Double.parseDouble(pulgada) / 2.54;
        return String.valueOf(pulgadaValue);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("resultado", tvResultado.getText().toString());
    }
}