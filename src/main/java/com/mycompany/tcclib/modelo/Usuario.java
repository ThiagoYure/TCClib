/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.modelo;

import java.util.Objects;

/**
 *
 * @author ThigoYure
 */
public class Usuario {
    private String email;
    private String nome;
    private String senha;
    private String instituicao;
    private String nascimento;
    private String fotoPerfil;

    public Usuario() {
    }

    public Usuario(String email, String nome, String senha, String instituicao, String nascimento, String fotoPerfil) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.instituicao = instituicao;
        this.nascimento = nascimento;
        this.fotoPerfil = fotoPerfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.senha);
        hash = 67 * hash + Objects.hashCode(this.instituicao);
        hash = 67 * hash + Objects.hashCode(this.nascimento);
        hash = 67 * hash + Objects.hashCode(this.fotoPerfil);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.instituicao, other.instituicao)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        return Objects.equals(this.fotoPerfil, other.fotoPerfil);
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", nome=" + nome + ", senha=" + senha + ", instituicao=" + instituicao + ", nascimento=" + nascimento + ", fotoPerfil=" + fotoPerfil + '}';
    }

    
}
