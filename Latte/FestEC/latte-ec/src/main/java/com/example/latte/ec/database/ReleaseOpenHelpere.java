package com.example.latte.ec.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

/**
 * Created by moransu on 2018/9/5.
 */

public class ReleaseOpenHelpere extends DaoMaster.OpenHelper{


    public ReleaseOpenHelpere(Context context, String name) {
        super(context, name);
    }

    public ReleaseOpenHelpere(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
