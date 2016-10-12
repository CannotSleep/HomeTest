package com.feicui.administrator.hometest.db;

import android.provider.BaseColumns;

/**
 * Created by Administrator on 2016/10/3.
 */
public class ThickEntry implements BaseColumns {

    //数据库路径
    public static final String DATABASE_PATH = "/data/data/com.feicui.administrator.hometest/databases";
    //表名
    public static final String TABALE_NAME = "Thick";
    //列名
    public static final String COLUMNS_TYPE_NAME = "name";
    public static final String COLUMNS_PHONE_TYPE_SUBTABLE = "nation";
    //子表列名
    public static final String COLUMNS_CATION="cation";

    public static final String COLUMNS_MAKE="make";

    public static final String COLUMNS_COUNT="count";
    public static final String COLUMNS_PASSWORD="password";

    //创建表格的SQL语句
    public static final String SQL_CREATE_TABLE =
            "create table " + TABALE_NAME + " (" +
                    _ID + " integer primary key," +
                    COLUMNS_TYPE_NAME + " text," +
                    COLUMNS_PHONE_TYPE_SUBTABLE + " text" + ")";
    //删除表格的SQL语句
    public static final String SQL_DELETE_TABLE =
            "drop table if exists " + TABALE_NAME;


    public static final String SUB_USER="user";
    //子表表名
    public static final String SUB_ARM = "armcation";
    public static final String SUB_BLOOD = "bloodcation";
    public static final String SUB_DOWM = "downcation";
    public static final String SUB_FORGET = "forgetcation";
    public static final String SUB_EAR = "earcation";
    public static final String SUB_HIGH="high";
    public static final String SUB_FAT="fat";
    public static final String SUB_BREATH="breath";
    public static final String SUB_HEART="heart";
    public static final String SUB_SUGAR="sugar";

    public static final String THREE_FOOD_A="threefooda";
    public static final String THREE_FOOD_B="threefoodb";
    public static final String THREE_FOOD_C="threefoodc";

    public static final String FOUR_FOOD="fourfood";
    public static final String FOUR_FOOD_B="fourfoodb";
    public static final String FOUR_FOOD_C="fourfoodc";

    public static final String FIVE_FOOD_A="fivefooda";
    public static final String FIVE_FOOD_B="fivefoodb";
    public static final String FIVE_FOOD_C="fivefoodc";

    public static final String NINE_FOOD_A="ninefooda";
    public static final String NINE_FOOD_B="ninefoodb";
    public static final String NINE_FOOD_C="ninefoodc";

    public static final String TEN_FOOD_A="tenfooda";
    public static final String TEN_FOOD_B="tenfoodb";
    public static final String TEN_FOOD_C="tenfoodc";
    public static final String TEN_FOOD_D="tenfoodd";

    public static final String EIGHT_FOOD_A="eightfooda";
    public static final String EIGHT_FOOD_B="eightfoodb";
    public static final String EIGHT_FOOD_C="eightfoodc";
    public static final String EIGHT_FOOD_D="eightfoodd";
    public static final String EIGHT_FOOD_E="eightfoode";

    public static final String SEVEN_FOOD_A="sevenfooda";
    public static final String SEVEN_FOOD_B="sevenfoodb";
    public static final String SEVEN_FOOD_C="sevenfoodc";
    public static final String SEVEN_FOOD_D="sevenfoodd";

    public static final String SIX_FOOD_A="sixfooda";
    public static final String SIX_FOOD_B="sixfoodb";
    public static final String SIX_FOOD_C="sixfoodc";
    public static final String SIX_FOOD_D="sixfoodd";

//    public static final String FIVE_FOOD="fivefood";



}
