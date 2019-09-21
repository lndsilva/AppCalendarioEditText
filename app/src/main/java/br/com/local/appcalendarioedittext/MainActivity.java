package br.com.local.appcalendarioedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import static android.app.DatePickerDialog.*;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog dtpCalendario;
    EditText txtCalendario;
    Button btnCalendario;
    TextView lblCanendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblCanendario = findViewById(R.id.lblCalendario);
        txtCalendario = findViewById(R.id.txtCalendario);
        txtCalendario.setInputType(InputType.TYPE_NULL);

        txtCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();

                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                int mes = calendar.get(Calendar.MONTH);
                int ano = calendar.get(Calendar.YEAR);

                dtpCalendario = new DatePickerDialog(MainActivity.this,
                        new OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int dia, int mes, int ano) {
                                txtCalendario.setText(dia + "/" + (mes + 1) + "/" + ano);
                            }
                        }, dia, mes, ano);
                dtpCalendario.show();
            }
        });
        btnCalendario = findViewById(R.id.btnCalendario);
        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblCanendario.setText("Data selecionada: " + txtCalendario.getText());
            }
        });
    }

}
