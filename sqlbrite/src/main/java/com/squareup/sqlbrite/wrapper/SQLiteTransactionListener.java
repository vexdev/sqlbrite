package com.squareup.sqlbrite.wrapper;

/**
 * Wraps methods from {@link android.database.sqlite.SQLiteTransactionListener} to allow different
 * implementations.
 */
public interface SQLiteTransactionListener {

  void onBegin();

  void onCommit();

  void onRollback();

}
