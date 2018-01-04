package com.weixin.amw.fangweixin.main.conversation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.weixin.amw.fangweixin.R;

import java.util.List;

/**
 * Created by amw on 2017/12/24.
 */

public class ConversationAdapter extends RecyclerView.Adapter<ConversationViewHolder> {
    List<String> mItemMessages;
    Context context;

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public ConversationAdapter(Context context, List<String> msglist) {
        this.context = context;
        this.mItemMessages = msglist;
    }

    @Override
    public ConversationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConversationViewHolder conversationViewHolder = new ConversationViewHolder(
                LayoutInflater.from(context)
                .inflate(R.layout.item_conversation_single,parent,false));
        return conversationViewHolder;
    }

    @Override
    public void onBindViewHolder(final ConversationViewHolder holder, final int position) {
        holder.re_message_name.setText(mItemMessages.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();
                mOnItemClickLitener.onItemClick(v,pos);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int pos = holder.getLayoutPosition();
                mOnItemClickLitener.onItemLongClick(v,pos);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemMessages.size();
    }

}
