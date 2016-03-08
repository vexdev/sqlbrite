package com.squareup.sqlbrite.wrapper.android;

import com.squareup.sqlbrite.wrapper.SQLiteDatabase;
import com.squareup.sqlbrite.wrapper.SQLiteOpenHelper;

import android.support.annotation.Nullable;

public class SQLiteOpenHelperWrapper implements SQLiteOpenHelper {

  private final android.database.sqlite.SQLiteOpenHelper mAndroidHelper;

  public SQLiteOpenHelperWrapper(android.database.sqlite.SQLiteOpenHelper androidHelper) {
    mAndroidHelper = androidHelper;
  }

  @Override
  public SQLiteDatabase getReadableDatabase(@Nullable String password) {
    return new SQLiteDatabaseWrapper(mAndroidHelper.getReadableDatabase());
  }

  @Override
  public SQLiteDatabase getWritableDatabase(@Nullable String password) {
    return new SQLiteDatabaseWrapper(mAndroidHelper.getWritableDatabase());
  }

  @Override
  public void close() {
    mAndroidHelper.close();
  }
}
