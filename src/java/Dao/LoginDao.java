package Dao;

import conexion.Conexion;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.ApoderadosBean;
import modelo.UsuarioBean;

public class LoginDao {

    private Conexion conn = new Conexion();

    public LoginDao(Conexion conn) {
        this.conn = conn;
    }

    ResultSet rs;
    PreparedStatement ps;

    public boolean consultarUsuario(UsuarioBean usuario) {
        String sql = "select * from usuarios where usuario=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());

            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

            return false;
        } catch (Exception e) {
            
            return false;
        }
    }

    public boolean consultarCorreo(UsuarioBean correo) {
        String sql = "select * from usuarios where correo=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, correo.getCorreo());
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

            return false;
        } catch (Exception e) {

            return false;
        }
    }
    UsuarioBean rol;

    public UsuarioBean consultarRol_Correo(UsuarioBean correo) {
        String sql = "select rol, usuario from usuarios where correo=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, correo.getCorreo());
            rs = ps.executeQuery();

            while (rs.next()) {
                rol = new UsuarioBean();
                rol.setRol(rs.getBoolean(1));
                rol.setUsuario(rs.getString(2));
            }

            return rol;
        } catch (Exception e) {

            return null;
        }
    }

    public UsuarioBean consultarRol_usuario(UsuarioBean usuario) {
        String sql = "select rol from usuarios where usuario=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            rs = ps.executeQuery();

            while (rs.next()) {
                rol = new UsuarioBean();
                rol.setRol(rs.getBoolean(1));
            }

            return rol;
        } catch (Exception e) {

            return null;
        }
    }

    public static String encriptador(String clave) {
        try {
            // se llama el metodo getInstance() con algoritmo SHA-512 
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // se llama el digest() 
            // para calcular el mensaje asimilando el texto o clave recibido 
            // se retorna como un array de byte 
            byte[] messageDigest = md.digest(clave.getBytes());

            // Convierte el array byte  en representacion signum
            BigInteger no = new BigInteger(1, messageDigest);

            // convierte el mensaje asimilado en hexadecimal 
            String clavehash = no.toString(16);

            // se agrega 0 al inicio para que sea de 32 bits (se complementa la cadena con 0)
            while (clavehash.length() < 32) {
                clavehash = "0" + clavehash;
            }

            // return de la clave hash 
            return clavehash;
        } // para especificar mensajes erroneos en la ejecucion del algoritmo
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean consultarClave_correo(UsuarioBean clave) {
        String sql = "select * from usuarios where correo=? and  clave=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, clave.getCorreo());
            ps.setString(2, encriptador(clave.getClave()));
            
            rs = ps.executeQuery();
            while (rs.next()) {

                return true;
            }
            return false;
        } catch (Exception e) {

            return false;
        }

    }

    public boolean consultarClave_usuario(UsuarioBean clave) {
        String sql = "select * from usuarios where usuario=? and  clave=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, clave.getUsuario());
            ps.setString(2, encriptador(clave.getClave()));
           
            rs = ps.executeQuery();
            while (rs.next()) {

                return true;
            }
            return false;
        } catch (Exception e) {

            return false;
        }

    }

    public boolean agregarUsuario(UsuarioBean usuario) {
        String sql = "insert into usuarios values(?,?,?,?,0)";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, usuario.getId_usuario());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, encriptador(usuario.getClave()));
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
           
            return false;
        }
    }

    public boolean agregarApoderado(ApoderadosBean apoderado) {
        String sql = "insert into apoderados values(?,?,?,?,?,?, null)";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, apoderado.getId_apoderado());
            ps.setString(2, apoderado.getNombre());
            ps.setString(3, apoderado.getApellido());
            ps.setString(4, apoderado.getDui());
            ps.setString(5, apoderado.getTelefono());
            ps.setInt(6, apoderado.getId_usuario().getId_usuario());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
           
            return false;
        }
    }

    public UsuarioBean ultimo() {
        String sql = "select max(id_usuario) from usuarios";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                rol = new UsuarioBean(rs.getInt(1));
            }
        } catch (Exception e) {
          
        }
        return rol;
    }

    public boolean eliminarUsuario(UsuarioBean id) {

        String sql = "delete from usuarios where id:usuario=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id.getId_usuario());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
          
            return false;
        }
    }

}
