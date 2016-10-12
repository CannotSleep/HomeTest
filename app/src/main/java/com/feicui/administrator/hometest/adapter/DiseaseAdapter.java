package com.feicui.administrator.hometest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.entity.MyIness;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/3.
 */
public class DiseaseAdapter extends BaseAdapter {

    //上下文
    Context mcontext;

    //数据组
    ArrayList<MyIness> mlist ;

    public DiseaseAdapter(Context mcontext, ArrayList<MyIness> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup group) {
        ViewHolder holder = null;
        if (view == null) {  //如果View为空 新建
            //布局加载器
            LayoutInflater inflater = LayoutInflater.from(mcontext);
            //加载布局
            view = inflater.inflate(R.layout.menu_item, null);
            //实例化holder对象
            holder = new ViewHolder();
            //关联holder中TextView控件对象
            holder.tv = (TextView) view.findViewById(R.id.item_tv);
            //设置Tag
            view.setTag(holder);
        } else {      //如果不为空 得到tag
            holder= (ViewHolder) view.getTag();
        }
        holder.tv.setText(mlist.get(i).getName());
        return view;
    }

    public class ViewHolder{
        public TextView tv;

    }
}
