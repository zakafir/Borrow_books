/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalog.javabeans;

/**
 *
 * @author zakaria_afir
 */
public class Author {

    private int id_author;
    private String lastName_author, firstName_author;

    public Author(int id_author, String lastName_author, String firstName_author) {
        this.id_author = id_author;
        this.lastName_author = lastName_author;
        this.firstName_author = firstName_author;
    }

    public Author(String lastName_author, String firstName_author) {
        this.lastName_author = lastName_author;
        this.firstName_author = firstName_author;
        this.id_author = 0;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public String getLastName_author() {
        return lastName_author;
    }

    public void setLastName_author(String lastName_author) {
        this.lastName_author = lastName_author;
    }

    public String getFirstName_author() {
        return firstName_author;
    }

    public void setFirstName_author(String firstName_author) {
        this.firstName_author = firstName_author;
    }

}
