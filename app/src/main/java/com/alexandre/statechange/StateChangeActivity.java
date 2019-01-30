package com.alexandre.statechange;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.EditText;

public class StateChangeActivity extends AppCompatActivity {

    private static final String TAG = "StateChange";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_change);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.i(TAG, "onCretate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_state_change, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Conceito do ciclo de vida da Activity - onStart chamado.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Conceito do ciclo de vida da Activity - onResume chamado.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Conceito do ciclo de vida da Activity - onPause chamado.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Conceito do ciclo de vida da Activity - onStop chamado.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Conceito do ciclo de vida da Activity - onRestart chamado.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Conceito do ciclo de vida da Activity - onDestroy chamado.");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Salvando dinamicamente o estado-contexto da Activity - onSaveInstanceState chamado.");

        final EditText textBox = (EditText) findViewById(R.id.editText);
        CharSequence userText = textBox.getText();
        outState.putCharSequence("textoSalvo", userText);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "Restaurando dinamicamente o estado-contexto da Activity - onRestoreInstanceState chamado.");

        final EditText textBox = (EditText) findViewById(R.id.editText);

        CharSequence userText = savedInstanceState.getCharSequence("textoSalvo");

        textBox.setText(userText);
    }
}
