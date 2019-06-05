package modelo;

import excepciones.PilotoIncompletoException;

public class Piloto {

    private final Integer idPiloto;
    private final String apellido;
    private final String nombre;
    private final String dni;

    public Piloto(Integer idPiloto, String apellido, String nombre, String dni) {
        this.idPiloto = idPiloto;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
    }

    public static Piloto factoryPiloto(Integer idPiloto, String Apellido, String Nombre, String DNI) throws PilotoIncompletoException {
        if(idPiloto==null || Apellido==null || Nombre==null || DNI==null){
            throw new PilotoIncompletoException();
        }
        else
        {
            return new Piloto(idPiloto,Apellido,Nombre,DNI);
        }
    }

    public String getDNI() {
        return this.dni;
    }
}
