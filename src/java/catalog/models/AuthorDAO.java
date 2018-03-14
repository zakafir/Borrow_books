/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalog.models;

import catalog.javabeans.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zakaria_afir
 */
public class AuthorDAO extends CommonDAO<Author> {

    Author author = null;
    ArrayList<Author> listOfAuthors = new ArrayList<>();

    public AuthorDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Author create(Author object) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement(SQLConstant.CREATE_AUTHOR);

            if (object.getFirstName_author().isEmpty()
                    && object.getLastName_author().isEmpty()) {
                return null;
            } else {
                statement.setString(1, object.getLastName_author());
                statement.setString(2, object.getFirstName_author());
                int result = statement.executeUpdate();

            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    @Override
    public boolean delete(Author object) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement(SQLConstant.DELETE_AUTHOR);

            statement.setInt(1, object.getId_author());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean update(Author object) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement(SQLConstant.UPDATE_USER_BY_ID);

            statement.setString(1, object.getLastName_author());
            statement.setString(2, object.getFirstName_author());
            statement.setInt(3, object.getId_author());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    /**
     * Récupérer un Auteur à partir de son id
     *
     * @param id
     * @return author
     */
    @Override
    public Author findById(int id) {
        try {

            //Creation of the PreparedStatement 
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_AUTHORS_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query 
            statement.setInt(1, id);

            //Executing the preparedStatement 
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                //initialize author object 
                author = new Author(result.getInt("author_id"),
                        result.getString("author_lastname"),
                        result.getString("author_firstname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return author;
    }

    @Override
    public Author findByName(String name) {
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement(SQLConstant.SELECT_ALL_AUTHORS_BY_NAME);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                //initialize author object 
                author = new Author(result.getInt("author_id"),
                        result.getString("author_lastname"),
                        result.getString("author_firstname"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return author;
    }

    @Override
    public ArrayList<Author> findAll() {
        try {
            ResultSet result = this.connection
                    .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE)
                    .executeQuery(SQLConstant.SELECT_ALL_AUTHORS);

            if (result.first()) {

                result.first();

                do {
                    //on intialise les objets auteurs 
                    author = new Author(result.getInt("author_id"),
                            result.getString("author_lastname"),
                            result.getString("author_firstname"));

                    listOfAuthors.add(author);

                } while (result.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return listOfAuthors;

    }

}
