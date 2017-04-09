package com.srainbow.leisureten.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.srainbow.leisureten.R;
import com.srainbow.leisureten.widget.RectangleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Bind(R.id.main_happy_cv_item1)
    RectangleImageView mHappyRectIvItem1;//默认为趣图
    @Bind(R.id.main_happy_cv_item2)
    RectangleImageView mHappyRectIvItem2;//默认为笑话
    @Bind(R.id.main_other_cv_item1)
    RectangleImageView mOtherRectIvItem1;//默认为动物
    @Bind(R.id.main_other_cv_item2)
    RectangleImageView mOtherRectIvItem2;//默认为美食
    @Bind(R.id.main_other_cv_item3)
    RectangleImageView mOtherRectIvItem3;//默认为婚纱
    @Bind(R.id.main_other_cv_item4)
    RectangleImageView mOtherRectIvItem4;//默认为社会
    @Bind(R.id.main_other_cv_item5)
    RectangleImageView mOtherRectIvItem5;//默认为猎奇
    @Bind(R.id.main_other_cv_item6)
    RectangleImageView mOtherRectIvItem6;//默认为服装
    @Bind(R.id.main_classification_more_tv)
    TextView mTvMoreClassification;//更多分类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
    }

    public void initViews(){
        mHappyRectIvItem1.setOnClickListener(this);
        mHappyRectIvItem2.setOnClickListener(this);
        mOtherRectIvItem1.setOnClickListener(this);
        mOtherRectIvItem2.setOnClickListener(this);
        mOtherRectIvItem3.setOnClickListener(this);
        mOtherRectIvItem4.setOnClickListener(this);
        mOtherRectIvItem5.setOnClickListener(this);
        mOtherRectIvItem6.setOnClickListener(this);
        mTvMoreClassification.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ContentShowActivity.class);
        switch (view.getId()){
            case R.id.main_happy_cv_item1:
                intent.putExtra("classificationName", mHappyRectIvItem1.getImgText());
                startActivity(intent);
                break;
            case R.id.main_happy_cv_item2:
                intent.putExtra("classificationName", mHappyRectIvItem2.getImgText());
                break;
            case R.id.main_other_cv_item1:
                intent.putExtra("classificationName", mOtherRectIvItem1.getImgText());
                startActivity(intent);
                break;
            case R.id.main_other_cv_item2:
                intent.putExtra("classificationName", mOtherRectIvItem2.getImgText());
                startActivity(intent);
                break;
            case R.id.main_other_cv_item3:
                intent.putExtra("classificationName", mOtherRectIvItem3.getImgText());
                startActivity(intent);
                break;
            case R.id.main_other_cv_item4:
                intent.putExtra("classificationName", mOtherRectIvItem4.getImgText());
                startActivity(intent);
                break;
            case R.id.main_other_cv_item5:
                intent.putExtra("classificationName", mOtherRectIvItem5.getImgText());
                startActivity(intent);
                break;
            case R.id.main_other_cv_item6:
                intent.putExtra("classificationName", mOtherRectIvItem6.getImgText());
                startActivity(intent);
                break;
            case R.id.main_classification_more_tv:
                break;
            default:

        }
    }
}
