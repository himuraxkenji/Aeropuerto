package modeloTest;

import excepciones.PilotoIncompletoException;
import modelo.Piloto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PilotoUnitTest {

    @Test
    public void factoryPiloto_TodosLosAtributosOK_instanciaCorrecta() throws PilotoIncompletoException {
        Piloto unPiloto=Piloto.factoryPiloto(1,"Perez","Juan","30123123");
        Assertions.assertNotNull(unPiloto);
    }

    @Test
    public void factoryPiloto_FaltaAlgunAtributo_PilotoIncompletoException(){
        Assertions.assertThrows(PilotoIncompletoException.class, ()-> Piloto.factoryPiloto(null,"Perez",null,"123456") );
    }
}
