package Wheels;

import java.util.Date;

public class AlugarBike {
    //setar membros das variáveis
    private Contrato contrato = null;

    public void exibirDetalhesBicicleta(){
        //encontrar a bicicleta pelo número dela
        contrato.getBicicleta().exibirDetalhes();
    }

    public Contrato realizarAluguel() {
        return contrato;
    }
}
