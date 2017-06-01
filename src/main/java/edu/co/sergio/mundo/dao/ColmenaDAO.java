package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Colmena;
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
public class ColmenaDAO implements IBaseDatos<Colmena> {

    /**
     * Funcion que permite obtener una lista de los departamentos existentes en
     * la base de datos
     *
     * @return List<Departamento> Retorna la lista de Departamentos existentes
     * en la base de datos
     */
    public List<Colmena> findAll() {
        List<Colmena> obras = null;
        String query = "Select panales_con_alimento from Colmena where id_colmena = 1";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String Autor = null;
            double valor = 0;

            while (rs.next()) {
                Colmena registro = new Colmena();
                if (obras == null) {
                    obras = new ArrayList<Colmena>();
                }
                Autor = rs.getString("panales_con_alimento");
                registro.setPaneles_con_alimento(Autor);
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
    public boolean insert(Colmena t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = " insert into Obra (nombreAutor,nombreObra,descripcion,estilo,valor)" + " values (?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getPaneles_con_alimento());
            preparedStmt.setDouble(5, t.getKilos_Miel());
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
    public boolean update(Colmena t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean delete(Colmena t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "delete from Obra where nombreObra = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public List<Colmena> findAll2() {
        List<Colmena> departamentos = null;
        String query = "SELECT Kilos_Miel FROM Recolector";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            double valor = 0;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<Colmena>();
                }

                Colmena registro = new Colmena();
                
                valor = rs.getDouble("Kilos_Miel");
                registro.setKilos_Miel(valor);

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
