package com.app.threadvolley.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.threadvolley.ADAPTER.ResoponceAdapter;
import com.app.threadvolley.Model.Population;
import com.app.threadvolley.Model.Worldpopulation;
import com.app.threadvolley.R;
import com.app.threadvolley.THREAD.ResponceThread;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycleview;
    private LinearLayoutManager layoutManager;
    private List<Worldpopulation> models;
    private ResoponceAdapter resoponceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getIds();
        retrieve();
        new ResponceThread(MainActivity.this, models, getResp).start();
    }

    private void getIds() {
        try {
            recycleview = (RecyclerView) findViewById(R.id.recyclerview);

            layoutManager = new LinearLayoutManager(MainActivity.this);
            recycleview.setLayoutManager(layoutManager);
            recycleview.setHasFixedSize(true);
            models = new ArrayList<>();
            resoponceAdapter = new ResoponceAdapter(MainActivity.this, models);
            recycleview.setAdapter(resoponceAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void retrieve() {
        try {


            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    resoponceAdapter.notifyDataSetChanged();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface getResponce {
        void onSelect(Population vv);

    }

    getResponce getResp = new getResponce() {
        @Override
        public void onSelect(Population vv) {
            models.clear();
            models.addAll(vv.getWorldpopulation());
            retrieve();
        }
    };
}
