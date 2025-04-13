package br.com.listadecompras;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declaração dos componentes da interface
    CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbCoca;
    TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define o layout da tela
        setContentView(R.layout.activity_main);

        // Liga as variáveis aos componentes definidos no XML
        cbArroz = findViewById(R.id.cbArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbCoca = findViewById(R.id.cbCoca);
        txtTotal = findViewById(R.id.txtTotal);

        // Ajusta o layout para não ficar escondido atrás da barra de status ou navegação
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Metodo chamado ao clicar no botão "Total da Compra"
    public void calcular(View view) {
        double total = 0;

        // Soma os valores dos itens selecionados
        if (cbArroz.isChecked()) total += 2.69;
        if (cbLeite.isChecked()) total += 2.70;
        if (cbCarne.isChecked()) total += 16.70;
        if (cbFeijao.isChecked()) total += 3.38;
        if (cbCoca.isChecked()) total += 3.00;

        // Atualiza o texto do total
        String texto = String.format("Total: R$ %.2f", total);
        txtTotal.setText(texto);
    }
}

