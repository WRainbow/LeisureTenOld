package com.srainbow.leisureten.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.srainbow.leisureten.NetRequest.RetrofitThing;
import com.srainbow.leisureten.NetRequest.SubscriberByTag;
import com.srainbow.leisureten.R;
import com.srainbow.leisureten.adapter.PictureRVAdapter;
import com.srainbow.leisureten.custom.Listener.EndlessOnScrollListener;
import com.srainbow.leisureten.custom.interfaces.OnTVInRvClickToDoListener;
import com.srainbow.leisureten.data.APIData.FunnyPicData;
import com.srainbow.leisureten.data.APIData.FunnyPicDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PictureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PictureFragment extends Fragment implements SubscriberByTag.onSubscriberByTagListener, OnTVInRvClickToDoListener{

    private LinearLayoutManager linearLayoutManager;
    private PictureRVAdapter mPictureRVAdapter;
    private List<FunnyPicDetail> funnyPicDetails;

    @Bind(R.id.picfragment_content_rv)
    RecyclerView mRVFunnyPicture;
    @Bind(R.id.picfragment_srefreshl)
    SwipeRefreshLayout mSRefresh;

    public PictureFragment(){}

    public static PictureFragment newInstance() {
        return new PictureFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        ButterKnife.bind(this, view);
        initVars();
        initViews();

        return view;
    }

    public void initVars(){
        funnyPicDetails = new ArrayList<>();
        RetrofitThing.getInstance().onFunnyPicResponse(new SubscriberByTag("init",PictureFragment.this));
    }

    public void initViews(){
        initRecyclerView();
        initSRefresh();
    }

    public void initSRefresh(){
        mSRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimaryDark700));
    }

    public void initRecyclerView(){
        linearLayoutManager = new LinearLayoutManager(getActivity());
        mPictureRVAdapter = new PictureRVAdapter(getActivity(), funnyPicDetails);
        mPictureRVAdapter.setOnItemClickListener(this);
        mRVFunnyPicture.setAdapter(mPictureRVAdapter);
        mRVFunnyPicture.setLayoutManager(linearLayoutManager);
    }

    public void loadMore(){
        RetrofitThing.getInstance().onFunnyPicResponse(new SubscriberByTag("loadMore",PictureFragment.this));
    }

    @Override
    public void onTvItemClick(View v) {
        switch (v.getId()){
            case R.id.footer_loadmore_tv:
                loadMore();
                break;
        }
    }

    @Override
    public void onCompleted(String tag) {
        switch (tag){
            case "init":
                Toast.makeText(getActivity(),"init完成: " + funnyPicDetails.size(),Toast.LENGTH_SHORT).show();
                break;
            case "loadMore":
                Toast.makeText(getActivity(),"loadMore完成: " + funnyPicDetails.size(),Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onError(String tag, Throwable e) {
        Log.e(tag, e.getMessage());

    }

    @Override
    public void onNext(String tag, Object o) {
        switch (tag){
            case "init":
                if(o==null||((FunnyPicData)o).result.isEmpty()){
                    Toast.makeText(getActivity(),"没有数据了",Toast.LENGTH_SHORT).show();
                }else{
                    funnyPicDetails.clear();
                    for(FunnyPicDetail detail : ((FunnyPicData)o).result){
                        funnyPicDetails.add(detail);
                    }
                    mPictureRVAdapter.notifyDataSetChanged();
                }
                break;
            case "loadMore":
                if(o==null||((FunnyPicData)o).result.isEmpty()){
                    Toast.makeText(getActivity(),"没有数据了",Toast.LENGTH_SHORT).show();
                }else{
                    for(FunnyPicDetail detail : ((FunnyPicData)o).result){
                        funnyPicDetails.add(detail);
                    }
                    mPictureRVAdapter.notifyDataSetChanged();
                }
                break;
        }

    }
}
