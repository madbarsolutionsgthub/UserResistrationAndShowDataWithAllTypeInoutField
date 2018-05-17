package org.bitm.pencilbox.userloginpb5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    private List<BaseSalariedEmployee>bse = new ArrayList<>();
    private EmployeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.listView);
        bse = BaseSalariedEmployee.getEmpList();
        adapter = new EmployeeAdapter(this,bse);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(ListActivity.this,DetailsActivity.class)
                .putExtra("emp",position));
            }
        });
    }

    public void addEmployee(View view) {
        startActivity(new Intent(this,HomeActivity.class));
    }
}
