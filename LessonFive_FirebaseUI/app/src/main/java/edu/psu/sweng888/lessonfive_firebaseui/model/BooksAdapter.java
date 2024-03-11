package edu.psu.sweng888.lessonfive_firebaseui.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.psu.sweng888.lessonfive_firebaseui.R;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {

    private List<Book> mBooks;
    public BooksAdapter(List<Book> books) {
        mBooks = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = mBooks.get(position);
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public void setBooks(List<Book> books) {
        mBooks = books;
        notifyDataSetChanged();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mAuthorTextView;
        private TextView mPublisherTextView;
        private TextView mPublicationDateTextView;
        private TextView mIsbnTextView;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleTextView = itemView.findViewById(R.id.title_text_view);
            mAuthorTextView = itemView.findViewById(R.id.author_text_view);
            mPublisherTextView = itemView.findViewById(R.id.publisher_text_view);
            mPublicationDateTextView = itemView.findViewById(R.id.publication_date_text_view);
            mIsbnTextView = itemView.findViewById(R.id.isbn_text_view);
        }

        public void bind(Book book) {
            mTitleTextView.setText("Title: "+ book.getTitle());
            mAuthorTextView.setText("Author: "+book.getAuthor());
            mPublisherTextView.setText("Publisher: "+book.getPublisher());
            mPublicationDateTextView.setText("Year: "+book.getPublication());
            mIsbnTextView.setText("ISBN: "+book.getIsbn().toString());
        }
    }
}

