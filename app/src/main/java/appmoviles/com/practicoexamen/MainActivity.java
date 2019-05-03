package appmoviles.com.practicoexamen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox_mayor_30;
    private CheckBox checkBox_entre_13_30;
    private CheckBox checkBox_menores_13;
    private Button btn_continuar;
    private Spinner spinner_genero_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox_mayor_30 = findViewById(R.id.checkBox_mayor_30);
        checkBox_entre_13_30 = findViewById(R.id.checkBox_entre_13_30);
        checkBox_menores_13 = findViewById(R.id.checkBox_menores_13);

        checkBox_mayor_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox_entre_13_30.isChecked() || checkBox_menores_13.isChecked()) {
                    checkBox_mayor_30.setChecked(false);
                }

            }
        });
        checkBox_entre_13_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox_mayor_30.isChecked() || checkBox_menores_13.isChecked()) {
                    checkBox_entre_13_30.setChecked(false);
                }

            }
        });
        checkBox_menores_13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox_mayor_30.isChecked() || checkBox_entre_13_30.isChecked()) {
                    checkBox_menores_13.setChecked(false);
                }

            }
        });

        spinner_genero_1 = (Spinner) findViewById(R.id.spinner_genero_1);
        btn_continuar = findViewById(R.id.btn_continuar);
        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox_mayor_30.isChecked()){
                    Intent i = new Intent(MainActivity.this, Preguntas.class);
                    if(spinner_genero_1.getSelectedItem().toString().equals("Hombre")){
                        i.putExtra(Constantes.TIPO_PERSONA,"2");
                    }else{
                        i.putExtra(Constantes.TIPO_PERSONA,"1");
                    }
                    startActivity(i);
                }
                if(checkBox_entre_13_30.isChecked()){
                    Intent i = new Intent(MainActivity.this, Preguntas.class);
                    if(spinner_genero_1.getSelectedItem().toString().equals("Hombre")){
                        i.putExtra(Constantes.TIPO_PERSONA,"4");
                    }else{
                        i.putExtra(Constantes.TIPO_PERSONA,"3");
                    }
                    startActivity(i);
                }
                if(checkBox_menores_13.isChecked()){
                    Intent i = new Intent(MainActivity.this, Preguntas.class);
                    i.putExtra(Constantes.TIPO_PERSONA,"5");
                    startActivity(i);
                }
            }
        });

    }

}
