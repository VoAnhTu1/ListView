package com.example.listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Addapter extends BaseAdapter  {
    ArrayList<ThongTin > dsThongTin;

    public Addapter(ArrayList<ThongTin> dsThongTin) {
        this.dsThongTin = dsThongTin;
    }

    @Override
    public int getCount() {
        return dsThongTin.size();
    }

    @Override
    public Object getItem(int i) {
        return dsThongTin.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewtemp;
        if(view==null){
            viewtemp=View.inflate(viewGroup.getContext(),R.layout.customlistview , null );
        }
        else{
            viewtemp=view;
        }
        ThongTin tt=dsThongTin.get(i);
        TextView tvten=viewtemp.findViewById(R.id.tvten );
        ImageView img=viewtemp.findViewById(R.id.img);
        tvten.setText(tt.ten );
        String gt=tt.gioitinh ;
        if(gt.equals("Nam") ){
            img.setImageResource(R.drawable.contrai);
        }
        if(gt.equals("Nu")){
            img.setImageResource(R.drawable.congai );
        }
        return viewtemp ;

    }
}
