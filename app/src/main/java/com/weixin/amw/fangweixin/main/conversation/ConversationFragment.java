package com.weixin.amw.fangweixin.main.conversation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.weixin.amw.fangweixin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConversationFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<String> mData;
    LinearLayoutManager linearLayoutManager;
    ConversationAdapter conversationAdapter;


    public ConversationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_conversation, container, false);
        recyclerView = root.findViewById(R.id.frg_con_rcy);
        linearLayoutManager= new LinearLayoutManager(root.getContext());
        mData = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            mData.add("name"+i);
        }
        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(linearLayoutManager);
        conversationAdapter = new ConversationAdapter(getActivity(),mData);
        recyclerView.setAdapter(conversationAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        conversationAdapter.setOnItemClickLitener(new ConversationAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "进入消息"+position,Toast.LENGTH_SHORT);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getContext(), "删除消息"+position,Toast.LENGTH_SHORT);
                mData.remove(position);
                conversationAdapter.notifyItemRemoved(position);
            }
        });
    }
}
