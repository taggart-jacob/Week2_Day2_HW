package com.example.week2_day2_hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoriesAnimals extends AppCompatActivity {

    ArrayList<String> categoryList = new ArrayList<>();
    ListView categories;
    View tvAnimal;
    RecyclerView animalRecyclerList;
    Intent animalIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_animals);
        categories = findViewById(R.id.lvCategories);
        //populates that list
        populateCategories();
        //initializes and defines the ArrayAdapter
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoryList);
        //sets the adapter to the view
        categories.setAdapter(categoryAdapter);

        categories.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //assigns the intent to the context of the view to the animal list
                animalIntent = new Intent(view.getContext(), AnimalList.class);
                startActivity(animalIntent);
            }
        });

    }

    private void initializeRecyclerView(){
        animalRecyclerList = findViewById(R.id.rvAnimalRecycler);
        //creates layout manager with context of this
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //passes the movie list into the recycler view adapter for it to adapt
        RecyclerView animalRecyclerViewAdapter = new AnimalRecyclerViewAdapter(categories);
        //decides how to render layout
        animalRecyclerViewAdapter.setLayoutManager(layoutManager);
        //sets the adapter for the list and passes the specific adapter
        animalRecyclerList.setAdapter(animalRecyclerViewAdapter);

    }

    private void populateCategories() {
        categoryList.add("Mammals");
        categoryList.add("Amphibians");
        categoryList.add("Fish");
    }

}
