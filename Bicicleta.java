package Wheels;

public class Bicicleta {
    //criação da bicicleta
    protected static Bicicleta[] bicicletaLista = new Bicicleta[5];
    //setar membros das variáveis
    protected int deposito = 0;
    protected int taxa = 0;
    protected int numeroBicicleta = 0;

    /*Esse bloco é executado quando a classe é carregada e é setada a loja de Bicicletas
    *Ela arbitralmente tem os atributos: deposito, taxa e numeroBicicleta*/

    static{
        int j = 0;
        for(int i = 10; i < 15; i++){
            Bicicleta b = new Bicicleta(i, i, (j*100));
            bicicletaLista[j] = b;
            j++;
        }
    }

    public Bicicleta(int dep, int tax, int num){
        //setar membros das variáveis
        deposito = dep;
        taxa = tax;
        numeroBicicleta = num;
    }

    public int getDeposito(){
        return deposito;
    }

    public int getTaxa(){
        return taxa;
    }

    public int getNumeroBicicleta(){
        return numeroBicicleta;
    }

    public static Bicicleta encontrarBicicletaPeloNumero(int numeroDaBicicleta){
        int numeroBicicleta = bicicletaLista.length;

        //procura a Bicicleta mapeando pela a lista completa de bicicletas cadastradas
        for(int i = 0; i < numeroBicicleta; i++){
            //se encontrar a Bicicleta pelo número escolhido...
            if(bicicletaLista[i].getNumeroBicicleta() == numeroDaBicicleta){
                //avisa ao usuário que foi encontrada
                System.out.println("Bicicleta com o número '" + numeroDaBicicleta + "' encontrada" + "\n");
                //e retorna a bicicleta para a UI
                return bicicletaLista[i];
            }
        }
        //se não encontrar a Bicicleta, avisa ao usuário que não foi encontrada...
        System.out.println("Bicicleta com o número '" + numeroDaBicicleta + "' não encontrada" + "\n");
        return null;
    }

    public void mostrarDetalhes(){
        //imprime todos os detalhes
        System.out.println("Detalhes para o número da Bicicleta '" + numeroBicicleta + "'");
        System.out.println("Deposito: " + deposito);
        System.out.println("Taxa: " + taxa + "\n");
    }

    public void calcularCusto(int numeroDeDias){
        //mostra o preço calculado
        int custo = deposito + (taxa*numeroDeDias);
        System.out.println("O custo para alugar deve ser: " + custo + "\n");
    }
}
