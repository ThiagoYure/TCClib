/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.controller;

import com.mycompany.tcclib.modelo.Usuario;
import com.mycompany.tcclib.modelo.UsuarioDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ThigoYure
 */
public class LoginController implements Command {

    public LoginController() {
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        UsuarioDao dao;
        dao = new UsuarioDao();
        Usuario user = dao.read(req.getParameter("email"));
        if (user==null) {
            res.sendRedirect("index.jsp?error='Não há nenhum usuario cadastrado com esse email e senha.");
        } else {
            if(user.getEmail().equals(email)&&user.getSenha().equals(senha)){
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                System.out.println(session.getAttribute("user"));
                res.sendRedirect("inicial.jsp");
            }else{
                res.sendRedirect("index.jsp?error='Dados incorretos...'");
            }
        }
    }
    
}
