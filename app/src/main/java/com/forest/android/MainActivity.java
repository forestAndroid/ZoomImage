package com.forest.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.jsibbold.zoomage.ZoomageView;
import com.pixplicity.sharp.OnSvgElementListener;
import com.pixplicity.sharp.Sharp;
import com.pixplicity.sharp.SharpDrawable;
import com.pixplicity.sharp.SharpPicture;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ZoomageView imageView;
    private RecyclerView recyclerView;


    private List<SvgBean> svgBeanList;
    private ImageAdapter imageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//teststsdsds
        imageView = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        initRes();
        imageAdapter = new ImageAdapter(this, svgBeanList, R.layout.item_sub_lib_pic,recyclerView);
        recyclerView.setAdapter(imageAdapter);
        imageAdapter.setOnItemClickLitener(new BaseRecylerAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
//                imageView.setVisibility(View.VISIBLE);
//                loadSvg(svgBeanList.get(position).resId);
                startActivity(new Intent(MainActivity.this,ZoomActivity.class).putExtra("resId",svgBeanList.get(position).resId));

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
            }
        });
    }


    private void initRes(){
        svgBeanList = new ArrayList<>();
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a810));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a821));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a860));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a908));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a910));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a917));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a940));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1020));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1025));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1164));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1166));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1170));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1179));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1217));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1246));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1254));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1347));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1387));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1450));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1467));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1479));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1480));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1532));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1800));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1814));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1895));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1914));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1916));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1938));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.a1995));
        svgBeanList.add(new SvgBean(getResources().getResourceName(R.raw.a810),R.raw.rule));
    }


    private void loadSvg(int resId) {
        Sharp mSvg = Sharp.loadResource(getResources(), resId);
        mSvg.setOnElementListener(new OnSvgElementListener() {

            @Override
            public void onSvgStart(@NonNull Canvas canvas,
                                   @Nullable RectF bounds) {
            }

            @Override
            public void onSvgEnd(@NonNull Canvas canvas,
                                 @Nullable RectF bounds) {
            }

            @Override
            public <T> T onSvgElement(@Nullable String id,
                                      @NonNull T element,
                                      @Nullable RectF elementBounds,
                                      @NonNull Canvas canvas,
                                      @Nullable RectF canvasBounds,
                                      @Nullable Paint paint) {

                return element;
            }

            @Override
            public <T> void onSvgElementDrawn(@Nullable String id,
                                              @NonNull T element,
                                              @NonNull Canvas canvas,
                                              @Nullable Paint paint) {

            }

        });
        mSvg.getSharpPicture(new Sharp.PictureCallback() {
            @Override
            public void onPictureReady(SharpPicture picture) {
                Drawable drawable = picture.getDrawable();
                SharpDrawable.prepareView(imageView);
                imageView.setImageDrawable(drawable);
            }
        });

    }
}
