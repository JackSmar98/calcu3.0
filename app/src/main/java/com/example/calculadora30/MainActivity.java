package com.example.calculadora30;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText valor1;
    private EditText valor2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = findViewById(R.id.valor1);
        valor2 = findViewById(R.id.valor2);
        resultado = findViewById(R.id.resultado2);
        Button suma = findViewById(R.id.suma);

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int suma = Integer.parseInt(valor1.getText().toString()) + Integer.parseInt(valor2.getText().toString());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("resultado", suma);
                startActivity(intent);
            }
        });

        Button restButton = findViewById(R.id.resta);

        restButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resta = Integer.parseInt(valor1.getText().toString()) - Integer.parseInt(valor2.getText().toString()); // Cambiado de '+' a '-'
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("resultado", resta);
                startActivity(intent);
            }
        });

        Button multiButton = findViewById(R.id.multi);

        multiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int producto = Integer.parseInt(valor1.getText().toString()) * Integer.parseInt(valor2.getText().toString());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("resultado", producto);
                startActivity(intent);
            }
        });

        Button diviButton = findViewById(R.id.divi);
        Button potenButton = findViewById(R.id.poten);
        Button fibonacciButton = findViewById(R.id.fibonacci);

        diviButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divi(v);
            }
        });

        potenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                potencia(v);
            }
        });

        fibonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fibonacci(v);
            }
        });
    }

    public void divi(View view) {
        int div = Integer.parseInt(valor1.getText().toString()) / Integer.parseInt(valor2.getText().toString());
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("resultado", div);
        startActivity(intent);
    }

    public void potencia(View view) {
        int base = Integer.parseInt(valor1.getText().toString());
        int expo = Integer.parseInt(valor2.getText().toString());
        int poten = (int) Math.pow(base, expo);
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("resultado", poten);
        startActivity(intent);
    }

    public void fibonacci(View view) {
        int n = Integer.parseInt(valor1.getText().toString());
        int fibonacci = fibonacci(n);
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("resultado", fibonacci);
        startActivity(intent);
    }

    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int prev1 = 0;
        int prev2 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = prev1 + prev2;
            prev2 = prev1;
            prev1 = fib;
        }
        return fib;
    }
}
