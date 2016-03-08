package com.squareup.sqlbrite.wrapper.sqlcipher;

import com.squareup.sqlbrite.wrapper.SQLiteDatabase;
import com.squareup.sqlbrite.wrapper.SQLiteTransactionListener;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;

public class SQLiteDatabaseWrapper implements SQLiteDatabase {

  private final net.sqlcipher.database.SQLiteDatabase mAndroidDatabase;

  public SQLiteDatabaseWrapper(net.sqlcipher.database.SQLiteDatabase androidDatabase) {
    mAndroidDatabase = androidDatabase;
  }

  @Override
  public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
    mAndroidDatabase
        .beginTransactionWithListener(new SQLiteTransactionListenerWrapper(transactionListener));
  }

  @Override
  public void setTransactionSuccessful() {
    mAndroidDatabase.setTransactionSuccessful();
  }

  @Override
  public boolean yieldIfContendedSafely() {
    return mAndroidDatabase.yieldIfContendedSafely();
  }

  @Override
  public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
    return mAndroidDatabase.yieldIfContendedSafely(sleepAfterYieldDelay);
  }

  @Override
  public void endTransaction() {
    mAndroidDatabase.endTransaction();
  }

  @Override
  public void beginTransaction() {
    mAndroidDatabase.beginTransaction();
  }

  @Override
  public Cursor rawQuery(String sql, String[] selectionArgs) {
    return mAndroidDatabase.rawQuery(sql, selectionArgs);
  }

  @Override
  public long insert(String table, String nullColumnHack, ContentValues values) {
    return mAndroidDatabase.insert(table, nullColumnHack, values);
  }

  @Override
  public long insertWithOnConflict(String table, String nullColumnHack, ContentValues initialValues,
      int conflictAlgorithm) {
    return mAndroidDatabase
        .insertWithOnConflict(table, nullColumnHack, initialValues, conflictAlgorithm);
  }

  @Override
  public int delete(String table, String whereClause, String[] whereArgs) {
    return mAndroidDatabase.delete(table, whereClause, whereArgs);
  }

  @Override
  public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
    return mAndroidDatabase.update(table, values, whereClause, whereArgs);
  }

  @Override
  public int updateWithOnConflict(String table, ContentValues values, String whereClause,
      String[] whereArgs,
      int conflictAlgorithm) {
    return mAndroidDatabase
        .updateWithOnConflict(table, values, whereClause, whereArgs, conflictAlgorithm);
  }

  @Override
  public void execSQL(String sql) throws SQLException {
    mAndroidDatabase.execSQL(sql);
  }

  @Override
  public void execSQL(String sql, Object[] bindArgs) throws SQLException {
    mAndroidDatabase.execSQL(sql, bindArgs);
  }
}
