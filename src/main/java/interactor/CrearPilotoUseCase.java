package interactor;

import excepciones.PilotoExisteException;
import modelo.Piloto;
import repositorio.IRepositorioCrearPiloto;

public class CrearPilotoUseCase {
    private IRepositorioCrearPiloto crearPilotoGateway;

    public CrearPilotoUseCase(IRepositorioCrearPiloto crearPilotoGateway) {
        this.crearPilotoGateway = crearPilotoGateway;
    }

    public boolean crearPiloto(Piloto pilotoNuevo) throws PilotoExisteException {
        if (!existePiloto(pilotoNuevo)) {
            return this.crearPilotoGateway.guardar(pilotoNuevo);
        }
        throw new PilotoExisteException();
    }

    private boolean existePiloto(Piloto pilotoNuevo) {
        return crearPilotoGateway.findByDNI(pilotoNuevo.getDNI())!=null;
    }
}
