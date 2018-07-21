package com.example.rathana.recyclerview_demo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rathana.recyclerview_demo.adapter.FruitAdapter;
import com.example.rathana.recyclerview_demo.data.Database;
import com.example.rathana.recyclerview_demo.data.local.FruitRepository;
import com.example.rathana.recyclerview_demo.entity.Fruit;
import com.hendraanggrian.widget.PaginatedRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    private PaginatedRecyclerView recyclerView;
    private FruitAdapter fruitAdapter;
    private Database database;
    private List<Fruit> fruits=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);

        //setup recycler view and adapter
        database= Database.getInstance();
        initRecyclerView();

        //getFruits();
    }

    private void initRecyclerView() {
        fruitAdapter=new FruitAdapter(this);
        fruitAdapter.setFruits(fruits);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fruitAdapter);
        recyclerView.setPagination(paging);
    }

    private PaginatedRecyclerView.Pagination paging= new PaginatedRecyclerView.Pagination() {
        @Override
        public int getPageStart() {
            return 1;
        }

        @Override
        public void onPaginate(final int i) {
            page=i;
            if(isLoading){
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        getFruits(page);
                        notifyLoadingCompleted();
                    }
                },2000);

            }
            if(page==totalPages)
                notifyPaginationFinished();

            Log.e(TAG, "onPaginate: "+i);
        }
    } ;

    private static final String TAG = "MainActivity";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            String title=data.getStringExtra("title");
            int id =data.getIntExtra("pos",0);
            //update fruits List
            Fruit fruit=new Fruit();
            fruit.setId(id);
            fruit.setTitle(title);
            updateFruit(fruit);
            Log.e("MainActivity",title);

        }
    }

    private void updateFruit(Fruit fruit) {
        fruit.setImage(R.drawable.grape);
        fruitAdapter.updateFruit(fruit);
    }

    public void getFruits(int page){
        FruitRepository fruitRepository= database.getFruitRepository();
        List<Fruit> list=fruitRepository.getFruitsByPage(page);
        fruitAdapter.updateFruits(list);

        if(page<=totalPages)
            isLoading=true;
        else
            isLoading=false;
    }

    private boolean isLoading=true;
    private int totalPages=5;
    private  int page;
}
