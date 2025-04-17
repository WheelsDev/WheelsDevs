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

    public void salvarCliente(Cliente cliente) {
        try {
            Path caminhoDiretorio = Paths.get("BancoDeDados","Clientes.csv");
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorio, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorio);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("ClienteID,Nome,Endereco,Telefone,Email".getBytes());
            }
            escreverArquivo.write(cliente.toString().getBytes());
            System.out.println("Cliente salvo no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
        }

    }
    public void salvarContrato(Contrato contrato) {
        try {
            Path caminhoDiretorio = Paths.get("BancoDeDados","Contratos.csv");
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorio, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorio);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("Contrato ID,Cliente,Bicicleta,Data Inicial,Numero Dias,Data Retorno,Status Do Contrato".getBytes());
            }
            escreverArquivo.write(contrato.toString().getBytes());
            System.out.println("Contrato salvo no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
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