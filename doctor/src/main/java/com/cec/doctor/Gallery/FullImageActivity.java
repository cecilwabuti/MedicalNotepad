package com.cec.doctor.Gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.cec.doctor.R;

import java.util.Objects;

public class FullImageActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_full_scale);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = Objects.requireNonNull(i.getExtras()).getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }
    
}
