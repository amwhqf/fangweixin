package com.weixin.amw.fangweixin.main.conversation;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weixin.amw.fangweixin.R;

/**
 * Created by amw on 2017/12/24.
 */

public class ConversationViewHolder extends RecyclerView.ViewHolder {
    ImageView re_message_containe_ravatar;
    TextView re_message_unreadmun;
    TextView re_message_group_tag;
    TextView re_message_name;
    TextView re_message_time;
    TextView re_message_msg;

    public ConversationViewHolder(View itemView) {
        super(itemView);
        re_message_containe_ravatar = (ImageView)itemView.findViewById(R.id.re_message_containe_ravatar);
        re_message_unreadmun = (TextView)itemView.findViewById(R.id.re_message_unreadmun);
        re_message_group_tag = (TextView)itemView.findViewById(R.id.re_message_group_tag);
        re_message_name = (TextView)itemView.findViewById(R.id.re_message_name);
        re_message_time = (TextView)itemView.findViewById(R.id.re_message_time);
        re_message_msg = (TextView)itemView.findViewById(R.id.re_message_msg);
    }
}
