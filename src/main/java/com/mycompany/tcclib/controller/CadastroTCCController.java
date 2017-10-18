/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.controller;

import com.mycompany.tcclib.modelo.LeitorPDF;
import com.mycompany.tcclib.modelo.TCC;
import com.mycompany.tcclib.modelo.TCCMongoDao;
import com.mycompany.tcclib.modelo.TCCNeo4jDao;
import com.mycompany.tcclib.modelo.TCCRedisDao;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 *
 * @author Ricarte
 */
public class CadastroTCCController implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String titulo = req.getParameter("titulo");
        String autor = req.getParameter("autor");
        String orientador = req.getParameter("orientador");
        String palavraChave = req.getParameter("palavrasChave");
        String resumo = req.getParameter("resumo");
        String area = req.getParameter("area");
        String ano = req.getParameter("ano");
        String texto = "";
        TCCMongoDao tccMongoDao = new TCCMongoDao();
        int id = tccMongoDao.generatorID()+1;
        
        TCC tcc = new TCC(id, titulo, autor, orientador, palavraChave, resumo, area, ano, "", texto);
        
        
        TCCNeo4jDao tccNeo4jDao = new TCCNeo4jDao();
        TCCRedisDao tccRedisDao = new TCCRedisDao();
        
        String caminhoTcc = File.separator + req.getServletContext().getRealPath("TCCs");
        File pastaTcc = new File(caminhoTcc);
        if (!pastaTcc.exists()) {
            pastaTcc.mkdirs();
        }
        Part path = req.getPart("pdf");
        String cam = caminhoTcc + File.separator + path.getSubmittedFileName();
        path.write(cam);
        
        LeitorPDF leitorPdf = new LeitorPDF(cam);
        
        try {
            texto = leitorPdf.getText();
            tcc.setTexto(texto);
        } catch (SAXException | TikaException ex) {
            Logger.getLogger(CadastroTCCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tcc.setUrl("TCCs/"+path.getSubmittedFileName());
        
        tccRedisDao.insert(tcc);
        if(tccMongoDao.insert(tcc.toDocument())){
            tccNeo4jDao.insertNode(tcc);
            tccNeo4jDao.createRelationship(tcc);
            tccNeo4jDao.sessionClose();
            
            tccRedisDao.delete(tcc);
            req.removeAttribute("dadosTcc");
            res.sendRedirect("inicial.jsp");
        } else {
            req.setAttribute("dadosTcc", tccRedisDao.read());
            res.sendRedirect("cadastroTCC.jsp");
        }
    }
    
}
