package com.senac.vitor.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.senac.vitor.R;
import com.senac.vitor.control.MainControl;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editNota1;
    private EditText editNota2;
    private TextView tvResultado;
    private LinearLayout layoutResultado;
    private Button btnCalcular;
    private Button btnLimparDados;

    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        control = new MainControl(this);
    }

    private void initialize(){
        editNome = findViewById(R.id.editNome);
        editNota1 = findViewById(R.id.editNota1);
        editNota2 = findViewById(R.id.editNota2);
        tvResultado = findViewById(R.id.tvResultado);
        layoutResultado = findViewById(R.id.layoutResultado);

        //onClick
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                control.calcularAction();
            }
        });

        //onClick
        btnLimparDados = findViewById(R.id.btnLimparDados);
        btnLimparDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.limparDadosAction();
            }
        });
    }

    public EditText getEditNome() {
        return editNome;
    }

    public EditText getEditNota1() {
        return editNota1;
    }

    public EditText getEditNota2() {
        return editNota2;
    }

    public TextView getTvResultado() {
        return tvResultado;
    }

    public LinearLayout getLayoutResultado() {
        return layoutResultado;
    }

    public Button getBtnCalcular() {
        return btnCalcular;
    }

    public Button getBtnLimparDados() {
        return btnLimparDados;
    }
}
