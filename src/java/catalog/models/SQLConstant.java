/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalog.models;

/**
 *
 * @author zakaria_afir
 */
public class SQLConstant {
    /** 
    * Author queries   
    */ 
    protected static final String SELECT_ALL_AUTHORS = "SELECT * FROM author";
    protected static final String SELECT_ALL_AUTHORS_BY_ID = "SELECT * FROM "
            + "author WHERE author_id = ?";
    protected static final String SELECT_ALL_AUTHORS_BY_NAME = "SELECT * FROM "
            + "author WHERE author_firstname = ? OR author_lastname = ?";
    
//    protected static final String UPDATE_USER_BY_ID = "UPDATE author SET author_firstname = ? AND "
//            + "author_lastname = ? WHERE author_id = ?";
//    
    /** 
    * Book queries   
    */ 
    protected static final String SELECT_ALL_BOOKS = "SELECT * FROM book"; 
    protected static final String INSERT_BOOK = "INSERT INTO BOOK (isbn," 
             + "book_title,book_description,book_price,publication_date," 
             + "catalog_id,editor_id) VALUES(DEFAULT," 
             + " '')"; 
     
   /** 
    * Members queries   
    */ 
    protected static final String INSERT_MEMBER = "INSERT INTO MEMBER " 
            + "(member_id,member_lastname, member_firstname,member_email," 
            + "member_address,member_password) VALUES(DEFAULT, ?,?,?,?,'')"; 
     
    /** 
     * Connection queries 
     */     
    protected static final String SELECT_MEMBER = "select * from MEMBER where " 
            + "member_email=? and member_password=?";
}
