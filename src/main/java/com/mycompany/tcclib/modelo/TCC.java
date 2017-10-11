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
    private ArrayList<String> palavrasChave;
    private String resumo;
    private String area;
    private int ano;
    private String url;
    private String texto;

    public TCC() {
    }

    public TCC(int id, String titulo, String autor, String orientador, ArrayList<String> palavrasChave, String resumo, String area, int ano, String url, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.orientador = orientador;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.area = area;
        this.ano = ano;
        this.url = url;
        this.texto = texto;
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

    public ArrayList<String> getPalavrasChave() {
        return (ArrayList<String>) palavrasChave;
    }

    public void setPalavrasChave(ArrayList<String> palavrasChave) {
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.titulo);
        hash = 97 * hash + Objects.hashCode(this.autor);
        hash = 97 * hash + Objects.hashCode(this.orientador);
        hash = 97 * hash + Objects.hashCode(this.palavrasChave);
        hash = 97 * hash + Objects.hashCode(this.resumo);
        hash = 97 * hash + Objects.hashCode(this.area);
        hash = 97 * hash + this.ano;
        hash = 97 * hash + Objects.hashCode(this.url);
        hash = 97 * hash + Objects.hashCode(this.texto);
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
        if (this.id != other.id) {
            return false;
        }
        if (this.ano != other.ano) {
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
        if (!Objects.equals(this.resumo, other.resumo)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        if (!Objects.equals(this.palavrasChave, other.palavrasChave)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TCC{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", orientador=" + orientador + ", palavrasChave=" + palavrasChave + ", resumo=" + resumo + ", area=" + area + ", ano=" + ano + ", url=" + url + ", texto=" + texto + '}';
    }

    public Document toDocument() {
        Document doc = new Document().append("titulo", titulo).append("autor", autor).append("orientador", orientador)
                .append("palavrasChave", palavrasChave).append("resumo", resumo).append("ano", ano).append("area", area)
                .append("url", url).append("conteudo", texto);

        return doc;
    }

    public TCC fromDocument(Document doc) {
        titulo = doc.getString("titulo");
        autor = doc.getString("autor");
        orientador = doc.getString("orientador");
        palavrasChave = doc.get("palavrasChave", ArrayList.class);
        resumo = doc.getString("resumo");
        ano = doc.getInteger("ano");
        area = doc.getString("area");
        url = doc.getString("url");
        texto = doc.getString("texto");
        return this;
    }

}
