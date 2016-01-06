package com.example.maxim.simplelistmultiplechoice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {
    final String LOG_TAG = "MainActivity";
    ListView currenciesListView;
    String[] currencies;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currenciesListView = (ListView) findViewById(R.id.currenciesListView);
        currencies = getResources().getStringArray(R.array.currencies);
        currenciesListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.currencies,
                android.R.layout.simple_list_item_multiple_choice);
        currenciesListView.setAdapter(adapter);
        Button saveChoiceBtn = (Button) findViewById(R.id.saveChoiceBtn);
        saveChoiceBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        Log.d(LOG_TAG, "checked: ");
        SparseBooleanArray checkedCurrenciesArray =
                currenciesListView.getCheckedItemPositions();
        for (int i = 0; i < checkedCurrenciesArray.size(); i++) {
            int key = checkedCurrenciesArray.keyAt(i);
            if (checkedCurrenciesArray.get(key))
                Log.d(LOG_TAG, currencies[key]);
        }
    }
}
