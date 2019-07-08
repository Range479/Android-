package com.example.memorandum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ShareActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;

public class Read extends AppCompatActivity {

    public static final String EXTRA_NOTEID = "noteId";
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        int noteId = (Integer)getIntent().getExtras().get(EXTRA_NOTEID);
        note notes = note.abcd.get(noteId);

        TextView title = (TextView)findViewById(R.id.read_title);
        title.setText(notes.getTitle());

        TextView text = (TextView)findViewById(R.id.read_text);
        text.setText(notes.getText());
    }

    public boolean onCreateOptionsMenu(Menu menu){
        int noteId = (Integer)getIntent().getExtras().get(EXTRA_NOTEID);
        note notes = note.abcd.get(noteId);
        getMenuInflater().inflate(R.menu.menu_read, menu);
        MenuItem menuItem = menu.findItem(R.id.read_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent(notes.getText());
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }
}
