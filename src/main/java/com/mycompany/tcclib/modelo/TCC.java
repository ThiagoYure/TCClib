/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.Document;

/**
 *
 * @author ThigoYure
 */
public class TCC {

    private int id;
    private String titulo;
    private String autor;
    private String orientador;
    private String palavrasChave;
    private String resumo;
    private String area;
    private String ano;
    private String url;
    private String conteudo;

    public TCC() {
    }

    public TCC(int id, String titulo, String autor, String orientador, String palavrasChave, String resumo, String area, String ano, String url, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.orientador = orientador;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.area = area;
        this.ano = ano;
        this.url = url;
        this.conteudo = texto;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTexto() {
        return conteudo;
    }

    public void setTexto(String texto) {
        this.conteudo = texto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.titulo);
        hash = 97 * hash + Objects.hashCode(this.autor);
        hash = 97 * hash + Objects.hashCode(this.orientador);
        hash = 97 * hash + Objects.hashCode(this.palavrasChave);
        hash = 97 * hash + Objects.hashCode(this.resumo);
        hash = 97 * hash + Objects.hashCode(this.area);
        hash = 97 * hash + Objects.hashCode(this.ano);
        hash = 97 * hash + Objects.hashCode(this.url);
        hash = 97 * hash + Objects.hashCode(this.conteudo);
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
        final TCC other = (TCC) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.orientador, other.orientador)) {
            return false;
        }
        if (!Objects.equals(this.palavrasChave, other.palavrasChave)) {
            return false;
        }
        if (!Objects.equals(this.resumo, other.resumo)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.conteudo, other.conteudo)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "TCC{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", orientador=" + orientador + ", palavrasChave=" + palavrasChave + ", resumo=" + resumo + ", area=" + area + ", ano=" + ano + ", url=" + url + ", conteudo=" + conteudo + '}';
    }

    

    public Document toDocument() {
        Document doc = new Document().append("id",id).append("titulo", titulo).append("autor", autor).append("orientador", orientador)
                .append("palavrasChave", palavrasChave).append("resumo", resumo).append("ano", ano).append("area", area)
                .append("url", url).append("conteudo", conteudo);

        return doc;
    }

    public TCC fromDocument(Document doc) {
        id = doc.getInteger("id").intValue();
        titulo = doc.getString("titulo");
        autor = doc.getString("autor");
        orientador = doc.getString("orientador");
        palavrasChave = doc.getString("palavrasChave");
        resumo = doc.getString("resumo");
        ano = doc.getString("ano");
        area = doc.getString("area");
        url = doc.getString("url");
        conteudo = doc.getString("conteudo");
        return this;
    }

}
