package sg.edu.rp.c346.id21022186.l10ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etSingers;
    EditText etYear;
    RadioGroup starsGrp;
    Button insert, showList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        starsGrp = findViewById(R.id.starsGrp);
        insert = findViewById(R.id.insert);
        showList = findViewById(R.id.showList);



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String singer = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int star = Integer.parseInt(((RadioButton) findViewById(starsGrp.getCheckedRadioButtonId()))
                        .getText().toString());
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(title,singer,year,star);


            }
        });

        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        show_Songs.class);

                startActivity(intent);



            }
        });
    }
}