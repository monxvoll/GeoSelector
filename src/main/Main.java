package main;


import database.DatabaseConnection;
import view.gui.MainFrame;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("Conexión exitosa a Access");
        } else {
            System.out.println("Error al conectar con Access.");
        }

        MainFrame mainFrame = new MainFrame();
        mainFrame.showWindow();

    }
}