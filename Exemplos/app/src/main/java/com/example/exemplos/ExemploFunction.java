package com.example.exemplos;

public class ExemploFunction {
    /*public class ContadorCompleto extends AppCompatActivity {

    private TextView tv_contadorC;

    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_completo);

        tv_contadorC = findViewById(R.id.tv_contadorC);
        contador = getIntent().getIntExtra("valorInicial", 0);
        tv_contadorC.setText(String.valueOf(contador));

        Button btn_contadorC = findViewById(R.id.btn_contadorC);
        btn_contadorC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                tv_contadorC.setText(String.valueOf(contador));
            }
        });

    }
}
public class CalculadoraCompleta extends AppCompatActivity {

    private EditText et_primeiroValor;
    private EditText et_segundoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_completa);

        et_primeiroValor = findViewById(R.id.et_primeiroValor);
        et_segundoValor = findViewById(R.id.et_segundoValor);

        Button btn_soma = findViewById(R.id.btn_soma);
        Button btn_sub = findViewById(R.id.btn_sub);
        Button btn_mult = findViewById(R.id.btn_mult);
        Button btn_div = findViewById(R.id.bnt_div);

        btn_soma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('+');
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('-');
            }
        });

        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('*');
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('/');
            }
        });

    }

    private void calcular(char operacao){
        double resultado = 0;
        double valor1 = Double.parseDouble(et_primeiroValor.getText().toString());
        double valor2 = Double.parseDouble(et_segundoValor.getText().toString());

        switch (operacao){
            case '+':
                resultado = valor1 + valor2;
                break;
            case '-':
                resultado = valor1 - valor2;
                break;
            case'*':
                resultado = valor1*valor2;
                break;
            case '/':
                if(valor2!=0){
                    resultado = valor1/valor2;
                }else{
                    System.out.print("Impossível Dividir !");
                }
                break;
        }

        et_primeiroValor.setText(String.valueOf(resultado));
        et_segundoValor.setText("");
    }
}*/
}
