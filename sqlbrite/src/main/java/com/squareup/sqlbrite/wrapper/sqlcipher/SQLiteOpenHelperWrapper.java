package com.squareup.sqlbrite.wrapper.sqlcipher;

import com.squareup.sqlbrite.wrapper.SQLiteDatabase;
import com.squareup.sqlbrite.wrapper.SQLiteOpenHelper;

import android.support.annotation.Nullable;

public class SQLiteOpenHelperWrapper implements SQLiteOpenHelper {

  private final net.sqlcipher.database.SQLiteOpenHelper mAndroidHelper;

  public SQLiteOpenHelperWrapper(net.sqlcipher.database.SQLiteOpenHelper androidHelper) {
    mAndroidHelper = androidHelper;
  }

  @Override
  public SQLiteDatabase getReadableDatabase(@Nullable String password) {
    if (password == null) {
      throw new IllegalStateException("Trying to access an Encrypted database without password.");
    }
    return new SQLiteDatabaseWrapper(mAndroidHelper.getReadableDatabase(password));
  }

  @Override
  public SQLiteDatabase getWritableDatabase(@Nullable String password) {
    if (password == null) {
      throw new IllegalStateException("Trying to access an Encrypted database without password.");
    }
    return new SQLiteDatabaseWrapper(mAndroidHelper.getWritableDatabase(password));
  }

  @Override
  public void close() {
    mAndroidHelper.close();
  }
}
