/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.controller;

import com.mycompany.tcclib.modelo.TCC;
import com.mycompany.tcclib.modelo.TCCMongoDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricarte
 */
public class BuscarTCCController implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String resultPesquisa = req.getParameter("dadosPesquisa");
        TCCMongoDao tccMongoDao = new TCCMongoDao();
        List<TCC> result = tccMongoDao.BuscaPorTexto(resultPesquisa);
        req.setAttribute("result", result);
        res.sendRedirect("buscaTcc.jsp");
        
    }
    
}
