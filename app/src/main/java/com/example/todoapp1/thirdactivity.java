package com.example.todoapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class thirdactivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {

    private EditText itemET1;
    private Button btn1;
    private ListView itemsList1;

    private ArrayList<String> items1;
    private ArrayAdapter<String> adapter1;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdactivity);

        itemET1=findViewById(R.id.item_edit_text2);
        btn1=findViewById(R.id.add_btn2);
        itemsList1=findViewById(R.id.items_list2);

        items1 = FileHelper2.readData( this);

        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items1);
        itemsList1.setAdapter(adapter1);

        btn1.setOnClickListener(this);
        itemsList1.setOnItemClickListener(this);


        textView=(TextView)findViewById(R.id.txtitem);

        String Tempholder=getIntent().getStringExtra("Listviewclickvalue");

        textView.setText(Tempholder);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn2:
                String itemEntered=itemET1.getText().toString();
                adapter1.add(itemEntered);
                itemET1.setText("");

                FileHelper2.writeData(items1,this);

                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        items1.remove(i);
        adapter1.notifyDataSetChanged();

        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();

    }
}

