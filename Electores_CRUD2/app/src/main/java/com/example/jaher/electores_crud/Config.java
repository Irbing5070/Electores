package com.example.jaher.electores_crud;

public class Config {
    //Agregando las direcciones de nuestros scripts de el CRUD

  /*  public static final String URL_ADD="http://192.168.1.71:8090/Android/CRUD/addEmp.php";
    public static final String URL_GET_ALL = "http://192.168.1.71:8090/Android/CRUD/getAllEmp.php";
    public static final String URL_GET_EMP = "http://192.168.1.71:8090/Android/CRUD/getEmp.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.1.71:8090/Android/CRUD/updateEmp.php";
    public static final String URL_DELETE_EMP = "http://192.168.1.71:8090/Android/CRUD/deleteEmp.php?id=";
*/

    public static final String URL_ADD="https://electoresapp.000webhostapp.com/addEmp.php";
    public static final String URL_GET_ALL = "https://electoresapp.000webhostapp.com/getAllEmp.php";
    public static final String URL_GET_EMP = "https://electoresapp.000webhostapp.com/getEmp.php?id=";
    public static final String URL_UPDATE_EMP = "https://electoresapp.000webhostapp.com/updateEmp.php";
    public static final String URL_DELETE_EMP = "https://electoresapp.000webhostapp.com/deleteEmp.php?id=";

    public static final String URL_LOGIN_USER = "https://electoresapp.000webhostapp.com/loginUser.php?user=";

    //Definiendo las constants para ser usadas en los requerimientos a los scripts de PHP

    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAME = "name";
    public static final String KEY_EMP_EDAD = "edad";
    public static final String KEY_EMP_CURP = "curp";
    public static final String KEY_EMP_FECHA_VOTACION = "fecha_votacion";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_EDAD = "edad";
    public static final String TAG_CURP = "curp";
    public static final String TAG_FECHA = "fecha_votacion";
    public static final String TAG_USER = "user";
    public static final String TAG_NAME_U = "name";
    public static final String TAG_PDW = "pwd";
    public static final String TAG_ROL = "rol";

    public static final String EMP_ID = "elector_id";

}

