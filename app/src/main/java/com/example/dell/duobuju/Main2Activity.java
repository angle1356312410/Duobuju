package com.example.dell.duobuju;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dell.duobuju.adapter.MyAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Main2Activity extends AppCompatActivity {

    private RecyclerView recycler;
    private ArrayList<Bean.ResultBean.DataBean> list = new ArrayList<>();

    String url = "http://172.16.46.1:8080/yy/news.json";
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

        getDta();


    }

    private void getDta() {

        OkHttpClient client = new OkHttpClient();
        Request build = new Request.Builder().url(url).build();
        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: 》》》》》》》》》失败了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG", "onFailure: 》》》》》》》》》成功啦");

                String string = response.body().string();
                Gson gson = new Gson();
                Bean bean = gson.fromJson(string, Bean.class);
                final List<Bean.ResultBean.DataBean> list = bean.getResult().getData();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new MyAdapter(Main2Activity.this, list);
                        recycler.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
                        recycler.setAdapter(adapter);
                    }
                });


            }
        });

    }

    private void initView() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
    }
}
