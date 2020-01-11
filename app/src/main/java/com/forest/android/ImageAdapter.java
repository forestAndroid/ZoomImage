package com.forest.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.pixplicity.sharp.OnSvgElementListener;
import com.pixplicity.sharp.Sharp;
import com.pixplicity.sharp.SharpDrawable;
import com.pixplicity.sharp.SharpPicture;

import java.util.List;

public class ImageAdapter extends BaseRecylerAdapter<SvgBean> {

    private Context context;
    private boolean isCanLoadSvg = true;
    private RecyclerView recyclerView;

    public ImageAdapter(Context context, List<SvgBean> mSvgList, int layoutId,RecyclerView recyclerView) {
        super(context, mSvgList, layoutId);
        this.mDatas = mSvgList;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    public boolean isCanLoadSvg() {
        return isCanLoadSvg;
    }



    @Override
    public void convert(MyRecylerViewHolder holder, final int position) {
        ImageView svgView = holder.getView(R.id.svgView);
//            loadSvg(svgView, mDatas.get(position));
            Sharp.loadResource(context.getResources(), mDatas.get(position).resId).setOnElementListener(new OnSvgElementListener() {
                @Override
                public void onSvgStart(Canvas canvas, RectF bounds) {

                }

                @Override
                public void onSvgEnd(Canvas canvas, RectF bounds) {

                }

                @Override
                public <T> T onSvgElement(String id, T element, RectF elementBounds, Canvas canvas, RectF canvasBounds, Paint paint) {
                    return element;
                }

                @Override
                public <T> void onSvgElementDrawn(String id, T element, Canvas canvas, Paint paint) {


                }
            }).into(svgView);
    }

    private void loadSvg(final ImageView svgView, final SvgBean svgBean) {
        Sharp mSvg = Sharp.loadResource(context.getResources(), svgBean.resId);
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
                if (!TextUtils.isEmpty(id) && paint != null) {
//                    Random random = new Random();
//                    paint.setColor(Color.argb(255, random.nextInt(256),
//                            random.nextInt(256), random.nextInt(256)));

                    if (element instanceof Path &&paint!=null){
                        drawCurrentRectColor(canvas,(Path) element,id,paint,2);
                    }
                }
            }

        });
        mSvg.getSharpPicture(new Sharp.PictureCallback() {
            @Override
            public void onPictureReady(SharpPicture picture) {
                Drawable drawable = picture.getDrawable();
                SharpDrawable.prepareView(svgView);
                svgView.setImageDrawable(drawable);
            }
        });

    }


    //画区域的颜色
    private void drawCurrentRectColor(Canvas canvas,Path path,String stepPathId,Paint paint,int state){

        if(state==0){
            //这是不选中的情况下   设置边界 黑色
            paint.setStrokeWidth(4);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.FILL);
            paint.setShadowLayer(8, 0, 0, 0xffffff);
            canvas.drawPath(path, paint);
            //后面是填充 白色
            paint.clearShadowLayer();
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(2);
            canvas.drawPath(path, paint);
        }
        //选中的情况不用考虑，内部已经实现
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
