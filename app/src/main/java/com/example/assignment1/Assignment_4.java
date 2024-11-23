package com.example.assignment1;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Assignment_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment4);

        ListView listView = findViewById(R.id.listView);

        // Sample data with 15 mini Ayat (titles) and their English translations (subtitles)
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("In the name of Allah, the Most Gracious, the Most Merciful", "Surah Al-Fatiha 1:1"));
        items.add(new Item("Indeed, Allah is with the patient", "Surah Al-Baqarah 2:153"));
        items.add(new Item("There is no deity except You; Glory is to You. Indeed, I have been of the wrongdoers", "Surah Al-Anbiya 21:87"));
        items.add(new Item("For indeed, with hardship [will be] ease", "Surah Ash-Sharh 94:6"));
        items.add(new Item("Indeed, Allah loves those who rely [upon Him]", "Surah Aal-E-Imran 3:159"));
        items.add(new Item("And establish the prayer and give the zakah", "Surah Al-Baqarah 2:43"));
        items.add(new Item("So remember Me; I will remember you", "Surah Al-Baqarah 2:152"));
        items.add(new Item("And put your trust in Allah", "Surah Al-Ahzab 33:3"));
        items.add(new Item("And do not despair of Allah's mercy", "Surah Yusuf 12:87"));
        items.add(new Item("Indeed, Allah is Forgiving and Merciful", "Surah Al-Baqarah 2:173"));
        items.add(new Item("Indeed, with hardship comes ease", "Surah Ash-Sharh 94:5"));
        items.add(new Item("Allah is the Light of the heavens and the earth", "Surah An-Nur 24:35"));
        items.add(new Item("And I did not create the jinn and mankind except to worship Me", "Surah Adh-Dhariyat 51:56"));
        items.add(new Item("Indeed, Allah is over all things competent", "Surah Al-Baqarah 2:284"));
        items.add(new Item("Say, 'He is Allah, [Who is] One'", "Surah Al-Ikhlas 112:1"));

        // Set adapter
        MyAdapter adapter = new MyAdapter(this, items);
        listView.setAdapter(adapter);
    }
}
