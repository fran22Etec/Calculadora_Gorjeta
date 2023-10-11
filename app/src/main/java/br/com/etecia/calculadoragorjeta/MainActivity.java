package br.com.etecia.calculadoragorjeta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValordaconta;
    private TextView editTextQualidadedoserviço;

    private Button btnCalculargorjeta;
    private TextView editTextGorgeta;
    private TextView editTextValortotal;

    public MainActivity(EditText editTextValordaconta) {
        this.editTextValordaconta = editTextValordaconta;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValordaconta = findViewById(R.id.editTextValordaconta);
        editTextValordaconta = findViewById(R.id.editTextQualidadedoserviço);
        btnCalculargorjeta = findViewById(R.id.btnCalculargorjeta);
        editTextGorgeta = findViewById(R.id.editTextGorgeta);
        editTextValortotal = findViewById(R.id.editTextValortotal);

        btnCalculargorjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        String billAmountStr = editTextValordaconta.getText().toString();
        if (!billAmountStr.isEmpty()) {
            double billAmount = Double.parseDouble(billAmountStr);
            double tipAmount = billAmount * 0.15; // 15% tip rate
            editTextValortotal.setText("Valor da Gorjeta: R$" + String.format("%.2f", tipAmount));
        }
    }
}
