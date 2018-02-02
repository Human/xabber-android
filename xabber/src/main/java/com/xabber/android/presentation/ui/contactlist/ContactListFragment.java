package com.xabber.android.presentation.ui.contactlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xabber.android.R;
import com.xabber.android.data.entity.AccountJid;
import com.xabber.android.presentation.mvp.contactlist.ContactListPresenter;
import com.xabber.android.presentation.mvp.contactlist.ContactListView;
import com.xabber.android.presentation.ui.contactlist.viewobjects.ChatVO;
import com.xabber.android.ui.adapter.contactlist.ContactListAdapter;
import com.xabber.android.ui.adapter.contactlist.viewobjects.BaseRosterItemVO;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

/**
 * Created by valery.miller on 02.02.18.
 */

public class ContactListFragment extends Fragment implements ContactListView {

    public static final String ACCOUNT_JID = "account_jid";

    private ContactListPresenter presenter = ContactListPresenter.getInstance();

    private FlexibleAdapter<IFlexible> adapter;
    private List<IFlexible> items;

    public static ContactListFragment newInstance(@Nullable AccountJid account) {
        ContactListFragment fragment = new ContactListFragment();
        Bundle args = new Bundle();
        if (account != null)
            args.putSerializable(ACCOUNT_JID, account);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list_new, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        items = new ArrayList<>();
        adapter = new FlexibleAdapter<>(items, null, true);

        //adapter.setStickyHeaders(true);
        //adapter.setDisplayHeadersAtStartUp(true);
        recyclerView.setAdapter(adapter);

        adapter.setSwipeEnabled(true);
        //adapter.expandItemsAtStartUp();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onLoadContactList(this);
    }

    @Override
    public void updateItems(List<IFlexible> items) {
        this.items.clear();
        this.items.addAll(items);
        adapter.updateDataSet(items);
    }

    /**
     * Scroll contact list to specified account.
     *
     * @param account
     */
    public void scrollToAccount(AccountJid account) {
//        long count = adapter.getItemCount();
//        for (int position = 0; position < (int) count; position++) {
//            Object itemAtPosition = adapter.getItem(position);
//            if (itemAtPosition != null && itemAtPosition instanceof AccountVO
//                    && ((AccountVO)itemAtPosition).getAccountJid().equals(account)) {
//                scrollTo(position);
//                break;
//            }
//        }
    }

    /**
     * Scroll to the top of contact list.
     */
    public void scrollTo(int position) {
//        if (linearLayoutManager != null)
//            linearLayoutManager.scrollToPositionWithOffset(position, 0);
    }

    public void showRecent() {
//        if (adapter != null)
//            adapter.onStateChanged(ContactListAdapter.ChatListState.recent);
    }

    public void showSnackbar(final BaseRosterItemVO deletedItem, final int deletedIndex) {
//        if (snackbar != null) snackbar.dismiss();
//        final boolean archived = ((ChatVO) deletedItem).isArchived();
//        snackbar = Snackbar.make(coordinatorLayout, archived ? R.string.chat_was_unarchived
//                : R.string.chat_was_archived, Snackbar.LENGTH_LONG);
//        snackbar.setAction(R.string.undo, new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                // update value
//                setChatArchived((ChatVO) deletedItem, archived);
//
//                // undo is selected, restore the deleted item
//                adapter.restoreItem(deletedItem, deletedIndex);
//            }
//        });
//        snackbar.setActionTextColor(Color.YELLOW);
//        snackbar.show();
    }

    public void setChatArchived(ChatVO chatVO, boolean archived) {
//        AbstractChat chat = MessageManager.getInstance().getChat(chatVO.getAccountJid(), chatVO.getUserJid());
//        if (chat != null) chat.setArchived(archived, true);
    }

    public void closeSnackbar() {
//        if (snackbar != null) snackbar.dismiss();
    }

    public void closeSearch() {
//        ((ContactListActivity)getActivity()).closeSearch();
    }

    public ContactListAdapter.ChatListState getListState() {
//        if (adapter != null) return adapter.getCurrentChatsState();
//        else return ContactListAdapter.ChatListState.recent;
        return ContactListAdapter.ChatListState.recent;
    }
}
