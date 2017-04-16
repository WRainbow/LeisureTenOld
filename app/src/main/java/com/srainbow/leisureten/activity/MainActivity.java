package com.srainbow.leisureten.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.main_happy_cv_item1:
                intent = new Intent(MainActivity.this, ContentShowActivity.class);
                intent.putExtra("classificationName", mHappyRectIvItem1.getImgText());
                startActivity(intent);
                break;
            case R.id.main_happy_cv_item2:
                intent = new Intent(MainActivity.this, ContentShowActivity.class);
                intent.putExtra("classificationName", mHappyRectIvItem2.getImgText());
                startActivity(intent);
                break;
            case R.id.main_other_cv_item1:
                intent = new Intent(MainActivity.this, DetailClassificationActivity.class);
                intent.putExtra("classificationName", getCodeString(mOtherRectIvItem1.getImgText()));
                startActivity(intent);
                break;
            case R.id.main_other_cv_item2:
                intent = new Intent(MainActivity.this, DetailClassificationActivity.class);
                intent.putExtra("classificationName", getCodeString(mOtherRectIvItem2.getImgText()));
                startActivity(intent);
                break;
            case R.id.main_other_cv_item3:
                intent = new Intent(MainActivity.this, DetailClassificationActivity.class);
                intent.putExtra("classificationName", getCodeString(mOtherRectIvItem3.getImgText()));
                startActivity(intent);
                break;
            case R.id.main_other_cv_item4:
                intent = new Intent(MainActivity.this, DetailClassificationActivity.class);
                intent.putExtra("classificationName", getCodeString(mOtherRectIvItem4.getImgText()));
                startActivity(intent);
                break;
            case R.id.main_other_cv_item5:
                intent = new Intent(MainActivity.this, DetailClassificationActivity.class);
                intent.putExtra("classificationName", getCodeString(mOtherRectIvItem5.getImgText()));
                startActivity(intent);
                break;
            case R.id.main_other_cv_item6:
                intent = new Intent(MainActivity.this, DetailClassificationActivity.class);
                intent.putExtra("classificationName", getCodeString(mOtherRectIvItem6.getImgText()));
                startActivity(intent);
                break;
            default:

        }
    }

    public String getCodeString(String showString){
        switch (showString){
            case "生活":
                return "生活趣味";
            case "娱乐":
                return "娱乐八卦";
            case "写真":
                return "美女写真";
            case "新闻":
                return "社会百态";
            case "明星":
                return "明星写真";
            case "服装":
                return "时尚伊人";
        }
        return null;
    }
}
