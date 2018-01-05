package com.example.patrickdz96.aqp_tour;

import android.provider.BaseColumns;

/**
 * Created by TErikaT on 19/11/2017.
 */

public class Estructura_BasedeDatos {
    Estructura_BasedeDatos()
    {

    }

    /* Inner class that defines the table contents */
    //public static class FeedEntry implements BaseColumns {
    public static final String TABLE_NAME = "usuario";
    public static final String NAME_COLUMN1 = "nombres";
    public static final String NAME_COLUMN2 = "apellidos";
    public static final String NAME_COLUMN3 = "username";
    public static final String NAME_COLUMN4 = "pasword";
    public static final String id = "id";
    //}

    public static final String FTABLE_NAME = "fotografias";
    public static final String FOTO_COLUMN1 = "usuario";
    public static final String FOTO_COLUMN2 = "comentario";
    public static final String FOTO_id = "id";

    public static final String LTABLE_NAME = "lugarturisticoes";
    public static final String LUGAR_COLUMN1 = "informacion";
    public static final String LUGAR_COLUMN2 = "contacto";
    public static final String LUGAR_COLUMN3 = "direccion";
    public static final String LUGAR_id = "id";

    public static final String LTABLE_NAMEI = "lugarturisticous";
    public static final String LUGARI_COLUMN1 = "informacion";
    public static final String LUGARI_COLUMN2 = "contacto";
    public static final String LUGARI_COLUMN3 = "direccion";
    public static final String LUGARI_id = "id";

    ///creacion de la tabla
    private static  final String TEXT_TYPE="TEXT";
    private static  final String COMMA_SEP=",";
    public static final String SQL_CREATE_ENTRIES =
            " CREATE TABLE " + Estructura_BasedeDatos.TABLE_NAME + " (" +
                    Estructura_BasedeDatos.id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Estructura_BasedeDatos.NAME_COLUMN1 + " TEXT," +
                    Estructura_BasedeDatos.NAME_COLUMN2 + " TEXT,"+
                    Estructura_BasedeDatos.NAME_COLUMN3 + " TEXT,"+
                    Estructura_BasedeDatos.NAME_COLUMN4 + " TEXT )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Estructura_BasedeDatos.TABLE_NAME;


    public static final String SQL_CREATE_ENTRIESFOTO =
            " CREATE TABLE " + Estructura_BasedeDatos.FTABLE_NAME + " (" +
                    Estructura_BasedeDatos.id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Estructura_BasedeDatos.FOTO_COLUMN1 + " TEXT," +
                    Estructura_BasedeDatos.FOTO_COLUMN2 + " TEXT,)";

    public static final String SQL_DELETE_ENTRIESFOTO =
            "DROP TABLE IF EXISTS " + Estructura_BasedeDatos.FTABLE_NAME;

    public static final String SQL_CREATE_ENTRIESLUGAR =
            " CREATE TABLE " + Estructura_BasedeDatos.LTABLE_NAME + " (" +
                    Estructura_BasedeDatos.id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Estructura_BasedeDatos.LUGAR_COLUMN1 + " TEXT," +
                    Estructura_BasedeDatos.LUGAR_COLUMN2 + " TEXT,"+
                    Estructura_BasedeDatos.LUGAR_COLUMN3 + " TEXT,)";
    public static final String SQL_DELETE_ENTRIESLUGAR =
            "DROP TABLE IF EXISTS " + Estructura_BasedeDatos.FTABLE_NAME;

    public static final String SQL_CREATE_ENTRIESLUGARI =
            " CREATE TABLE " + Estructura_BasedeDatos.LTABLE_NAME + " (" +
                    Estructura_BasedeDatos.id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Estructura_BasedeDatos.LUGARI_COLUMN1 + " TEXT," +
                    Estructura_BasedeDatos.LUGARI_COLUMN2 + " TEXT,"+
                    Estructura_BasedeDatos.LUGARI_COLUMN3 + " TEXT,)";
    public static final String SQL_DELETE_ENTRIESLUGARI =
            "DROP TABLE IF EXISTS " + Estructura_BasedeDatos.FTABLE_NAME;
}
