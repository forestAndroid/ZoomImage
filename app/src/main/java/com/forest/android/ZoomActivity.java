package com.forest.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jsibbold.zoomage.ZoomageView;
import com.pixplicity.sharp.OnSvgElementListener;
import com.pixplicity.sharp.Sharp;
import com.pixplicity.sharp.SharpDrawable;
import com.pixplicity.sharp.SharpPicture;

import java.util.ArrayList;
import java.util.List;

public class ZoomActivity extends AppCompatActivity {


    private ZoomageView imageView;
    private RecyclerView recyclerView;
    private int resId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.recyclerView);


        imageView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        Sharp.loadResource(getResources(),getIntent().getIntExtra("resId",0)).into(imageView);
    }
}
