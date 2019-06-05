package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.PilotoExisteException;
import excepciones.PilotoIncompletoException;
import interactor.CrearPilotoUseCase;
import modelo.Piloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioCrearPiloto;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class crearPilotoUnitTest {

    @Mock
    IRepositorioCrearPiloto crearPilotoGateway;


    @Test
    public void crearPiloto_PilotoNoExiste_GuardaCorrectamente() throws PilotoIncompletoException, PilotoExisteException {
        Piloto pilotoNuevo=Piloto.factoryPiloto(1,"Perez", "Juan","12345678");
        when(crearPilotoGateway.guardar(pilotoNuevo)).thenReturn(true);
        CrearPilotoUseCase crearPilotoUseCase = new CrearPilotoUseCase(crearPilotoGateway);
        boolean resultado = crearPilotoUseCase.crearPiloto(pilotoNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearPiloto_PilotoExiste_PilotoExisteException() throws PilotoIncompletoException {
        Piloto pilotoNuevo = Piloto.factoryPiloto(1,"Perez", "Juan","12345678");
        when(crearPilotoGateway.findByDNI("12345678")).thenReturn(Piloto.factoryPiloto(2,"Lopez", "Carlos","12345678"));
        CrearPilotoUseCase crearPilotoUseCase = new CrearPilotoUseCase(crearPilotoGateway);
        Assertions.assertThrows(PilotoExisteException.class, () -> crearPilotoUseCase.crearPiloto(pilotoNuevo));

    }
}
