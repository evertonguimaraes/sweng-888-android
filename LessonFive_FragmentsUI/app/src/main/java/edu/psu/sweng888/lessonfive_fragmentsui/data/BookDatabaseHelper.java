package edu.psu.sweng888.lessonfive_fragmentsui.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BookDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bookstore_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_BOOKS = "books";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_ISBN = "isbn";
    private static final String KEY_PUBLISHER = "publisher";

    public BookDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createMoviesTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2){
            /** Update the database to version 2.
             *  You may need to create new colums or add new tables to the database.
             */
        }
    }

    /** Query to Create the Database*/
    private String createMoviesTable(){
        String QUERY_CREATE_MOVIES_TABLE = "CREATE TABLE " + TABLE_BOOKS + "(" +
                KEY_ID + " INTEGER PRIMARY KEY, "+
                KEY_TITLE + " TEXT," +
                KEY_AUTHOR + " TEXT," +
                KEY_ISBN + " INTEGER," +
                KEY_PUBLISHER + " TEXT" +
                ")";
        return QUERY_CREATE_MOVIES_TABLE;
    }

    /** Other queries */
    public void addBook(Book book){
        /** Get a Writable instance of the database */
        SQLiteDatabase database = this.getWritableDatabase();
        /** Create a ContentValues to persist information on the database */
        ContentValues values = new ContentValues();
        /** Populate the object with the values from the Movie to be added.
         *  There is no need to include the ID because it is autogenerated by the SQLIte*/
        values.put(KEY_TITLE, book.getTitle());
        values.put(KEY_AUTHOR, book.getAuthor());
        values.put(KEY_ISBN, book.getIsbn());
        values.put(KEY_PUBLISHER, book.getPublisher());
        /** Insert the values on the TABLE_MOVIES */
        database.insert(TABLE_BOOKS, null, values);
        /** Close the connection with the database */
        database.close();
    }

    public List<Book> getMoviesByCategory (String category){
        List<Book> movieList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_BOOKS + " WHERE " + KEY_AUTHOR + " = ?";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, new String[]{category});

        if (cursor.moveToFirst()){
            do {
                Book book = new Book(
                        cursor.getString(1), // TITLE
                        cursor.getString(2), // AUTHOR
                        cursor.getString(3), // ISBN
                        cursor.getString(4) // PUBLISHER
                );
                movieList.add(book);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return  movieList;
    }

    public List<Book> getAllRecords(){
        List<Book> bookList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ TABLE_BOOKS;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Book book = new Book(
                        cursor.getString(1), // TITLE
                        cursor.getString(2), // AUTHOR
                        cursor.getString(3), // ISBN
                        cursor.getString(4) // PUBLISHER
                );
                bookList.add(book);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return bookList;
    }

    public boolean isDatabaseEmpty() {
        boolean isEmpty = true;
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM " + TABLE_BOOKS, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getInt(0);
            if (count > 0) {
                isEmpty = false;
            }
            cursor.close();
        }
        return isEmpty;
    }

    public void populateMoviesDatabase(){

        addBook(new Book("Atomic Habits 1", "James Clear", "0735211299", "Avery"));
        addBook(new Book("Android Programming", "Bryan Sills and Brian Gardner", "0137645546", "Addison-Wesley"));
        addBook(new Book("Software Architecture in Practice", "Less Bass and Paul Clements", "0136886094", "Addison-Wesley"));
        addBook(new Book("Rich Dad, Poor Dad", "Robert Kiyosaki", "1612681131", "Plata Publishing"));

    }
}
