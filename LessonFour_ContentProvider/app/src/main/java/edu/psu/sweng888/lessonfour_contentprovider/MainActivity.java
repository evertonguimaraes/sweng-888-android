package edu.psu.sweng888.lessonfour_contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ContactAdapter mAdapter;

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.contacts_list);

        /** Check for permission to access contacts */
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            /** Permission is not granted, request it */
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    PERMISSIONS_REQUEST_READ_CONTACTS);
            contacts = getContacts();
        } else {
            /** Permission is already granted, proceed with app logic */
            contacts = getContacts();
        }

        mAdapter = new ContactAdapter(this, getContacts());
        mListView.setAdapter(mAdapter);

    }

    @SuppressLint("Range")
    private ArrayList<Contact> getContacts() {
        /** Create an ArrayList of Contact objects */
        ArrayList<Contact> contacts = new ArrayList<>();
        /** Create a ContentResolver object. It will be responsible for querying
         * the contacts database (native app) **/
        ContentResolver contentResolver = getContentResolver();
        /** The ContentResolver will query the ContactsContract based on a given URI
         *  to retrieve all contacts. The null values indicate that all colums and contacts
         *  should be retrieved.
         */
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                /** We use the Cursor object to iterarate over the results. We will obtain information
                 *  regarding the ContactID and Name.
                 */
                String id = cursor.getString(cursor.getColumnIndex(
                        ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));
                String phoneNumber = "";

                Cursor phoneCursor = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        new String[]{id}, null);
                /** We will wuery the ContactsContract.CommonDataKinds.Phone.ID to match the Phone number */
                if (phoneCursor.moveToFirst()) {

                    phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
                /** Once it finishes iterating over the results, we close the cursor, and add the name
                 *  and pgone number to a new instance of Contact. The new Contact object is added to
                 *  the contacts ArrayList.
                 */
                phoneCursor.close();
                contacts.add(new Contact(name, phoneNumber));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return contacts;
    }
}