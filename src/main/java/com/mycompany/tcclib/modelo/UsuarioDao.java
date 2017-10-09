/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.modelo;

import com.mycompany.tcclib.factory.ConFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThigoYure
 */
public class UsuarioDao {

    public UsuarioDao() {

    }
    
    public boolean update(Usuario novo,String emailAntigo) {
        try {
            int retorno;
            try (Connection con = ConFactory.getConnection()) {
                PreparedStatement st = con.prepareStatement("UPDATE usuario set nome=?,email=?,senha=?,instituicao=?,datanascimento=?,fotoPerfil=?"
                        + " Where email = ?");
                st.setString(1, novo.getNome());
                st.setString(2, novo.getEmail());
                st.setString(3, novo.getSenha());
                st.setString(4, novo.getInstituicao());
                st.setString(5, novo.getNascimento());
                st.setString(6, novo.getFotoPerfil());
                st.setString(7, emailAntigo);
                retorno = st.executeUpdate();
                st.close();
            }
            if (retorno > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean create(Usuario novo) {
        try {
            int retorno;
            try (Connection con = ConFactory.getConnection()) {
                PreparedStatement st = con.prepareStatement("INSERT INTO usuario (nome,email,senha,instituicao,datanascimento,fotoPerfil)"
                        + " VALUES(?,?,?,?,?,?)");
                st.setString(1, novo.getNome());
                st.setString(2, novo.getEmail());
                st.setString(3, novo.getSenha());
                st.setString(4, novo.getInstituicao());
                st.setString(5, novo.getNascimento());
                st.setString(6, novo.getFotoPerfil());
                retorno = st.executeUpdate();
                st.close();
            }
            if (retorno > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Usuario read(String email) {

        try {
            try (Connection con = ConFactory.getConnection()) {
                PreparedStatement st = con.prepareStatement("SELECT * FROM usuario WHERE email=?");
                st.setString(1, email);
                ResultSet r = st.executeQuery();
                if (r.next()) {
                    Usuario user = new Usuario();
                    user.setNome(r.getString("nome"));
                    user.setEmail(r.getString("email"));
                    user.setFotoPerfil(r.getString("fotoperfil"));
                    user.setSenha(r.getString("senha"));
                    user.setInstituicao(r.getString("instituicao"));
                    user.setNascimento(r.getString("datanascimento"));
                    st.close();
                    con.close();
                    return user;
                }
                st.close();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
