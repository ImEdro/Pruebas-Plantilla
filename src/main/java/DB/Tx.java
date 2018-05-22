package DB;

import Modelo.Usuario;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.*;
import java.sql.Date;

public class Tx<T> {

    private PreparedStatement preparedStmt;
    private Connection connection;

    public Tx() {
        DbConnection c = new DbConnection();
        this.connection = c.getConnection();
    }

    public Boolean insert(T p) {
        boolean r = true;
        String query = " insert into " + p.getClass().getSimpleName() + " (";
        Field[] f = p.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < f.length; i++) {
                query += f[i].getName();
                if (i != (f.length - 1)) {
                    query += ",";
                }
            }
            query += ") values (";
            for (int i = 0; i < f.length; i++) {
                String methodName = "get" + f[i].getName();
                Method getNameMethod = p.getClass().getMethod(methodName);
                try {
                    String name = (String) getNameMethod.invoke(p);
                    if (name != null) {
                        query += "'" + name + "'";
                    } else {
                        query += "null";
                    }
                } catch (Exception e) {
                    try {
                        int name = (int) getNameMethod.invoke(p);
                        if (name != -1) {
                            query += "'" + name + "'";
                        } else {
                            query += "null";
                        }
                    } catch (Exception ex) {
                        Date name = (Date) getNameMethod.invoke(p);
                        if (name != null) {
                            query += "'" + name + "'";
                        } else {
                            query += "null";
                        }
                    }
                }
                if (i != (f.length - 1)) {
                    query += ",";
                }
            }
            query += ");";
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(query);
        try {
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("You made it, the insertion is ok!");
            r = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make insertion!");
            e.printStackTrace();
        }
        return r;
    }

    public ArrayList<T> Select(T p) {
        ArrayList<T> res = new ArrayList<T>();
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName() + "";
        try {
            int j = 0;
            for (int i = 0; i < f.length; i++) {
                String methodName = "get" + f[i].getName();
                Method getNameMethod = p.getClass().getMethod(methodName);
                if (getNameMethod.invoke(p) != null) {
                    String name = (String) "" + getNameMethod.invoke(p);
                    if (!name.equals("-1")) {
                        if (j != 0) {
                            query += " and ";
                        } else {
                            query += " where ";
                        }
                        query += f[i].getName() + " = '" + name + "'";
                        j++;
                    }
                }
            }
            System.out.println(query);
            // create the java statement
            Statement st = this.connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset

            while (rs.next()) {
                T f2 = (T) p.getClass().newInstance();
                Field[] f3 = f2.getClass().getDeclaredFields();
                for (int i = 0; i < f.length; i++) {
                    String methodName = "set" + f3[i].getName();
                    Method setNameMethod = null;
                    try {
                        setNameMethod = f2.getClass().getMethod(methodName, String.class);
                        String r = rs.getString(f3[i].getName());
                        setNameMethod.invoke(f2, r);
                    } catch (Exception e) {
                        try {
                            setNameMethod = f2.getClass().getMethod(methodName, int.class);
                            int r = rs.getInt(f3[i].getName());
                            setNameMethod.invoke(f2, r);
                        } catch (Exception ex) {
                            setNameMethod = f2.getClass().getMethod(methodName, Date.class);
                            Date r = rs.getDate(f3[i].getName());
                            setNameMethod.invoke(f2, r);
                        }
                    }
                }
                res.add((T) f2);
            }
            st.close();
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    
    // p tiene los valores a actualizar 
    // p2 tiene el valor a buscar 
    public Boolean update(T p, T p2) {
        boolean r = true;
        String query = " update " + p.getClass().getSimpleName() + " set ";
        Field[] f = p.getClass().getDeclaredFields();
        Field[] f2 = p2.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < f.length; i++) {
                String methodName = "get" + f[i].getName();
                Method getNameMethod = p.getClass().getMethod(methodName);
                try {
                    String name = (String) getNameMethod.invoke(p);
                    query += f[i].getName() + " = '" + name + "'";
                } catch (Exception e) {
                    try {
                        int name = (int) getNameMethod.invoke(p);
                        query += f[i].getName() + " = '" + name + "'";
                    } catch (Exception ex) {
                        Date name = (Date) getNameMethod.invoke(p);
                        query += f[i].getName() + " = '" + name + "'";
                    }
                }

                if (i != (f.length - 1)) {
                    query += ",";
                }
            }
            query += " where ";
            int j = 0;
            for (int i = 0; i < f2.length; i++) {
                String methodName = "get" + f2[i].getName();
                Method getNameMethod = p2.getClass().getMethod(methodName);
                if (getNameMethod.invoke(p2) != null) {
                    try {
                        String name = (String) getNameMethod.invoke(p2);
                        if (j != 0) {
                            query += " and " + f[i].getName() + " = '" + name + "'";
                        } else {
                            query += f[i].getName() + " = '" + name + "'";
                        }
                    } catch (Exception e) {
                        try {
                            int name = (int) getNameMethod.invoke(p2);
                            if (name != -1) {
                                if (j != 0) {
                                    query += " and " + f[i].getName() + " = '" + name + "'";
                                } else {
                                    query += f[i].getName() + " = '" + name + "'";
                                }
                            }
                        } catch (Exception ex) {
                            Date name = (Date) getNameMethod.invoke(p2);
                            if (j != 0) {
                                query += " and " + f[i].getName() + " = '" + name + "'";
                            } else {
                                query += f[i].getName() + " = '" + name + "'";
                            }
                        }
                    }
                    j++;
                }
            }
            query += ";";
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(query);
        try {
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("You made it, the update is ok!");
            r = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make insertion!");
            e.printStackTrace();
        }
        return r;
    }

    public Boolean delete(T p) {
        boolean r = true;
        String query = " delete from " + p.getClass().getSimpleName() + " where ";
        Field[] f = p.getClass().getDeclaredFields();
        try {
            int j = 0;
            for (int i = 0; i < f.length; i++) {
                String methodName = "get" + f[i].getName();
                Method getNameMethod = p.getClass().getMethod(methodName);
                if (getNameMethod.invoke(p) != null) {
                    try {
                        String name = (String) getNameMethod.invoke(p);
                        if (j != 0) {
                            query += " and " + f[i].getName() + " = '" + name + "'";
                        } else {
                            query += f[i].getName() + " = '" + name + "'";
                        }
                    } catch (Exception e) {
                        try {
                            int name = (int) getNameMethod.invoke(p);
                            if (name != -1) {
                                if (j != 0) {
                                    query += " and " + f[i].getName() + " = '" + name + "'";
                                } else {
                                    query += f[i].getName() + " = '" + name + "'";
                                }
                            }
                        } catch (Exception ex) {
                            Date name = (Date) getNameMethod.invoke(p);
                            if (j != 0) {
                                query += " and " + f[i].getName() + " = '" + name + "'";
                            } else {
                                query += f[i].getName() + " = '" + name + "'";
                            }
                        }
                    }
                    j++;
                }
            }
            query += ";";
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(query);
        try {
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("You made it, the delete is ok!");
            r = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make insertion!");
            e.printStackTrace();
        }
        return r;
    }

//    public ArrayList<T> Select2null(T p) {
//        ArrayList<T> res = new ArrayList<T>();
//        Field[] f = p.getClass().getDeclaredFields();
//        String query = "select * from " + p.getClass().getSimpleName() + "";
//        try {
//            int j = 0;
//            for (int i = 0; i < f.length; i++) {
//                String methodName = "get" + f[i].getName();
//                Method getNameMethod = p.getClass().getMethod(methodName);
//                if (getNameMethod.invoke(p) == null) {
//
//                    if (j != 0) {
//                        query += " and ";
//                    } else {
//                        query += " where ";
//                    }
//
//                    String name = (String) getNameMethod.invoke(p);
//                    query += f[i].getName() + " = null ";
//                    j++;
//                }
//            }
//            System.out.println(query);
//            // create the java statement
//            Statement st = this.connection.createStatement();
//            // execute the query, and get a java resultset
//            ResultSet rs = st.executeQuery(query);
//            // iterate through the java resultset
//
//            while (rs.next()) {
//                T f2 = (T) p.getClass().newInstance();
//                Field[] f3 = f2.getClass().getDeclaredFields();
//                for (int i = 0; i < f.length; i++) {
//                    String methodName = "set" + f3[i].getName();
//                    Method setNameMethod = f2.getClass().getMethod(methodName, String.class);
//                    String r = rs.getString("" + f3[i].getName());
//                    setNameMethod.invoke(f2, r);
//                }
//                res.add((T) f2);
//            }
//            st.close();
//        } catch (SQLException ex) {
//            // TODO Auto-generated catch block
//            System.out.println("Failed to make update!");
//            ex.printStackTrace();
//        } catch (IllegalArgumentException ex) {
//            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoSuchMethodException ex) {
//            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SecurityException ex) {
//            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvocationTargetException ex) {
//            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(Tx.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return res;
//    }
}
