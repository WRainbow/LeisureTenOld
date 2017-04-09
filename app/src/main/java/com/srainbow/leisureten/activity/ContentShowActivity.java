package com.srainbow.leisureten.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.srainbow.leisureten.R;
import com.srainbow.leisureten.fragment.PictureFragment;

public class ContentShowActivity extends BaseActivity {

    private static String classification = "";
    private FragmentTransaction mTransaction;
    private PictureFragment mPictureFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_show);
        initParameter();
        initViews();
    }

    public void initParameter(){
        classification = getIntent().getStringExtra("classificationName");
    }

    public void initViews(){
        mPictureFragment = PictureFragment.newInstance();
        mTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_showfragment_fl, mPictureFragment);
        mTransaction.commit();
    }
}
