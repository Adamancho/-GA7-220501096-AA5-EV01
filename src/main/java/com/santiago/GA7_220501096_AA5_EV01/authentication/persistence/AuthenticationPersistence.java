package com.santiago.GA7_220501096_AA5_EV01.authentication.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationPersistence {
    private String connectionUrl = "jdbc:mysql://localhost:3306/autenticacion?serverTimezone=UTC";
    private String user = "root";
    private String password = "Discord18";


    public void saveNewUser(String password, String user) throws SQLException {
        String sql = "INSERT INTO contrasena (contrasena, usuario) VALUES (?, ?)";

        Connection conn = DriverManager.getConnection(connectionUrl, this.user, this.password);
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, password);
        ps.setString(2, user);


        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Pedido guardado exitosamente.");
        }

    }

    public boolean signIn(String password, String user) throws SQLException {

        Connection conn = DriverManager.getConnection(connectionUrl, this.user, this.password);
         PreparedStatement ps = conn.prepareStatement("SELECT contrasena FROM contrasena WHERE usuario = ?;");
         ps.setString(1, user);
         ResultSet rs = ps.executeQuery();
        String passwordFromDB="";
         while (rs.next()) {
            passwordFromDB = rs.getString("contrasena");
         }
         if(password.equals(passwordFromDB)){
             return true;
         }
        return false;
    }

}
