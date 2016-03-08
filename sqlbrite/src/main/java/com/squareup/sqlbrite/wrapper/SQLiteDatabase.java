package com.squareup.sqlbrite.wrapper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;

/**
 * Wraps methods from {@link android.database.sqlite.SQLiteDatabase} to allow different
 * implementations.
 */
public interface SQLiteDatabase {

  void beginTransactionWithListener(SQLiteTransactionListener transactionListener);

  void setTransactionSuccessful();

  boolean yieldIfContendedSafely();

  boolean yieldIfContendedSafely(long sleepAfterYieldDelay);

  void endTransaction();

  void beginTransaction();

  Cursor rawQuery(String sql, String[] selectionArgs);

  long insert(String table, String nullColumnHack, ContentValues values);

  long insertWithOnConflict(String table, String nullColumnHack,
      ContentValues initialValues, int conflictAlgorithm);

  int delete(String table, String whereClause, String[] whereArgs);

  int update(String table, ContentValues values, String whereClause, String[] whereArgs);

  int updateWithOnConflict(String table, ContentValues values,
      String whereClause, String[] whereArgs, int conflictAlgorithm);

  void execSQL(String sql) throws SQLException;

  void execSQL(String sql, Object[] bindArgs) throws SQLException;

}
