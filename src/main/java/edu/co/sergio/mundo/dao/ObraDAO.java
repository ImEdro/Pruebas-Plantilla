package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Obra;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Isabel-Fabian
 * @since 12/08/2015
 * @version 2 Clase que permite la gestion de la tabla Depto en la base de
 * datos.
 *
 * CREATE TABLE Depto( id_depto integer, nom_depto varchar(40), PRIMARY
 * KEY(id_depto) );
 */
public class ObraDAO implements IBaseDatos<Obra> {

    /**
     * Funcion que permite obtener una lista de los departamentos existentes en
     * la base de datos
     *
     * @return List<Departamento> Retorna la lista de Departamentos existentes
     * en la base de datos
     */
    public List<Obra> findAll() {
        List<Obra> obras = null;
        String query = "Select nombreAutor, valor from (select nombreAutor,sum(valor) as valor from (artista natural join obra) group by nombreAutor ) as resultao where valor>10000 ;";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String Autor = null;
            double valor = 0;

            while (rs.next()) {
                Obra registro = new Obra();
                if (obras == null) {
                    obras = new ArrayList<Obra>();
                }
                Autor = rs.getString("nombreAutor");
                registro.setNombreAutor(Autor);
                valor = rs.getDouble("valor");
                registro.setValor(valor);
                obras.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return obras;
    }

    /**
     * Funcion que permite realizar la insercion de un nuevo registro en la
     * tabla Departamento
     *
     * @param Departamento recibe un objeto de tipo Departamento
     * @return boolean retorna true si la operacion de insercion es exitosa.
     */
    public boolean insert(Obra t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = " insert into Obra (nombreAutor,nombreObra,descripcion,estilo,valor)" + " values (?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getNombreAutor());
            preparedStmt.setString(2, t.getNombreObra());
            preparedStmt.setString(3, t.getDescripcion());
            preparedStmt.setString(4, t.getEstilo());
            preparedStmt.setDouble(5, t.getValor());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Funcion que permite realizar la actualizacion de un nuevo registro en la
     * tabla Departamento
     *
     * @param Departamento recibe un objeto de tipo Departamento
     * @return boolean retorna true si la operacion de actualizacion es exitosa.
     */
    public boolean update(Obra t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "update Obra set nom_depto = ? where id_depto = ?";
        PreparedStatement preparedStmt = null;
        /*try {
         preparedStmt = connection.prepareStatement(query);
         preparedStmt.setString(1, t.getNom_departamento());
         preparedStmt.setInt   (2, t.getId_departamento());
         if (preparedStmt.executeUpdate() > 0){
         result=true;
         }
			    
         } catch (SQLException e) {
         e.printStackTrace();
         }*/

        return result;
    }

    /**
     * Funcion que permite realizar la eliminario de registro en la tabla
     * Departamento
     *
     * @param Departamento recibe un objeto de tipo Departamento
     * @return boolean retorna true si la operacion de borrado es exitosa.
     */
    public boolean delete(Obra t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "delete from Obra where nombreObra = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getNombreObra());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public List<Obra> findAll2() {
        List<Obra> departamentos = null;
        String query = "SELECT nombreAutor,nombreObra,descripcion,estilo,valor FROM Obra";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            String autor = null;
            String nombre = null;
            String descripcion = null;
            String estilo = null;
            double valor = 0;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<Obra>();
                }

                Obra registro = new Obra();
                autor = rs.getString("nombreAutor");
                registro.setNombreAutor(autor);

                nombre = rs.getString("nombreObra");
                registro.setNombreObra(nombre);
                
                descripcion = rs.getString("descripcion");
                registro.setDescripcion(descripcion);
                
                estilo = rs.getString("estilo");
                registro.setEstilo(estilo);
                
                valor = rs.getDouble("valor");
                registro.setValor(valor);

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }
}
