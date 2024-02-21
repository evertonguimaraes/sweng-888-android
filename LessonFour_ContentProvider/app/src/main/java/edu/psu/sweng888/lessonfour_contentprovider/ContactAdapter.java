package edu.psu.sweng888.lessonfour_contentprovider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Contact> contactsList;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        mContext = context;
        contactsList = contacts;
    }

    @Override
    public int getCount() {
        return contactsList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.contact_item, parent, false);
        }

        Contact contact = contactsList.get(position);

        TextView mTextViewName = convertView.findViewById(R.id.nameTextView);
        TextView mTextViewPhone = convertView.findViewById(R.id.phoneTextView);

        mTextViewName.setText(contact.getName());
        mTextViewPhone.setText(contact.getPhoneNumber());

        return convertView;
    }
}