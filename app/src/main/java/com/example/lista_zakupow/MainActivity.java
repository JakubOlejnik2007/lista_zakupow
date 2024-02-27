package com.example.lista_zakupow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonAdd;
    private Button buttonReset;
    private EditText poleEdycyjne;
    private ListView listView;
    private List<String> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonReset = findViewById(R.id.buttonReset);
        listView = findViewById(R.id.listView);
        poleEdycyjne = findViewById(R.id.editText);

        buttonAdd.setOnClickListener(this::handleAddElementButtonOnClick);
        buttonReset.setOnClickListener(this::handleResetButtonOnClick);
        listView.setOnItemClickListener(this::removeElementFromListView);
    }

    private void removeElementFromListView(AdapterView<?> adapterView, View view, int i, long l) {
        lista.remove(i);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);

    }

    private void handleAddElementButtonOnClick(View view) {
        String poleEdycyjneValue = poleEdycyjne.getText().toString().trim();
        if(poleEdycyjneValue.isEmpty()) return;
        else {
            lista.add(poleEdycyjneValue);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
            listView.setAdapter(adapter);
            clearEditText();
        }
    }

    private void handleResetButtonOnClick(View view) {
        lista = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);
    }
    private void clearEditText() {
        poleEdycyjne.setText("");
    }
}