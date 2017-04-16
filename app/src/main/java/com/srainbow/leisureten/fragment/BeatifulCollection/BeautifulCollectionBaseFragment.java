package com.srainbow.leisureten.fragment.BeatifulCollection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srainbow.leisureten.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BeautifulCollectionBaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeautifulCollectionBaseFragment extends Fragment {

    public BeautifulCollectionBaseFragment() {
        
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BeautifulCollectionBaseFragment.
     */
    public static BeautifulCollectionBaseFragment newInstance() {
        BeautifulCollectionBaseFragment fragment = new BeautifulCollectionBaseFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_beatiful_collection_base, container, false);
    }

}
