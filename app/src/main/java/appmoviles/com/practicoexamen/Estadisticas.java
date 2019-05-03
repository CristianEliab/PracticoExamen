package appmoviles.com.practicoexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Estadisticas extends AppCompatActivity {

    private String id_super;
    private String tipoPersona;

    FirebaseDatabase rtdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        Intent intent = getIntent();
        tipoPersona = intent.getStringExtra(Constantes.TIPO_PERSONA);
        id_super = intent.getStringExtra(Constantes.KEY_SUPER);

        rtdb = FirebaseDatabase.getInstance();

        String votos_id = UUID.randomUUID().toString();
        Votos votos = new Votos(votos_id, tipoPersona, id_super);
        rtdb.getReference().child("votos").child(votos_id).push().setValue(votos);


    }
}
