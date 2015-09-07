package com.idreamo.rrtoyewx.smipledemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.idreamo.rrtoyewx.smipledemo.entity.TotalNewsModel;
import com.idreamo.rrtoyewx.smipledemo.page.BaseContentPage;
import com.idreamo.rrtoyewx.smipledemo.page.NewsContentPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrtoyewx on 15/9/6.
 */
public class NewsPageContentAdapter extends PagerAdapter {
    private Context mContext;
    private List<TotalNewsModel> mTotalNewsModelList;
    protected List<BaseContentPage> mPageList;


    @Override
    public int getCount() {
        return mTotalNewsModelList.size();
    }

    public NewsPageContentAdapter(List<TotalNewsModel> totalNewsModelList,Context context) {
        this.mTotalNewsModelList = totalNewsModelList;
        mPageList = new ArrayList<>(mTotalNewsModelList.size());
        mContext = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return (CharSequence) mTotalNewsModelList.get(position).getValue().get(TotalNewsModel.news_title);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        NewsContentPage newsContentPage = new NewsContentPage(mContext);
        container.addView(newsContentPage.getRootView());
        newsContentPage.setUrl((String) mTotalNewsModelList.get(position).getValue().get(TotalNewsModel.news_url));
        mPageList.add(position,newsContentPage);
        if(position == 0){
            newsContentPage.initData();
        }
        return newsContentPage.getRootView();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    public List<BaseContentPage>getPageList(){
        return mPageList;
    }
}
