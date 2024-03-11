package edu.psu.sweng888.lessonfive_fragmentsui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.psu.sweng888.lessonfive_fragmentsui.R;
import edu.psu.sweng888.lessonfive_fragmentsui.data.Book;
import edu.psu.sweng888.lessonfive_fragmentsui.adapter.BookAdapter;
import edu.psu.sweng888.lessonfive_fragmentsui.data.BookDatabaseHelper;

public class BooksListFragment extends Fragment {

    private BookAdapter bookAdapter;
    private RecyclerView mRecyclerView;
    private BookDatabaseHelper bookDatabaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /** Inflate the layout for this fragment */
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);
        /** Instantiate the RecyclerView */
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        bookDatabaseHelper = new BookDatabaseHelper(getActivity());
        if(bookDatabaseHelper.isDatabaseEmpty()){
            bookDatabaseHelper.populateMoviesDatabase();
        }

        List<Book> list = bookDatabaseHelper.getAllRecords();

        bookAdapter = new BookAdapter(list);
        mRecyclerView.setAdapter(bookAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        bookDatabaseHelper = new BookDatabaseHelper(context);
    }
}
