package com.squareup.sqlbrite.wrapper.sqlcipher;

import com.squareup.sqlbrite.wrapper.SQLiteTransactionListener;

public class SQLiteTransactionListenerWrapper
    implements net.sqlcipher.database.SQLiteTransactionListener {

  private final SQLiteTransactionListener mAndroidListener;

  public SQLiteTransactionListenerWrapper(SQLiteTransactionListener androidListener) {
    mAndroidListener = androidListener;
  }

  @Override
  public void onBegin() {
    mAndroidListener.onBegin();
  }

  @Override
  public void onCommit() {
    mAndroidListener.onCommit();
  }

  @Override
  public void onRollback() {
    mAndroidListener.onRollback();
  }
}
