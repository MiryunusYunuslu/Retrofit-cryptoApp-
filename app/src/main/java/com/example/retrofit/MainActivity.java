package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private String baseurl = "https://api.nomics.com/v1/";
    private ArrayList<TimeAze> timeaze;
    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        setretrofit();
    }

    private void setretrofit() {
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create(gson)).build();
        loadmydata();
    }

    private void loadmydata() {
        TimeApi timeapi = retrofit.create(TimeApi.class);
        Call<List<TimeAze>> call = timeapi.gettime();
        call.enqueue(new Callback<List<TimeAze>>() {
            @Override
            public void onResponse(Call<List<TimeAze>> call, Response<List<TimeAze>> response) {
                if (response.isSuccessful()) {
                    List<TimeAze> responseinfo = response.body();
                    timeaze = new ArrayList<>(responseinfo);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapter=new Adapter(timeaze);
                    recyclerView.setAdapter(adapter);

                }

            }

            @Override
            public void onFailure(Call<List<TimeAze>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}