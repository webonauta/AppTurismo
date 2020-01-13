package com.example.appturismo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appturismo.R;
import com.example.appturismo.models.Slide;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter{

    private Context mContext;
    private List<Slide> mList;

    public SliderPagerAdapter(Context mContext, List<Slide> mList){
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View slideLayout = inflater.inflate(R.layout.slider_item, null);

        ImageView sliderImg = slideLayout.findViewById(R.id.slider_img);
        TextView sliderText = slideLayout.findViewById(R.id.slider_title);
        sliderImg.setImageResource(mList.get(position).getImage());
        sliderText.setText(mList.get(position).getTitle());

        container.addView(slideLayout);
        return slideLayout;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
