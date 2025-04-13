package Wheels;

import java.util.Date;

public class AlugarBike {
    //setar membros das variáveis
    private Bicicleta bicicletaEscolhida = null;
    private Cliente cliente = null;
    private Pagamento pagamento = null;
    private Contrato contrato = null;
    private int numeroDias = 0;

    public void exibirDetalhesBicicleta(int bicicletaNum){
        //encontrar a bicicleta pelo número dela
        bicicletaEscolhida = Bicicleta.encontrarBicicletaPeloNumero(bicicletaNum);
        if(bicicletaEscolhida != null){
            bicicletaEscolhida.exibirDetalhes();
        }
    }

    public void calcularCusto(int numDias){
        //seta a variável para que possa ser usada posteriormente
        numeroDias = numDias;
        //assim escrevendo a bicicleta para o custo dela
        bicicletaEscolhida.calcularCusto(numDias);
    }

    public void criarCliente(String nome, String endereco, int telefone){
        //cria um cliente e associa o aluguel com o pagamento
        cliente = new Cliente(nome, endereco, telefone);
        pagamento = new Pagamento(cliente);
        contrato = new Contrato(new Date(), cliente, bicicletaEscolhida, numeroDias);
    }

    public void calcularPagamento(){
        //pega o total do pagamento pelo pagamento do objeto
        pagamento.calcularPagamentoTotal(contrato);
    }
}
