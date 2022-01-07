package com.devandroid.democallapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ImgAdapter adapter;
    List<IMG> list;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.lis);
        adapter=new ImgAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        api();
    }

    private void api() {
        callapi.c.currencyCall().enqueue(new Callback<List<IMG>>() {
            @Override
            public void onResponse(Call<List<IMG>> call, Response<List<IMG>> response) {
                list=response.body();
                if(list!=null){
                    adapter.setList(list);
                }
            }

            @Override
            public void onFailure(Call<List<IMG>> call, Throwable t) {

            }
        });
    }
}