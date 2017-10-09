/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.controller;
import com.mycompany.tcclib.modelo.Usuario;
import com.mycompany.tcclib.modelo.UsuarioDao;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ThigoYure
 */
class CadastroController implements Command {

    public CadastroController() {
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String instituicao = req.getParameter("instituicao");
        String nascimento = req.getParameter("nascimento");
        String caminhoUser = File.separator + req.getServletContext().getRealPath("usuarios") + File.separator + email;
        File pastaUser = new File(caminhoUser);
        if (!pastaUser.exists()) {
            pastaUser.mkdirs();
        }
        System.out.println(email);
        Part path = req.getPart("fotoPerfil");
        String cam = caminhoUser + File.separator + path.getSubmittedFileName();
        path.write(cam);
        //CAMINHO DO DIRETÓRIO PARA O BANCO
        String fotoPerfil = "usuarios/" + email + "/" + path.getSubmittedFileName();
        Usuario novoUser = new Usuario(email, nome, senha, instituicao, nascimento, fotoPerfil);
        UsuarioDao dao = new UsuarioDao();
        if (email.equals("") || nome.equals("") || senha.equals("") || instituicao.equals("") || nascimento.equals("") || nascimento.equals("")) {
            res.sendRedirect("cadastro.jsp?msg='Campos vazios...'");
        } else {
            if (dao.read(email) == null) {
                if (dao.create(novoUser)) {
                    res.sendRedirect("index.jsp");
                } else {
                    res.sendRedirect("cadastro.jsp?msg='Falha ao criar nova conta...Recarregue a página e tente novamente.'");
                }
            } else {
                res.sendRedirect("cadastro.jsp?msg='Já existe um usuario vinculado a este email...'");
            }
        }
    }

}
