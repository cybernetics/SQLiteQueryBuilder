package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.Select;
import com.alexfu.sqlitequerybuilder.SelectFrom;

import static com.alexfu.sqlitequerybuilder.utils.SQLUtils.wrap;

public class SelectImpl extends QueryBuilder implements Select {

  public SelectImpl() {
    getBuilder().setLength(0);
    getBuilder().append("SELECT * ");
  }

  public SelectImpl(String... fields) {
    getBuilder().setLength(0);
    getBuilder().append("SELECT ");
    for (int i = 0; i < fields.length; i++) {
      getBuilder().append(wrap(fields[i]));
      if (i < fields.length-1) {
        getBuilder().append(",");
      } else {
        getBuilder().append(" ");
      }
    }
  }

  @Override
  public SelectFrom from(String table) {
    return new SelectFromImpl(table);
  }

}
