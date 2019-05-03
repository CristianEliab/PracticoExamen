package appmoviles.com.practicoexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Preguntas extends AppCompatActivity implements AdapterAmigos.OnItemClickListener {

    private RecyclerView lista_super;
    private AdapterAmigos adapterAmigos;
    private String tipo_persona;

    FirebaseDatabase rtdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        Intent intent = getIntent();
        tipo_persona = intent.getStringExtra(Constantes.TIPO_PERSONA);

        rtdb = FirebaseDatabase.getInstance();
        lista_super = findViewById(R.id.lista_super_heroes);

        adapterAmigos = new AdapterAmigos();
        adapterAmigos.setListener(this);

        Super super_1 = new Super("Spiderman","1", "El araña");
        Super super_2 = new Super("IronMan","2", "El tony");
        Super super_3 = new Super("Capitan America","3", "El heroe");
        Super super_4 = new Super("Capitana Marvel","4", "El habladora");
        Super super_5 = new Super("Hulk","5", "El gallina");
        Super super_6 = new Super("Viuda negra","6", "La que muere");
        Super super_7 = new Super("Thor","7", "El dios");
        Super super_8 = new Super("Doctor Strange","8", "El doctor");

        adapterAmigos.agregarSuper(super_1);
        adapterAmigos.agregarSuper(super_2);
        adapterAmigos.agregarSuper(super_3);
        adapterAmigos.agregarSuper(super_4);
        adapterAmigos.agregarSuper(super_5);
        adapterAmigos.agregarSuper(super_6);
        adapterAmigos.agregarSuper(super_7);
        adapterAmigos.agregarSuper(super_8);

        lista_super.setLayoutManager(new LinearLayoutManager(this));
        lista_super.setAdapter(adapterAmigos);
        lista_super.setHasFixedSize(true);
    }

    @Override
    public void onItemClick(Super aSuper) {
        Intent i = new Intent(Preguntas.this, Estadisticas.class);
        i.putExtra(Constantes.KEY_SUPER,""+ aSuper.getTipo_Super());
        i.putExtra(Constantes.TIPO_PERSONA,tipo_persona);
        startActivity(i);

    }
}
