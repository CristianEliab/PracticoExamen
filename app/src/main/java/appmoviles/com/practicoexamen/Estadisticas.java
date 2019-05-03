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

    private double proba_super_1;
    private double proba_super_2;
    private double proba_super_3;
    private double proba_super_4;
    private double proba_super_5;
    private double proba_super_6;
    private double proba_super_7;
    private double proba_super_8;

    private int cantidad_super_1;
    private int cantidad_super_2;
    private int cantidad_super_3;
    private int cantidad_super_4;
    private int cantidad_super_5;
    private int cantidad_super_6;
    private int cantidad_super_7;
    private int cantidad_super_8;


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
        String super_id = UUID.randomUUID().toString();
        Votos voto = new Votos(votos_id, tipoPersona, id_super);

        String tipo_publico = "6";
        Votos voto2 = new Votos(votos_id, tipo_publico, id_super);
        rtdb.getReference().child("votos").push().setValue(voto);
        rtdb.getReference().child("votos").push().setValue(voto2);

        rtdb.getReference().child("cantidad").child(tipoPersona).child(id_super).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot hijo : dataSnapshot.getChildren()) {
                    Votos a = hijo.getValue(Votos.class);

                    int cantidad_super_1 = 0;
                    int cantidad_super_2 = 0;
                    int cantidad_super_3 = 0;
                    int cantidad_super_4 = 0;
                    int cantidad_super_5 = 0;
                    int cantidad_super_6 = 0;
                    int cantidad_super_7 = 0;
                    int cantidad_super_8 = 0;

                    if (a.getVoto().equals("1")) {
                        cantidad_super_1 = cantidad_super_1 + 1;
                    }
                    if (a.getVoto().equals("2")) {
                        cantidad_super_2 = cantidad_super_2 + 1;
                    }
                    if (a.getVoto().equals("3")) {
                        cantidad_super_3 = cantidad_super_3 + 1;
                    }
                    if (a.getVoto().equals("4")) {
                        cantidad_super_4 = cantidad_super_4 + 1;
                    }
                    if (a.getVoto().equals("5")) {
                        cantidad_super_5 = cantidad_super_5 + 1;
                    }
                    if (a.getVoto().equals("6")) {
                        cantidad_super_6 = cantidad_super_6 + 1;
                    }
                    if (a.getVoto().equals("7")) {
                        cantidad_super_7 = cantidad_super_7 + 1;
                    }
                    if (a.getVoto().equals("8")) {
                        cantidad_super_8 = cantidad_super_8 + 1;
                    }

                    int ma = 0;
                    int mj = 0;
                    int ha = 0;
                    int hj = 0;
                    int n = 0;
                    int total = 0;

                    if (a.getTipo_persona().equals("1")) {
                        ma = ma + 1;
                    }
                    if (a.getTipo_persona().equals("2")) {
                        mj = mj + 1;
                    }
                    if (a.getTipo_persona().equals("3")) {
                        ha = ha + 1;
                    }
                    if (a.getTipo_persona().equals("4")) {
                        hj = hj + 1;
                    }
                    if (a.getTipo_persona().equals("5")) {
                        n = n + 1;
                    }
                    if (a.getTipo_persona().equals("6")) {
                        total = total + 1;
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void mostrar() {
        tv_cantidad_votos_1.setText(proba_super_1 + "");
        tv_cantidad_votos_2.setText(proba_super_2 + "");
        tv_cantidad_votos_3.setText(proba_super_3 + "");
        tv_cantidad_votos_4.setText(proba_super_4 + "");
        tv_cantidad_votos_5.setText(proba_super_5 + "");
        tv_cantidad_votos_6.setText(proba_super_6 + "");
        tv_cantidad_votos_7.setText(proba_super_7 + "");
        tv_cantidad_votos_8.setText(proba_super_8 + "");
    }

}
