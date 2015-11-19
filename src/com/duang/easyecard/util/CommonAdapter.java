package com.duang.easyecard.util;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommonAdapter<T> extends BaseAdapter {

	protected Context mContext;
	protected List<T> mDatas;
	protected LayoutInflater mInflater;
	protected final int mItemLayoutId;
	
	
	public CommonAdapter(Context context, List<T> datas, int itemLayoutId) {
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		this.mDatas = datas;
		this.mItemLayoutId = itemLayoutId;
	}
	public CommonAdapter(Context context, List<T> datas) {
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		this.mDatas = datas;
		this.mItemLayoutId = 0;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {
		// TODO Auto-generated method stub
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		final ViewHolder viewHolder = getViewHolder(position, convertView, parent);
		convert(viewHolder, getItem(position));
		
		return viewHolder.getConvertView();
	}
	
	public abstract void convert(ViewHolder holder, T t);

	private ViewHolder getViewHolder(int position, View convertView,  
            ViewGroup parent)  
    {  
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId,  
                position);  
    }
}
	
	