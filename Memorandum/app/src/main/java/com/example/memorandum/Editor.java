package com.example.memorandum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Editor extends AppCompatActivity {

    CharSequence textSequence = "保存成功!";
    int duration = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onButtonClicked(View view){
        EditText titleView = (EditText) findViewById(R.id.edit_title);
        EditText textView = (EditText) findViewById(R.id.edit_text);
        String title = titleView.getText().toString();
        String text = textView.getText().toString();
        note.abcd.add(new note(title, text));
        textView.setText(null);
        titleView.setText(null);

        Toast toast = Toast.makeText(this, textSequence, duration);
        toast.show();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.finish_note:
                EditText titleView = (EditText) findViewById(R.id.edit_title);
                EditText textView = (EditText) findViewById(R.id.edit_text);
                String title = titleView.getText().toString();
                String text = textView.getText().toString();
                note.abcd.add(new note(title, text));
                textView.setText(null);
                titleView.setText(null);
                Toast toast = Toast.makeText(this, textSequence, duration);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
