package com.example.assignment1;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
   ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.listView);
          Adapter2 myAdapter=new Adapter2();
          listView.setAdapter(myAdapter);


    }
    private class Adapter2 extends BaseAdapter{

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.expendable_item, parent,false);

            LinearLayout motherLayout = myView.findViewById(R.id.motherLayout);
            RelativeLayout itemClicked = myView.findViewById(R.id.itemClicked);
            ImageView arrowImg = myView.findViewById(R.id.arrowImg);
            LinearLayout discLayout = myView.findViewById(R.id.discLayout);

            itemClicked.setOnClickListener(v -> {

                if (discLayout.getVisibility() == View.GONE){
                    TransitionManager.beginDelayedTransition(motherLayout, new AutoTransition());
                    discLayout.setVisibility(View.VISIBLE);
                    motherLayout.setBackgroundColor(Color.parseColor("#724CAF50"));
                    arrowImg.setImageResource(R.drawable.ic_down_arrow);
                } else {
                    TransitionManager.beginDelayedTransition(motherLayout, new AutoTransition());
                    discLayout.setVisibility(View.GONE);
                    motherLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    arrowImg.setImageResource(R.drawable.ic_down_arrow);
                }
            });
            return null;
        }
    }
}