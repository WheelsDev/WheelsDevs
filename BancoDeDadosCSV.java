package Wheels;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BancoDeDadosCSV {
    private Path caminhoDiretorioBicicleta = Paths.get("BancoDeDados","Bicicletas.csv");
    private Path caminhoDiretorioCliente = Paths.get("BancoDeDados","Clientes.csv");
    private Path caminhoDiretorioContrato = Paths.get("BancoDeDados","Contratos.csv");
    private Path caminhoDiretorioPagamento = Paths.get("BancoDeDados","Pagamentos.csv");

    private ArrayList<Bicicleta> listaBicicletas = new ArrayList<>();
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Contrato> listaContratos = new ArrayList<>();
    private ArrayList<Pagamento> listaPagamentos = new ArrayList<>();

    public void salvarBicicleta(Bicicleta bicicleta) {
        try {
            Path caminhoDiretorio = Paths.get("BancoDeDados","Bicicletas.csv");
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorio, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorio);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("Numero Bicicleta,Nome,Marca,Modelo,Deposito,Tipo,Diaria Taxa Aluguel,Disponibilidade".getBytes());
            }
            escreverArquivo.write(bicicleta.toString().getBytes());
            System.out.println("Bicicleta salva no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
        }

    }

    private boolean verificarArquivoBicicleta() {
        System.out.println("\nVerificando Arquivo...");
        try {
            InputStream inputStream = Files.newInputStream(caminhoDiretorioBicicleta);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    private void lerArquivoBicicleta() {
        try {
            String linha;
            InputStream inputStream = Files.newInputStream(caminhoDiretorioBicicleta);
            InputStreamReader leitorArquivo = new InputStreamReader(inputStream);
            BufferedReader lerArquivo = new BufferedReader(leitorArquivo);
            linha = lerArquivo.readLine(); // Pular 1° linha
            linha = lerArquivo.readLine();
            String[] bicicleta;
            Bicicleta bicicletaDoBanco;
            while (linha != null) {
                bicicleta = linha.split(",");
                bicicletaDoBanco = new Bicicleta(Integer.parseInt(bicicleta[0]),bicicleta[1],bicicleta[2],bicicleta[3],Double.parseDouble(bicicleta[4]),bicicleta[5],Double.parseDouble(bicicleta[6]),Boolean.parseBoolean(bicicleta[7]));
                listaBicicletas.add(bicicletaDoBanco);
                linha = lerArquivo.readLine();
            }
        } catch (Exception ex) {
        }
    }
    public void imprimirRelatorioCompletoBicicletas() {
        if (verificarArquivoBicicleta()) {
            lerArquivoBicicleta();
            listaBicicletas.forEach(b -> {
                System.out.println("Bicicleta de id: "+b.getNumeroBicicleta()+" e nome: " + b.getNome());
            });
        } else {
            System.out.println("Arquivo não encontrado. :(");
        }
    }
    private int buscarBicicleta() {
        Scanner leitor =  new Scanner(System.in);
        System.out.print("\nProcurar Bicicleta pelo Identificador: ");
        int identificadorBicicleta = leitor.nextInt();
        return identificadorBicicleta;
    }
    public void buscarRelatorioBicicleta() {
        HashMap<Integer,Bicicleta> listaIdBicicletas = new HashMap<>();
        if (verificarArquivoBicicleta()) {
            lerArquivoBicicleta();
            int idBicicleta = buscarBicicleta();
            listaBicicletas.forEach(b -> {
                listaIdBicicletas.put(b.getNumeroBicicleta(),b);
            });
            Bicicleta bicicletaProcurada = listaIdBicicletas.get(idBicicleta);
            if (bicicletaProcurada != null) {
                System.out.println("Bicicleta encontrada, carregando...");
                bicicletaProcurada.exibirDetalhes();
            } else {
                System.out.println("Bicicleta não encontrada no sistema. :(");
            }
        } else {
            System.out.println("Arquivo não encontrado. :(");
        }
    }

    public void salvarCliente(Cliente cliente) {
        try {
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorioCliente, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorioCliente);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("ClienteID,Nome,Endereco,Telefone,Email".getBytes());
            }
            escreverArquivo.write(cliente.toString().getBytes());
            System.out.println("Cliente salvo no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
        }

    }
    private boolean verificarArquivoCliente() {
        System.out.println("\nVerificando Arquivo...");
        try {
            InputStream inputStream = Files.newInputStream(caminhoDiretorioCliente);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    private void lerArquivoCliente() {
        try {
            String linha;
            InputStream inputStream = Files.newInputStream(caminhoDiretorioCliente);
            InputStreamReader leitorArquivo = new InputStreamReader(inputStream);
            BufferedReader lerArquivo = new BufferedReader(leitorArquivo);
            linha = lerArquivo.readLine(); // Pular 1° linha
            linha = lerArquivo.readLine();
            String[] cliente;
            Cliente clienteDoBanco;
            while (linha != null) {
                cliente = linha.split(",");
                clienteDoBanco = new Cliente(Integer.parseInt(cliente[0]),cliente[1],cliente[2],cliente[3],cliente[4]);
                listaClientes.add(clienteDoBanco);
                linha = lerArquivo.readLine();
            }
        } catch (Exception ex) {
        }
    }
    public void imprimirRelatorioCompletoClientes() {
        if (verificarArquivoCliente()) {
            lerArquivoCliente();
            listaClientes.forEach(c -> {
                System.out.println("Cliente de id: "+c.getClienteID()+" e nome: " + c.getNome());
            });
        } else {
            System.out.println("Arquivo não encontrado. :(");
        }
    }
    private int buscarCliente() {
        Scanner leitor =  new Scanner(System.in);
        System.out.print("\nProcurar Cliente pelo Identificador: ");
        int identificadorCliente = leitor.nextInt();
        return identificadorCliente;
    }
    public void buscarRelatorioCliente() {
        HashMap<Integer,Cliente> listaIdClientes = new HashMap<>();
        if (verificarArquivoCliente()) {
            lerArquivoCliente();
            int idCliente = buscarCliente();
            listaClientes.forEach(c -> {
                listaIdClientes.put(c.getClienteID(),c);
            });
            Cliente clienteProcurado = listaIdClientes.get(idCliente);
            if (clienteProcurado != null) {
                System.out.println("Cliente encontrado, carregando...");
                clienteProcurado.exibirDetalhes();
            } else {
                System.out.println("Cliente não encontrado no sistema. :(");
            }
        } else {
            System.out.println("Arquivo não encontrado. :(");
        }
    }

    public void salvarContrato(Contrato contrato) {
        try {
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorioContrato, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorioContrato);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("Contrato ID,Cliente,Bicicleta,Data Inicial,Numero Dias,Data Retorno,Status Do Contrato".getBytes());
            }
            escreverArquivo.write(contrato.toString().getBytes());
            System.out.println("Contrato salvo no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
        }

    }
    private boolean verificarArquivoContrato() {
        System.out.println("\nVerificando Arquivo...");
        try {
            InputStream inputStream = Files.newInputStream(caminhoDiretorioContrato);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    private void lerArquivoContrato() {
        try {
            String linha;
            InputStream inputStream = Files.newInputStream(caminhoDiretorioContrato);
            InputStreamReader leitorArquivo = new InputStreamReader(inputStream);
            BufferedReader lerArquivo = new BufferedReader(leitorArquivo);
            linha = lerArquivo.readLine(); // Pular 1° linha
            linha = lerArquivo.readLine();
            String[] contrato;
            Contrato contratoDoBanco;
            while (linha != null) {
                contrato = linha.split(",");
                contratoDoBanco = new Contrato(Integer.parseInt(contrato[0]),contrato[1],contrato[2],contrato[3],Integer.parseInt(contrato[4]),contrato[5],contrato[6]);
                listaContratos.add(contratoDoBanco);
                linha = lerArquivo.readLine();
            }
        } catch (Exception ex) {
        }
    }
    public void imprimirRelatorioCompletoContratos() {
        if (verificarArquivoContrato()) {
            lerArquivoContrato();
            listaContratos.forEach(c -> {
                System.out.println("Contrato de id: "+c.getContratoID());
            });
        } else {
            System.out.println("Arquivo não encontrado. :(");
        }
    }
    private int buscarContrato() {
        Scanner leitor =  new Scanner(System.in);
        System.out.print("\nProcurar Contrato pelo Identificador: ");
        int identificadorContrato = leitor.nextInt();
        return identificadorContrato;
    }
    public void buscarRelatorioContrato() {
        HashMap<Integer,Contrato> listaIdContratos = new HashMap<>();
        if (verificarArquivoContrato()) {
            lerArquivoContrato();
            int idContrato = buscarContrato();
            listaContratos.forEach(c -> {
                listaIdContratos.put(c.getContratoID(),c);
            });
            Contrato contratoProcurado = listaIdContratos.get(idContrato);
            if (contratoProcurado != null) {
                System.out.println("Contrato encontrado, carregando...");
                contratoProcurado.exibirDetalhes();
            } else {
                System.out.println("Contrato não encontrado no sistema. :(");
            }
        } else {
            System.out.println("Arquivo não encontrado. :(");
        }
    }

    public void salvarPagamento(Pagamento pagamento) {
        try {
            Path caminhoDiretorio = Paths.get("BancoDeDados","Pagamentos.csv");
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorio, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorio);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("Pagamento ID,Nome Cliente,Data Pagamento,Valor Total,Valor Pago,Pagamento Em Falta".getBytes());
            }
            escreverArquivo.write(pagamento.toString().getBytes());
            System.out.println("Pagamento salvo no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
        }

    }
}