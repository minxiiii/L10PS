package sg.edu.rp.c346.id21022186.l10ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class show_Songs extends AppCompatActivity {

    Button btn5stars;
    ListView List;
    ArrayList<Songs> al;
  //  ArrayAdapter<Songs> aa;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_songs);

        btn5stars = findViewById(R.id.btn5stars);
        List = findViewById(R.id.List);

        al = new ArrayList<Songs>();


       // aa = new ArrayAdapter<Songs>(this,
                //android.R.layout.simple_list_item_1, al);
        adapter = new CustomAdapter(this,R.layout.row,al);


        //List.setAdapter(aa);
        List.setAdapter(adapter);


        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int i, long l) {
                Intent intent = getIntent();
                Songs data = al.get(i);
                intent.putExtra("data", data);
                startActivity(intent);

                DBHelper dbh = new DBHelper(show_Songs.this);
                al.clear();
                al.addAll(dbh.getAllSongs());
                adapter.notifyDataSetChanged();

            }
        });

        btn5stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(show_Songs.this);
                al.clear();
                al.addAll(dbh.getAllFilteredSongs(5));


            }
        });

    }
}