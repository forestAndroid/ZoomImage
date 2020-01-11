package com.forest.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyRecylerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //    public DisplayImageOptions options ;
    private final SparseArray<View> mViews = new SparseArray<View>();
    public View mConvertView;
    public OnItemClickListener mOnItemClickListener;

    public MyRecylerViewHolder(View itemView) {
        super(itemView);
        mConvertView = itemView;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
        mConvertView.setOnClickListener(this);
    }

    public View getHolderView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public TextView getTextView(int viewId) {
        return (TextView) getView(viewId);
    }
    public EditText getEditText(int viewId){
        return (EditText) getView(viewId);
    }



    public ProgressBar getProgressBar(int viewId) {
        return (ProgressBar) getView(viewId);
    }

    public Button getButton(int viewId) {
        return (Button) getView(viewId);
    }

    public LinearLayout getLinearLayout(int viewId) {
        return (LinearLayout) getView(viewId);
    }

    public RelativeLayout getRelativeLayout(int viewId) {
        return (RelativeLayout) getView(viewId);
    }

    public ImageView getImageView(int viewId) {
        return (ImageView) getView(viewId);
    }

    public CheckBox getCheckBox(int viewId) {
        return (CheckBox) getView(viewId);
    }

    public RatingBar getRatingBar(int viewId) {
        return (RatingBar) getView(viewId);
    }

    public GridView getGridView(int viewId) {
        return (GridView) getView(viewId);
    }

    public RecyclerView getRecycleView(int viewId) {
        return (RecyclerView) getView(viewId);
    }


    public ImageButton getImageButton(int viewId) {
        return (ImageButton) getView(viewId);
    }


    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public MyRecylerViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    public MyRecylerViewHolder setTextColor(int viewId, int colorId) {
        TextView view = getView(viewId);
        view.setTextColor(colorId);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public MyRecylerViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId ImageView的Id
     * @param imgUrl 图片的url
     * @return 链式调用
     */
    public MyRecylerViewHolder setGlideImage(Context mContext, int viewId, String imgUrl) {
        ImageView view = getView(viewId);
//        GlideImageLoader.getInstance().onDisplayImage(mContext, view, imgUrl);
        return MyRecylerViewHolder.this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @return
     */
    public MyRecylerViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(mConvertView, getAdapterPosition());
        }
    }



    public interface OnItemClickListener {

        /**
         * @param view     承载item的view
         * @param position 被点击的item的位置
         */
        void onItemClick(View view, int position);

    }
}
/**
 * 为ImageView设置图片
 * @return 为ImageView设置图片     4
 * @param viewId
 * @return
 */
//    public MyRecylerViewHolder setImageByUrl(int viewId, String url)
//    {
//        if(!TextUtils.isEmpty(url)){
//            ImageView img = getView(viewId);
//            if(options==null)
//                options= new DisplayImageOptions.Builder()
//                    .showImageOnLoading(R.mipmap.ic_launcher)
//                    .showImageForEmptyUri(R.mipmap.ic_launcher)
//                    .showImageOnFail(R.mipmap.ic_launcher)
//                    .cacheInMemory(true)
//                    .cacheOnDisc(true)
//                    .displayer(new FadeInBitmapDisplayer(200))// 淡入
//                    .bitmapConfig(Bitmap.Config.RGB_565)
//                    .considerExifParams(true).build();
//            ImageLoader.getInstance().displayImage(url, img, options);
//        }else{
//            //TODO 默认图片
//        }
//        return this;
//    }

/**
 * 为ImageView设置图片     4
 *
 * @param viewId
 * @return
 */
//    public MyRecylerViewHolder setImageByUrlHasTag(int viewId, final String url, DisplayImageOptions option)
//    {
//        ImageView img = getView(viewId);
//        img.setTag(url);
//        ImageLoader.getInstance().displayImage(url, img, option,new SimpleImageLoadingListener(){
//            @Override
//            public void onLoadingComplete(String imageUri, ILoginView view,
//                                          Bitmap loadedImage) {
//                super.onLoadingComplete(imageUri, view, loadedImage);
//                if(view.getTag().equals(url)){
//                    ((ImageView)view).setImageBitmap(loadedImage);
//                }
//            }
//
//        });
//        return this;
//    }
//}
