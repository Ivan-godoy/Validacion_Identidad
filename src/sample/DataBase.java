package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static DataBase instancia = null;
    private Connection conexion;
    private DataBase(){

    }
    public static DataBase abrirConexion(){
        if(instancia == null){
            instancia = new DataBase();
            try{
                instancia.conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/honduras", "root",
                        "");
            } catch (SQLException e){
                System.err.println("La Conexion Fallo " + e.getMessage());
            }
        }
        return  instancia;
    }
    public Connection getConexion(){
        return conexion;
    }
}
