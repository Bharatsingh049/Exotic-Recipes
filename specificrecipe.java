package com.example.bullet.recipesearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.round;

public class specificrecipe extends AppCompatActivity {
public ArrayList<String> urllll=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_specificrecipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<String> Ingredients = getIntent().getStringArrayListExtra("ingredients");
        ArrayList<String> Nutrientslabel = getIntent().getStringArrayListExtra("nutrientslabel");
        ArrayList<String> NTR=new ArrayList<>();
        ArrayList<Integer> Nutrientsquantity = getIntent().getIntegerArrayListExtra("nutrientsquantity");
        //Log.e("nutrients label ",Nutrientslabel.);
        String Both,Label = getIntent().getStringExtra("label");
        String[]        DIETLABELS=getIntent().getStringArrayExtra("Dietlabels"),
                HEALTHLABELS=getIntent().getStringArrayExtra("Healthlabels");
        urllll.add(0,getIntent().getStringExtra("URL"));
        Integer pos = getIntent().getIntExtra("position", 0);
        String url2img = getIntent().getStringExtra("urltoimage");
        TextView labelr = (TextView) findViewById(R.id.labelr);
        TextView DIETview = (TextView) findViewById(R.id.DIET_labels);
        TextView ingre = (TextView) findViewById(R.id.Ingredients_list);
        TextView nutri_label = (TextView) findViewById(R.id.nutri_label);
        TextView nutri_quantity = (TextView) findViewById(R.id.nutri_quantity);
        ImageView imgview = (ImageView) findViewById(R.id.Image_R);
        Glide.with(imgview.getContext()).load(url2img).into(imgview);
        labelr.setText(Label);
        //Both=DIETLABELS+" "+HEALTHLABELS;
        for(int i=0;DIETLABELS[i]!=null;i++){
        DIETview.append(DIETLABELS[i]);}
        for(int i=0;HEALTHLABELS[i]!=null;i++){
            DIETview.append("        "+HEALTHLABELS[i]);}
        for(int i=0;i<Nutrientslabel.size();i++){
            NTR.add(i,Nutrientslabel.get(i)+"                "+round(Nutrientsquantity.get(i)));
        }
       // ArrayList arrayList=new ArrayList();
        for(int i=0;i<(Ingredients.size());i++)
        {
            ingre.append(" \n "+Ingredients.get(i));
        }
        for(int i=0;i<(NTR.size());i++)
        {
            nutri_label.append(" \n "+Nutrientslabel.get(i));
        }
        for(int i=0;i<(NTR.size());i++)
        {
            nutri_quantity.append(" \n "+round(Nutrientsquantity.get(i)));
        }
       //ListAdapter ingredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Ingredients);
        //ListAdapter nutrilabelAapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NTR);
        //ListAdapter nutriquantityAapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,Nutrientsquantity);
            //ingre.setAdapter(ingredientsAdapter);
            //nutri_label.setAdapter(nutrilabelAapter);
           // nutri_quantity.setAdapter(nutriquantityAapter);
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {
             //   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //            .show();
          //  }
        //});


    }
    public void howtoprepare(View view){
        String URL=urllll.get(0);
        Log.d("URLLLLLLLLL",URL);
        Intent i=new Intent(this,how2prep.class);
        i.putExtra("URL",URL);
        this.startActivity(i);   }


    }


