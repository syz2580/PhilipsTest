package com.showeasy.philiptest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.showeasy.philiptest.R;
import com.showeasy.philiptest.philips.IHue;
import com.showeasy.philiptest.philips.internal.HueManager;
import com.showeasy.philiptest.storage.entity.Bulb;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 邵一哲_Native on 2016/11/6.
 */

public class LightControlFragment extends Fragment {

    XRecyclerView mXrvLights;

    private RecyclerView.Adapter mAdapter;

    Map<String, Bulb> mBulbMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_light_control,container, false);
        mXrvLights = (XRecyclerView) mView.findViewById(R.id.xrv_lights);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXrvLights.setLayoutManager(layoutManager);
        mBulbMap = HueManager.getInstance().getAllBulbs();
        mAdapter = new LCAdapter();
        mXrvLights.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        return mView;
    }



    class LCAdapter extends RecyclerView.Adapter<LCAdapter.LCViewHolder>
    {
        @Override
        public LCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.item_light_control,parent,false);
            LCViewHolder viewHolder = new LCViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(LCViewHolder holder, int position) {
            holder.viewSelectColor.setBackgroundColor(mBulbMap.get(""+(position+1)).getColor());
            holder.tvName.setText(mBulbMap.get(""+(1+position)).getName());
            if (mBulbMap.get(""+(1+position)).isTurnOn()) {
                holder.imgSwitcher.setImageResource(R.mipmap.switch_on);
            } else {
                holder.imgSwitcher.setImageResource(R.mipmap.switch_off);
            }
        }

        @Override
        public int getItemCount() {
            return mBulbMap==null?0:mBulbMap.size();
        }

        class LCViewHolder extends RecyclerView.ViewHolder{
            View viewSelectColor;
            TextView tvName;
            ImageView imgSwitcher;
            ImageView imgBrightness;
            public LCViewHolder(View view) {
                super(view);
                viewSelectColor = view.findViewById(R.id.select_color);
                tvName = (TextView) view.findViewById(R.id.tv_light_name);
                imgSwitcher = (ImageView) view.findViewById(R.id.img_switcher);
                imgBrightness = (ImageView) view.findViewById(R.id.img_brightness);
            }
        }
    };

}
