package sample;

import java.sql.*;
import java.time.LocalDate;

public class validaciones {
    static Connection conexion;
    DataBase base = DataBase.abrirConexion();
    public String munici(int muni, int depa){

        String municipios = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/honduras",
                    "root", "");
            String sql = "SELECT * FROM municipios where id_departamento = "+depa+" and id_municipios = "+muni+"";

            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            if (resultado.next()){
               municipios = resultado.getString("municipios");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return municipios;
    }

    public String depar(int depa){

        String departamentos = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/honduras",
                    "root", "");

            String sql2 = "SELECT * FROM departamentos WHERE id_departamento = "+depa+"";
            Statement sentencia2 = conexion.createStatement();
            ResultSet resultado2 = sentencia2.executeQuery(sql2);
            if(resultado2.next()){
                departamentos = resultado2.getString("nombre_departamento");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return departamentos;
    }
    public int año(int año){
        int fecha;
        int resul = 0;
        LocalDate actual = LocalDate.now();
        fecha = actual.getYear();
        if(año>fecha){
            resul = 0;
        }else{
            resul = 1;
        }
        return resul;
    }
    public int ultimo(String numero){
        int resul = 0;
        if (numero.length()==5){
            resul = 1;
        }else {
            resul = 0;
        }
        return resul;
    }
}
