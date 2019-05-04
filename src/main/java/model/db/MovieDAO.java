package model.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Movie;

public class MovieDAO extends Database implements Dao<Movie> {
    @Override
    public void create(Movie movie) {
        open();
        String query = "INSERT INTO filmes(titulo, data, nota, descricao, estoque) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, movie.getTitulo());
            pst.setDate(2, new java.sql.Date(movie.getData().getTime()));
            pst.setDouble(3, movie.getNota());
            pst.setString(4, movie.getDescricao());
            pst.setDouble(5, movie.getNota());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao criar o filme! " + e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void delete(Movie movie) {
        open();
        String query = "DELETE FROM filmes WHERE id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, movie.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar a filmes " + movie.getId() + ":" + e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void update(Movie movie) {
        open();
        String query = "UPDATE filmes SET titulo = ?, data = ?, nota = ?, descricao = ?, estoque = ? WHERE id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, movie.getTitulo());
            pst.setDate(2, new java.sql.Date(movie.getData().getTime()));
            pst.setDouble(3, movie.getNota());
            pst.setString(4, movie.getDescricao());
            pst.setInt(5, movie.getEstoque());
            pst.setInt(6, movie.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o filme: " + movie.getId() + e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public List<Movie> all() {
        open();
        ArrayList<Movie> produtosList = new ArrayList<>();
        String query = "SELECT * FROM filmes;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                Date data = rs.getDate("data");
                double nota = rs.getDouble("nota");
                String descricao = rs.getString("descricao");
                int estoque = rs.getInt("estoque");
                Movie movie = new Movie(id, titulo, data, nota, descricao, estoque);
                produtosList.add(movie);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar os filmes:" + e.getMessage());
        } finally {
            close();
        }
        return produtosList;
    }

    @Override
    public Movie findById(int id) {
        open();
        Movie movie = null;
        String query = "SELECT * FROM filmes WHERE id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int Id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                Date data = rs.getDate("data");
                double nota = rs.getDouble("nota");
                String descricao = rs.getString("descricao");
                int estoque = rs.getInt("estoque");
                movie = new Movie(Id, titulo, data, nota, descricao, estoque);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao procurar filmes: " + id + e.getMessage());
        } finally {
            close();
        }
        return movie;
    }

    public ArrayList<Movie> findByName(String n) {
        open();
        ArrayList<Movie> lista = new ArrayList<>();
        String query = "SELECT * FROM filmes WHERE descricao ILIKE ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, "%" + n + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                Date data = rs.getDate("data");
                double nota = rs.getDouble("nota");
                String descricao = rs.getString("descricao");
                int estoque = rs.getInt("estoque");
                Movie m = new Movie(Id, titulo, data, nota, descricao, estoque);
                lista.add(m);
            }

        } catch (SQLException e) {
        	System.err.println("Erro ao procurar filmes: " + n + e.getMessage());
        } finally {
            close();
        }
        return lista;
    }
}

