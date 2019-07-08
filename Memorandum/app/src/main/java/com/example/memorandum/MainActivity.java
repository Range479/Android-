package com.example.memorandum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    CharSequence text = "Welcome!";
    int duration = Toast.LENGTH_LONG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toast toast = Toast.makeText(this, text, duration);
        toast.show();

        ArrayAdapter<note> listNote = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, note.abcd);
        ListView listNotes = (ListView) findViewById(R.id.list);
        listNotes.setAdapter(listNote);
        Utility.setListViewHeightBasedOnChildren(listNotes);

        AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> listNotes, View itemView, int position, long id){
                    Intent intent = new Intent(MainActivity.this, Read.class);
                    intent.putExtra(Read.EXTRA_NOTEID, (int) id);
                    startActivity(intent);
                }
            };
        listNotes.setOnItemClickListener(itemClickListener);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_editor_note:
                Intent intent = new Intent(this, Editor.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
