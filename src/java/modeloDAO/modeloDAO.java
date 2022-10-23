package modeloDAO;

import config.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Persona;

public class modeloDAO implements interfazPersonaDAO {

    @Override
    public List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<>();
        String sql = "select * from persona";
        try {
            PreparedStatement ps = conexion.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Persona p = new Persona();
                p.setIdPersona(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setCorreo(rs.getString(4));
                personas.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return personas;
    }

    @Override
    public Persona getId(int idPersona) {
        String sql = "select * from persona where idPersona =?";
        Persona persona = new Persona();
        try {
            PreparedStatement ps = conexion.Conectar().prepareStatement(sql);
            ps.setInt(1, idPersona);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                persona.setIdPersona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                persona.setCorreo(rs.getString(4));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return persona;
    }

    @Override
    public int add(Persona p) {
        int resultado = 0;
        String sql = "insert into persona(nombre,apellido,correo)values(?,?,?)";
        try {
            PreparedStatement ps = conexion.Conectar().prepareStatement(sql);
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getApellido());
            ps.setString(3,p.getCorreo());
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en la BD al agregar a : " + e);
        }
        return resultado;
    }

    @Override
    public int update(Persona p) {
        int resultado = 0;
        String sql = "update persona set nombre=?,apellido=?,correo=? where idPersona=?";
        try {
            PreparedStatement ps = conexion.Conectar().prepareStatement(sql);
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getApellido());
            ps.setString(3,p.getCorreo());
            ps.setInt(4,p.getIdPersona());
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en la BD al updetear a : " + e);
        }
        return resultado;
    }

    @Override
    public int delete(int id) {
        int resultado = 0;
        String sql = "delete from persona where idPersona =" + id;
        try {
            PreparedStatement ps = conexion.Conectar().prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en la BD al deletear a : " + e);
        }
        return resultado;
    }

}
