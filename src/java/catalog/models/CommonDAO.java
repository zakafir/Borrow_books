/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalog.models;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author zakaria_afir
 */
public abstract class CommonDAO<T> {

    protected Connection connection;

    public CommonDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Méthode de création
     *
     * @param object
     * @return boolean
     */
    public abstract T create(T object);

    /**
     * Méthode pour effacer
     *
     * @param object
     * @return boolean
     */
    public abstract boolean delete(T object);

    /**
     * Méthode de mise à jour
     *
     * @param object
     * @return boolean
     */
    public abstract boolean update(T object);

    /**
     * Récupérer l’objet à partir d’un champs de type entier
     *
     * @param id
     * @return T
     */
    public abstract T findById(int id);

    /**
     * Récupérer l’objet à partir d’une chaîne de caractères
     *
     * @param name
     * @return T
     */
    public abstract T findByName(String name);

    /**
     * Récupérer tous les objets en base de données
     *
     * @return ArrayList<T>
     */
    public abstract ArrayList<T> findAll();

}
