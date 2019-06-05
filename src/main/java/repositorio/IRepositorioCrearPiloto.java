package repositorio;

import modelo.Piloto;

public interface IRepositorioCrearPiloto {
    boolean guardar(Piloto pilotoNuevo);

    Piloto findByDNI(String pDNI);
}
