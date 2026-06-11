package com.example.devhub;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ProjectListActivity extends AppCompatActivity {
    private ListView listView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);

        listView = findViewById(R.id.listView);
        imageView = findViewById(R.id.imageView);

        ItemAdapter adapter = new ItemAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> p, View v, int pos, long id) {
                int imageResId = R.drawable.portfolio_preview;

                BitmapFactory.Options options = new BitmapFactory.Options();

                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(getResources(), imageResId, options);

                options.inSampleSize = 2;
                options.inJustDecodeBounds = false;

                Bitmap scaledBitmap = BitmapFactory.decodeResource(getResources(), imageResId, options);
                imageView.setImageBitmap(scaledBitmap);
            }
        });
    }
}