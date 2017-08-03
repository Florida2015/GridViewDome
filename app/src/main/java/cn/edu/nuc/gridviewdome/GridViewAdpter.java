package cn.edu.nuc.gridviewdome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flming2015 on 2017/7/4.
 */
public class GridViewAdpter extends BaseAdapter {
    private Context context;
    private List<String> list = new ArrayList<>();
    public GridViewAdpter(){}
    public GridViewAdpter(Context context,List<String> list){
        this.context = context;
        this.list.addAll(list);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = null;
        if (convertView == null){
            ret = LayoutInflater.from(context).inflate(R.layout.item_gridview_layout,parent,false);
        }else {
            ret = convertView;
        }

        ViewHolder holder = (ViewHolder) ret.getTag();
        if (holder == null) {
            holder = new ViewHolder();

            holder.mTextView = (TextView) ret.findViewById(R.id.text_item);
            ret.setTag(holder);
        }

        holder.mTextView.setText(list.get(position));
        return ret;
    }

    public void addAll(List<String> lists){
        list.clear();
        list.addAll(lists);
        notifyDataSetChanged();
    }

    public static class ViewHolder {
        public TextView mTextView;
    }
}
