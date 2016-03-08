package com.squareup.sqlbrite.wrapper;

import android.support.annotation.Nullable;

/**
 * Wraps methods from {@link android.database.sqlite.SQLiteOpenHelper} to allow different
 * implementations.
 */
public interface SQLiteOpenHelper {

  SQLiteDatabase getReadableDatabase(@Nullable String password);

  SQLiteDatabase getWritableDatabase(@Nullable String password);

  void close();

}
