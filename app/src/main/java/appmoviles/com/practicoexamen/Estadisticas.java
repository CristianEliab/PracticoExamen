package appmoviles.com.practicoexamen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class Estadisticas extends AppCompatActivity {

    private String id_super;
    private String tipoPersona;

    private TextView tv_cantidad_votos_1;
    private TextView tv_cantidad_votos_2;
    private TextView tv_cantidad_votos_3;
    private TextView tv_cantidad_votos_4;
    private TextView tv_cantidad_votos_5;
    private TextView tv_cantidad_votos_6;
    private TextView tv_cantidad_votos_7;
    private TextView tv_cantidad_votos_8;


    FirebaseDatabase rtdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        tv_cantidad_votos_1 = findViewById(R.id.tv_cantidad_votos_1);
        tv_cantidad_votos_2 = findViewById(R.id.tv_cantidad_votos_2);
        tv_cantidad_votos_3 = findViewById(R.id.tv_cantidad_votos_3);
        tv_cantidad_votos_4 = findViewById(R.id.tv_cantidad_votos_4);
        tv_cantidad_votos_5 = findViewById(R.id.tv_cantidad_votos_5);
        tv_cantidad_votos_6 = findViewById(R.id.tv_cantidad_votos_6);
        tv_cantidad_votos_7 = findViewById(R.id.tv_cantidad_votos_7);
        tv_cantidad_votos_8 = findViewById(R.id.tv_cantidad_votos_8);

        Intent intent = getIntent();
        tipoPersona = intent.getStringExtra(Constantes.TIPO_PERSONA);
        id_super = intent.getStringExtra(Constantes.KEY_SUPER);

        rtdb = FirebaseDatabase.getInstance();

        String votos_id = UUID.randomUUID().toString();
        Votos votos = new Votos(votos_id, tipoPersona, id_super);

        rtdb.getReference().child("votos").child(votos_id).push().setValue(votos);

        calcularEstadisticas();
    }

    private void calcularEstadisticas() {
        double cantidadMA = calcularMujeresAdultas();
        double cantidadHA = calcularHombreAdultos();
        double cantidadMJ = calcularMujeresJovenes();
        double cantidadHJ = calcularHombresJovenes();
        double cantidadN = calcularNinos();
    }

    private double calcularMujeresAdultas() {
        double porcentaje = 0.0;
        rtdb.getReference().child("votos");
        return porcentaje;
    }

    private double calcularHombreAdultos() {
        double porcentaje = 0.0;
        return porcentaje;
    }

    private double calcularMujeresJovenes() {
        double porcentaje = 0.0;
        return porcentaje;
    }

    private double calcularHombresJovenes() {
        double porcentaje = 0.0;
        return porcentaje;
    }

    private double calcularNinos() {
        double porcentaje = 0.0;
        return porcentaje;
    }

}
