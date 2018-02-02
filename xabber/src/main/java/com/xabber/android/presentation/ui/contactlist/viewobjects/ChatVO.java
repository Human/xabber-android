package com.xabber.android.presentation.ui.contactlist.viewobjects;

import android.graphics.drawable.Drawable;

import com.xabber.android.R;
import com.xabber.android.data.entity.AccountJid;
import com.xabber.android.data.entity.UserJid;
import com.xabber.android.data.message.NotificationState;

import java.util.Date;

/**
 * Created by valery.miller on 02.02.18.
 */

public class ChatVO extends ContactVO {

    public ChatVO(String name, String status, int statusId, int statusLevel, Drawable avatar,
                  int mucIndicatorLevel, UserJid userJid, AccountJid accountJid, int unreadCount,
                  boolean mute, NotificationState.NotificationMode notificationMode, String messageText,
                  boolean isOutgoing, Date time, int messageStatus, String messageOwner, boolean archived) {

        super(name, status, statusId, statusLevel, avatar, mucIndicatorLevel, userJid, accountJid,
                unreadCount, mute, notificationMode, messageText, isOutgoing, time, messageStatus,
                messageOwner, archived);
    }

    @Override
    public boolean isSwipeable() {
        return true;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_chat_in_contact_list_new;
    }
}
