package Dao;

import conexion.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.BarriosBean;
import modelo.ColegiosBean;

public class RecorridosDao {

    PreparedStatement ps;
    ResultSet rs;
    private Conexion conn = new Conexion();

    public RecorridosDao(Conexion conn) {
        this.conn = conn;
    }

    public List<BarriosBean> mostrarBarrios() {
        List<BarriosBean> list = new LinkedList<>();
        String sql = "select * from barrios";
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BarriosBean barrios = new BarriosBean(rs.getInt(1));
                barrios.setNombre(rs.getString(2));
                list.add(barrios);
            }

        } catch (Exception e) {
            System.out.println(ps + "");
        }

        return list;
    }

    public List<ColegiosBean> mostrarColegios() {
        List<ColegiosBean> list = new LinkedList<>();
        String sql = "select * from colegios";
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ColegiosBean colegios = new ColegiosBean(rs.getInt(1));
                colegios.setNombre(rs.getString(2));
                colegios.setDirecion(rs.getString(3));
                colegios.setFoto(rs.getBinaryStream(4));
                list.add(colegios);
            }

        } catch (Exception e) {
            System.out.println(ps + "");
        }

        return list;
    }

    

    public boolean insertarColegio(ColegiosBean colegio) {

        String sql = "Insert into colegios values(?, ?, ?, ?)";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, colegio.getId_colegio());
            ps.setString(2, colegio.getNombre());
            ps.setString(3, colegio.getDirecion());
            ps.setBlob(4, colegio.getFoto());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(ps + "\n " + e);
            return false;
        }
    }

    public boolean actualizarColegioConFoto(ColegiosBean colegio) {

        String sql = "UPDATE colegios set nombre=?, direcion=?, foto=? WHERE id_colegio=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(4, colegio.getId_colegio());
            ps.setString(1, colegio.getNombre());
            ps.setString(2, colegio.getDirecion());
            ps.setBlob(3, colegio.getFoto());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(ps + "\n " + e);
            return false;
        }
    }
    
    public boolean actualizarColegioSinFoto(ColegiosBean colegio) {

        String sql = "UPDATE colegios set nombre=?, direcion=? WHERE id_colegio=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(3, colegio.getId_colegio());
            ps.setString(1, colegio.getNombre());
            ps.setString(2, colegio.getDirecion());
           
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(ps + "\n " + e);
            return false;
        }
    }

    public boolean eliminarColegio(ColegiosBean id) {

        String sql = "DELETE from colegios WHERE id_colegio=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id.getId_colegio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(ps + "\n " + e);
            return false;
        }
    }

    public void listarImg(int id, HttpServletResponse response) {
        String sql = "select * from colegios where id_colegio=" + id;

        //para poder manejar imagenes
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("imagenes/*");
        try {
            outputStream = response.getOutputStream();
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {

                inputStream = rs.getBinaryStream("foto");
            }
            //se inicializa las variables de arriba

            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }

        } catch (Exception e) {
        }
    }

}
