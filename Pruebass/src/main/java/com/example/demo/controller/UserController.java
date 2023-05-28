package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    // Mostramos el formulario de registro
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    // Mostramos el formulario de login
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Procesamos el formulario de registro
    @PostMapping("/register")
    public String processRegistrationForm(@RequestParam("name") String name,
                                           @RequestParam("email") String email,
                                           @RequestParam("password") String password) {

        try {
            // Conectamos a la base de datos
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb", "root", "");

            // Preparamos la consulta SQL
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");

            // Establecemos los valores de los parámetros
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            // Ejecutamos la consulta
            statement.executeUpdate();

            // Cerramos la conexión
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/login";
    }

    // Procesamos el formulario de login
    @PostMapping("/login")
    public String processLoginForm(@RequestParam("email") String email,
                                    @RequestParam("password") String password,
                                    Model model) {

        try {
            // Conectamos a la base de datos
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb", "root", "");

            // Preparamos la consulta SQL
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");

            // Establecemos los valores de los parámetros
            statement.setString(1, email);
            statement.setString(2, password);

            // Ejecutamos la consulta
            ResultSet resultSet = statement.executeQuery();

            // Verificamos si el usuario existe
            if (resultSet.next()) {
                // Si existe, redirigimos a la página de bienvenida
                return "redirect:/login";

}}}
