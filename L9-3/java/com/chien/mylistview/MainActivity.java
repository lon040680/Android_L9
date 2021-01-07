package com.chien.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    String[] fastfood;
    ArrayAdapter<String> adapter;
    ListView listView;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        //文字從String.xml接收
        fastfood = getResources().getStringArray(R.array.fastfood);

        //文字設定 simple_list_item_multiple_choice 這是可以多選
        // android.R.layout.simple_list_item_1, 只能單選
        //用 ArrayAdapter<>() 轉換取得的資料
        adapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_list_item_multiple_choice,
                fastfood
        );

        listView = findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter); //轉換後設定上 ListView 元件中

        //上listView 的點擊監聽
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String r1 = parent.getItemAtPosition(position).toString(); //利用引數參數取得資料
                String r2 = fastfood[position]; //用Arrays 直接呼叫
                String r3 = adapter.getItem(position).toString(); //利用引數參數取得資料
                //以上方法擇一使用
                Toast.makeText(context, r1, Toast.LENGTH_SHORT).show();
            }
        });
        show = findViewById(R.id.emptyView);
    }

    public void onClick(View view) {
        String all="";
        for(int i=0; i<fastfood.length; i++){
            if(listView.isItemChecked(i)){
                all += fastfood[i]+"\t";
            }
        }
        show.setText("選取項目有 : " +all); //收集全部結果
    }
}