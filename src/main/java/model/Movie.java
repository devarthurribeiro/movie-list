package model;

import java.util.Date;
import java.util.List;
import model.db.MovieDAO;

public class Movie {

    private int id;
    private String titulo;
    private Date data;
    private double nota;
    private String descricao;
    private int estoque;

    private static MovieDAO dao = new MovieDAO();

    public Movie() {
    }

    public Movie(String titulo, Date data, double nota, String descricao, int estoque) {
        this.titulo = titulo;
        this.data = data;
        this.nota = nota;
        this.descricao = descricao;
        this.estoque = estoque;
    }
    
    public Movie(int id, String titulo, Date data, double nota, String descricao, int estoque) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.nota = nota;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public static List<Movie> all() {
        return dao.all();
    }

    public void save() {
        if (id != 0) {
            dao.update(this);
        } else {
            dao.create(this);
        }
    }

    public void delete() {
        dao.delete(this);
    }

    public static Movie findById(int id) {
        return dao.findById(id);
    }

    public static List<Movie> findByName(String n) {
        return dao.findByName(n);
    }
}
