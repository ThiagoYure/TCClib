/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.controller;

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
public class SairController implements Command {

    public SairController() {
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        HttpSession session = req.getSession();
        session.invalidate();
        res.sendRedirect("index.jsp");
    }
    
}
