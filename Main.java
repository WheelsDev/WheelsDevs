package Wheels;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /* esse pequeno programa irá rodar de acordo com os métodos em "AlugarBike"
         * chamando cada um em turno, igual um usuário com um Front end deveria fazer. */
        //primerio, instância-se a Classe AlugarBike
        AlugarBike alugarBike = new AlugarBike();
        Cliente novoCliente = new Cliente("Richard","Rua oduvaldu Cozzi","21998228014");
        Bicicleta novaBicicleta = new Bicicleta("Bicicleta Anos 2000",15,5,"Volkswagem","Grande","Esportiva");
        Contrato novoContrato = new Contrato(novoCliente,novaBicicleta,LocalDate.now(),10);
        Pagamento novoPagamento = new Pagamento(novoContrato);
    }

}
