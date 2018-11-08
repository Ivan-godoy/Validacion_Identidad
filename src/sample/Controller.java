package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class Controller {


    public Button btnValidar;
    public TextField txtIdenidad;
    public Label validacion;
    public Label departamentos;
    public Label municipios;
    public Label muni;
    public Label depa;

    public void validar(ActionEvent actionEvent) throws SQLException {
        validaciones que = new validaciones();
        try{

            String identidad = txtIdenidad.getText();
            if (identidad.length()==13){
                int departamento = Integer.parseInt(identidad.substring(0, 2)); //Metodo que recibe uno o dos parametros el primero el incide.
                int municipio = Integer.parseInt(identidad.substring(2,4));
                int añoValido = Integer.parseInt(identidad.substring(4, 8));
                String numero = identidad.substring(8, 13);



                String mun = null;
                String dep = null;
                int fec = 0;
                int ult = 0;
                mun = que.munici(municipio, departamento);
                dep = que.depar(departamento);
                fec = que.año(añoValido);
                ult = que.ultimo(numero);
                if (dep == null || mun == null || fec == 0 || ult == 0){
                    validacion.setText("Identidad Incorrecta: " + identidad);
                }else{

                    departamentos.setText(dep);
                    municipios.setText(mun);
                    departamentos.setVisible(true);
                    municipios.setVisible(true);
                    depa.setVisible(true);
                    muni.setVisible(true);
                    validacion.setText("Identidad Correcta: " + identidad);
                }
            }else{
                validacion.setText("El numero De identidad No Existe");
                departamentos.setVisible(false);
                municipios.setVisible(false);
                depa.setVisible(false);
                muni.setVisible(false);
            }

        }catch (Exception e){
            System.err.println("Fallo el extracto " + e.getMessage());
        }
        txtIdenidad.clear();
}
}
