/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.ApoderadosBean;
import modelo.UsuarioBean;

/**
 *
 * @author juan.ruizusam
 */
public class ApoderadosDao {

    Conexion conn = new Conexion();

    public ApoderadosDao(Conexion conn) {
        this.conn = conn;
    }

    ResultSet rs;
    PreparedStatement ps;

    public ApoderadosBean mostrarApoderadoById_usuario(UsuarioBean usuario) {
        ApoderadosBean apoderado = new ApoderadosBean();
        String sql = "select * from apoderados where id_usuario=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, usuario.getId_usuario());
            rs = ps.executeQuery();

            while (rs.next()) {
                apoderado = new ApoderadosBean(rs.getInt(1));
                apoderado.setNombre(rs.getString(2));
                apoderado.setApellido(rs.getString(3));
                apoderado.setDui(rs.getString(4));
                apoderado.setTelefono(rs.getString(5));
            }

            return apoderado;
        } catch (Exception e) {

            return null;
        }
    }

}
