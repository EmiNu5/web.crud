package modeloDAO;

import java.util.List;
import model.Persona;

public interface interfazPersonaDAO {
     public List<Persona>getPersonas();
     public Persona getId(int idPersona);
     public int add(Persona p);
     public int update(Persona p);
     public int delete(int id);
}
