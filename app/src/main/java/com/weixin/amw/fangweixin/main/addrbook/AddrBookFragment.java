package com.weixin.amw.fangweixin.main.addrbook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weixin.amw.fangweixin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddrBookFragment extends Fragment {


    public AddrBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_addr_book, container, false);
    }

}
