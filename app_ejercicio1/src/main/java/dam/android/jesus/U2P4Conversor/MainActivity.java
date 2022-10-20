package dam.android.jesus.U2P4Conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }

    private void setUI() {
        EditText etPulgada = findViewById(R.id.etPulgada);
        EditText etResult = findViewById(R.id.etResult);
        Button btConvert = findViewById(R.id.btConvert);

        btConvert.setOnClickListener(view ->{
           try {
               etResult.setText(convertit(etPulgada.getText().toString()));
           }catch (Exception e){
               Log.e("LogsConversior", e.getMessage());
           }
        });
    }

    private String convertit(String pulgada) {
        double pulgadaValue = Double.parseDouble(pulgada) * 2.54;
        return String.valueOf(pulgadaValue);
    }
}