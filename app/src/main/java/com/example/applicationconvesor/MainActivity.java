package com.example.applicationconvesor;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    double valueUnidade;
    double auxiliar;
    Spinner unidadeInicial;
    Spinner unidadedeTrasformada;
    TextView  resultValue;
    EditText  valueInpuntunidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        unidadeInicial = (Spinner) findViewById(R.id.unidade_imput);
        unidadedeTrasformada = (Spinner) findViewById(R.id.unidade_exit);
        valueInpuntunidade =(EditText) findViewById(R.id.valueInput);
        resultValue = (TextView) findViewById(R.id.valor_Resultado);




// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.unidadeInput_array,
                android.R.layout.simple_spinner_item
        );
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.unidadeExit_array,
                android.R.layout.simple_spinner_item
        );

// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        unidadeInicial.setAdapter(adapter);
        unidadedeTrasformada.setAdapter(adapter2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });



    }
    public void  CoverterValores(View view){

         valueUnidade = Double.parseDouble(valueInpuntunidade.getText().toString());
        if (unidadeInicial.getSelectedItem() == unidadedeTrasformada.getSelectedItem()){
            auxiliar = valueUnidade * 1 ;
            resultValue.setText("VALOR: "+ String.format("%.2f",auxiliar)  );

        } else if (unidadeInicial.getSelectedItem().equals("Centimetros") && unidadedeTrasformada.getSelectedItem().equals("Metros")){
            auxiliar = valueUnidade / 100;
            resultValue.setText("VALOR: "+ String.format("%.8f",auxiliar)+"m");

        } else if (unidadeInicial.getSelectedItem().equals("Centimetros") && unidadedeTrasformada.getSelectedItem().equals("Kilometros")) {
            auxiliar = valueUnidade / 100000;
            resultValue.setText("VALOR: "+ String.format("%.8f",auxiliar)+"km");

        }else if (unidadeInicial.getSelectedItem().equals("Centimetros") && unidadedeTrasformada.getSelectedItem().equals("Milhas")) {
            auxiliar = valueUnidade / 160934;
            resultValue.setText("VALOR: " + String.format("%.8f", auxiliar)+"Mi");

        } else if (unidadeInicial.getSelectedItem().equals("Metros") && unidadedeTrasformada.getSelectedItem().equals("Centimetros")) {
            auxiliar = valueUnidade * 100;
            resultValue.setText("VALOR: " + String.format("%.8f", auxiliar)+"cm");

        } else if (unidadeInicial.getSelectedItem().equals("Metros") && unidadedeTrasformada.getSelectedItem().equals("Kilometros")) {
            auxiliar = valueUnidade / 1000;
            resultValue.setText("VALOR: " + String.format("%.8f", auxiliar)+"Km");

        }else if (unidadeInicial.getSelectedItem().equals("Metros") && unidadedeTrasformada.getSelectedItem().equals("Milhas")) {
            auxiliar = valueUnidade / 1609;
            resultValue.setText("VALOR: " + String.format("%.8f", auxiliar)+"Mi");

        }else if (unidadeInicial.getSelectedItem().equals("Kilometros") && unidadedeTrasformada.getSelectedItem().equals("Centimetros")) {
            auxiliar = valueUnidade * 100000;
            resultValue.setText("VALOR: " + String.format("%.8f", auxiliar)+ "cm");

        }else if (unidadeInicial.getSelectedItem().equals("Kilometros") && unidadedeTrasformada.getSelectedItem().equals("Metros")) {
            auxiliar = valueUnidade * 1000;
            resultValue.setText("VALOR: " + String.format("%.8f", auxiliar)+"m");

        }else if (unidadeInicial.getSelectedItem().equals("Kilometros") && unidadedeTrasformada.getSelectedItem().equals("Milhas")) {
            auxiliar = valueUnidade / 1.609;
            resultValue.setText("VALOR: " + String.format("%.8f", auxiliar)+"Mi");

        }else if (unidadeInicial.getSelectedItem().equals("Milhas") && unidadedeTrasformada.getSelectedItem().equals("Centimetros")) {
            auxiliar = valueUnidade *  160934;
            resultValue.setText("VALOR: " + String.format("%.8f", auxiliar)+"cm");

        }else if (unidadeInicial.getSelectedItem().equals("Milhas") && unidadedeTrasformada.getSelectedItem().equals("Metros")) {
            auxiliar = valueUnidade * 1609;
            resultValue.setText("VALOR: " + String.format("%.8f", auxiliar)+"m");

        }else if (unidadeInicial.getSelectedItem().equals("Milhas") && unidadedeTrasformada.getSelectedItem().equals("Kilometros")) {
            auxiliar = valueUnidade * 1.609;
            resultValue.setText("VALOR: " + String.format("%.8f", auxiliar)+"Km");

        }




    }


}