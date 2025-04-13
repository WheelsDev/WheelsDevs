package Wheels;

import java.util.Date;

public class EmitirBicicletaUI {
    //setar membros das variáveis
    private Bicicleta escolherBicicleta = null;
    private Cliente cliente = null;
    private Pagamento pagamento = null;
    private Alugar alugar = null;
    private int numeroDeDias = 0;

    public void mostrarDetalhesBicicleta(int bicicletaNum){
        //encontrar a bicicleta pelo número dela
        escolherBicicleta = Bicicleta.encontrarBicicletaPeloNumero(bicicletaNum);
        if(escolherBicicleta != null){
            escolherBicicleta.mostrarDetalhes();
        }
    }

    public void calcularCusto(int numDias){
        //seta a variável para que possa ser usada posteriormente
        numeroDeDias = numDias;
        //assim escrevendo a bicicleta para o custo dela
        escolherBicicleta.calcularCusto(numDias);
    }

    public void criarCliente(String nome, String endereco, int telefone){
        //cria um cliente e associa o aluguel com o pagamento
        cliente = new Cliente(nome, endereco, telefone);
        pagamento = new Pagamento(cliente);
        alugar = new Alugar(new Date(), numeroDeDias, escolherBicicleta, cliente);
    }

    public void calcularPagamentoTotal(){
        //pega o total do pagamento pelo pagamento do objeto
        pagamento.calcularPagamentoTotal(alugar);
    }
}
