package Dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import modelo.ApoderadosBean;
import modelo.NinosBean;

public class NinosDao {

    PreparedStatement ps;
    ResultSet rs;
    private Conexion conn = new Conexion();

    public NinosDao(Conexion conn) {
        this.conn = conn;
    }

    public List<NinosBean> mostrarNinos(ApoderadosBean apoderado) {
        List<NinosBean> list = new LinkedList<>();

        String sql = "select n.id_nino, n.nombre, n.apellido, n.disponibilidad, n.direcion, n.salida, n.llegada \n"
                + "from\n"
                + "ninos n\n"
                + "inner join apoderados a on a.id_apoderado=n.id_apoderado\n"
                + "where a.id_apoderado=? and n.estado='activo'"
                + "ORDER BY n.id_nino DESC";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, apoderado.getId_apoderado());

            rs = ps.executeQuery();
            while (rs.next()) {
                NinosBean nino = new NinosBean(rs.getInt(1));
                nino.setNombre(rs.getString(2));
                nino.setApellido(rs.getString(3));
                nino.setDisponibilidad(rs.getBoolean(4));
                nino.setDirecion(rs.getString(5));
                if (rs.getTime(6) != null && rs.getTime(7) != null) {
                    nino.setSalida(rs.getTime(6).toLocalTime());
                    nino.setLlegada(rs.getTime(7).toLocalTime());
                } else {
                    nino.setLlegada(LocalTime.of(0, 0));
                    nino.setSalida(LocalTime.of(0, 0));
                }

                list.add(nino);
            }

        } catch (Exception e) {
            System.out.println(ps + "");
        }

        return list;
    }

    public boolean insertarNino(NinosBean nino) {

        String sql = "insert into ninos (id_nino, nombre, apellido, disponibilidad, direcion, estado, id_apoderado)"
                + " values(?, ?, ?, ?, ?, 'activo', ?)";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, nino.getId_nino());
            ps.setString(2, nino.getNombre());
            ps.setString(3, nino.getApellido());
            ps.setBoolean(4, nino.isDisponibilidad());
            ps.setString(5, nino.getDirecion());
            ps.setInt(6, nino.getId_apoderado().getId_apoderado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(ps + "\n " + e);
            return false;
        }
    }

    public boolean actualizarNino(NinosBean nino) {

        String sql = "UPDATE ninos set nombre=?, apellido=?, direcion=?, disponibilidad=? WHERE id_nino=? and estado='activo'";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(5, nino.getId_nino());
            ps.setString(1, nino.getNombre());
            ps.setString(2, nino.getApellido());
            ps.setBoolean(4, nino.isDisponibilidad());
            ps.setString(3, nino.getDirecion());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(ps + "\n " + e);
            return false;
        }
    }
    
    public boolean eliminarNino(NinosBean nino) {

        String sql = "UPDATE ninos set estado='inactivo' WHERE id_nino=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, nino.getId_nino());
            System.out.println(ps);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(ps + "\n " + e);
            return false;
        }
    }
}
