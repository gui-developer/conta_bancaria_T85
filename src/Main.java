import Model.Conta;
import Controller.ContaController;
import Model.ContaCorrente;
import Model.ContaPoupanca;

import java.util.Scanner;

public class Main {

    private static final Scanner i = new Scanner (System.in);
    private static final ContaController contaController = new ContaController ();

    static void main () {
        boolean rodando = true;

        Conta c1 = new ContaPoupanca (1, 1234, "Poupança", "Lucas", 10000, 18);
        Conta c2 = new ContaCorrente (2, 4321, "Corrente", "Luana", 15000, 10000);

        contaController.cadastrar (c1);
        contaController.cadastrar (c2);

        while (rodando){
            System.out.println ("*************************");
            System.out.println ("     BANCO OPERAÇÕES     ");
            System.out.println ("*************************");
            System.out.println ("1 - Criar conta");
            System.out.println ("2 - Listar todas as Contas");
            System.out.println ("3 - Buscar conta por numero");
            System.out.println ("4 - Atualizar dados da conta");
            System.out.println ("5 - Apagar conta");
            System.out.println ("6 - sacar");
            System.out.println ("7 - Depositar ");
            System.out.println ("8 - Transferir valores entre contas ");
            System.out.println ("9 - sair ");
            System.out.println ("*************************************");
            System.out.println ("Entre com a opção desejada: ");
            int opcao = i.nextInt ();


            switch (opcao) {
                //Criar conta
                case 1:
                    System.out.println ("ID da conta: ");
                    int idCadastro = i.nextInt ();
                    System.out.println ("N° Agencia: ");
                    int numeroAgenciaCadastro = i.nextInt ();
                    i.nextLine (); //Limpeza do buffer

                    System.out.println ("Nome do Titular: ");
                    String titularCadastro = i.nextLine ();

                    System.out.println ("Saldo inicial: ");
                    float saldoInicialCadastro = i.nextFloat ();

                    System.out.println ("[1]- conta corrente ou [2] - conta poupança");
                    int tipoCadastro = i.nextInt ();

                    Conta novaContaCadastro = fabricarConta (tipoCadastro, idCadastro,numeroAgenciaCadastro,titularCadastro,saldoInicialCadastro);

                    if (novaContaCadastro != null){
                        contaController.cadastrar (novaContaCadastro);
                        System.out.println ("Conta cadastrada com sucesso!");
                    }else{
                        System.out.println ("Erro ao cadastrar a conta");
                    }
                    break;

                //Listar Todas as contas
                case 2:
                    contaController.listarTodas ();
                    break;

                //Executa uma busca por número da conta
                case 3:
                    System.out.println ("Digite o numero da conta que deseja procurar: ");
                    int numeroProcura = i.nextInt ();
                    contaController.procurarPorNumero (numeroProcura);
                    break;

                //Atualizar dados da conta
                case 4:
                    System.out.println ("Digite qual conta deseja atualizar ");
                    int numeroConta = i.nextInt ();
                    i.nextLine (); //Limpeza do buffer

                    Conta conta = contaController.buscarNaCollection (numeroConta);
                    float guardaSaldo = conta.getSaldo ();
                    System.out.println ("Escolha uma opção de atualização:         ");
                    System.out.println ("[1] - Atualizar todos os dados da conta   ");
                    System.out.println ("[2] - Atualizar um dado em especifico     ");
                    int opcaoAtualizar = i.nextInt ();
                    i.nextLine (); //Limpeza do buffer

                    //Atualizar um dado específico
                    switch (opcaoAtualizar) {
                        case 1:
                            // Dados antigos
                            System.out.println ("Dados DA CONTA");
                            System.out.println ("Titular: " + conta.getTitular ());
                            System.out.println ("Numero da conta: " + conta.getNumero ());
                            System.out.println ("Agencia: " + conta.getAgencia ());
                            System.out.println ("Tipo da conta: " + conta.getTipo ());
                            System.out.println ("Saldo: " + conta.getSaldo ());

                            // Dados novos
                            System.out.println ("ID da conta ");
                            int novoNumeroConta = i.nextInt ();
                            i.nextLine (); //Limpeza do buffer
                            System.out.println ("Novo N° da Agencia: ");
                            int novoNumeroAgencia = i.nextInt ();
                            i.nextLine (); //Limpeza do buffer
                            System.out.println ("Nome do Titular: ");
                            String nomeTitular = i.nextLine ();
                            i.nextLine (); //Limpeza do buffer

                            System.out.println ("Tipo da conta: [1] - Conta Corrente [2] - Conta Poupança ");
                            int escolhaTipoConta = i.nextInt ();
                            i.nextLine (); //Limpeza do buffer

                            Conta novaConta = fabricarConta (escolhaTipoConta, novoNumeroConta, novoNumeroAgencia, nomeTitular, guardaSaldo);
                            if (novaConta != null){
                                contaController.atualizarDadosDaConta (novaConta);
                                System.out.println ("Conta atualizada com sucesso!");
                                break;
                            }else {
                                System.out.println ("Erro ao atualizar a conta");
                                break;
                            }
                        case 2:
                            System.out.println ("Digite qual dado você deseja atualizar");
                            System.out.println ("[1] - Id da conta: ");
                            System.out.println ("[2] - N° da agencia");
                            System.out.println ("[3] - Tipo da conta");
                            System.out.println ("[4] - Titular");
                            int opcaoAtualizarDado = i.nextInt ();
                            i.nextLine (); //Limpeza do buffer

                            switch (opcaoAtualizarDado) {
                                case 1: //Atualiza o ID da conta
                                    System.out.println ("Digite Id da conta: ");
                                    int novoIdConta = i.nextInt ();
                                    conta.setNumero (novoIdConta);
                                    System.out.println ("Conta atualizada com sucesso!");
                                    break;

                                case 2: //Atualiza o N° da agência da conta
                                    System.out.println ("Digite o N° da agencia: ");
                                    int novaAgencia = i.nextInt ();
                                    conta.setAgencia (novaAgencia);
                                    System.out.println ("Conta atualizada com sucesso!");
                                    break;

                                case 3:
                                    // Dados da conta antiga
                                    String salvaTitular = conta.getTitular ();
                                    int salvaIdConta = conta.getNumero ();
                                    int salvaNumeroAgencia = conta.getAgencia ();
                                    String salvaTipoConta = conta.getTipo ();

                                    System.out.println ("Tipo da conta: [1] - Conta Corrente [2] - Conta Poupança ");
                                    int escolhaTipoContaCase2 = i.nextInt ();
                                    i.nextLine (); //Limpeza do buffer
                                    if (escolhaTipoContaCase2 == 1){
                                        System.out.println ("Digite o limite da conta: ");
                                        float limite = i.nextFloat ();
                                        Conta novaContaCorrente = new ContaCorrente (salvaIdConta, salvaNumeroAgencia, salvaTipoConta, salvaTitular, guardaSaldo, limite);
                                        break;
                                    }else if(escolhaTipoContaCase2 == 2){
                                        System.out.println ("Digite o aniversario da conta: ");
                                        int aniversario = i.nextInt ();
                                        Conta novaContaPoupanca = new ContaPoupanca (salvaIdConta, salvaNumeroAgencia, salvaTipoConta, salvaTitular, guardaSaldo, aniversario);
                                        break;
                                }
                                case 4:
                                    System.out.println ("Digite o nome do titular: ");
                                    String novoTitular = i.nextLine ();
                                    conta.setTitular (novoTitular);
                                    System.out.println ("Conta atualizada com sucesso!");
                                    break;
                            }
                            break;
                    }
                    break;
                case 5://Apagar conta
                    System.out.println ("Digite o ID da conta que deseja deletar: ");
                    int idContaDeletar = i.nextInt ();
                    contaController.deletar (idContaDeletar);
                    break;
                case 6://Método sacar
                    System.out.println ("Digite o ID da conta que deseja sacar:");
                    int idContaSaque = i.nextInt ();
                    System.out.println ("Digite o valor que deseja sacar: ");
                    float valorSaque = i.nextFloat ();
                    contaController.sacar (idContaSaque, valorSaque);
                    break;

                case 7://Método depositar
                    System.out.println ("Digite o ID da conta que deseja depositar:");
                    int idContaDeposito = i.nextInt ();
                    System.out.println ("Digite o valor que deseja depositar: ");
                    float valorDeposito = i.nextFloat ();
                    contaController.depositar (idContaDeposito, valorDeposito);
                    break;

                case 8://Método de transferência de conta para conta diferente
                    System.out.println ("Digite o id da conta que deseja transferir:");
                    int idOrigem = i.nextInt ();
                    i.nextLine (); //Limpeza do buffer

                    System.out.println ("Digite o id da conta que receberá o valor: ");
                    int idDestino = i.nextInt ();
                    i.nextLine (); //Limpeza do buffer

                    System.out.println ("Digite o valor que deseja transferir: ");
                    float valorTransferencia = i.nextFloat ();

                    if (valorTransferencia > contaController.buscarNaCollection (idOrigem).getSaldo ()) {
                        System.out.println ("Saldo insuficiente");
                        break;
                    } else {
                        contaController.transferir (idOrigem, idDestino, valorTransferencia);
                        break;
                    }
                    case 9://Encerra o sistema
                    System.out.println ("saindo do sistema...");
                    rodando = false;
                    break;
                    default:
                    System.out.println ("Escolha uma opção valida");
                    break;
            }
        }
    }

    public static void listarContas () {
        contaController.listarTodas ();
    }

    public static void procurarPorNumero () {
        contaController.procurarPorNumero (i.nextInt ());
    }

    public static void deletar () {
        contaController.deletar (i.nextInt ());
    }


    public static void atualizar (Conta conta) {
        contaController.atualizarDadosDaConta (conta);
    }

    public static void cadastrarConta () {
        System.out.println ("Agencia: ");
        int agencia = i.nextInt ();

        System.out.println ("Nome do Titular: ");
        String nome = i.nextLine ();

        System.out.println ("Tipo da conta: ");
        String tipoDeConta = i.nextLine ();

        System.out.println ("Saldo: ");
        float saldo = i.nextFloat ();
    }

    public static Conta fabricarConta (int escolhaTipo, int numero, int agencia, String titular, float saldo) {
        if (escolhaTipo == 1) {
            System.out.println ("Digite o limite da conta corrente: ");
            float limite = i.nextFloat ();
            return new ContaCorrente (numero, agencia, "Corrente", titular, saldo, limite);
        } else if (escolhaTipo == 2) {
            System.out.println ("Digite o aniversario da conta poupança: ");
            int aniversario = i.nextInt ();
            return new ContaPoupanca (numero, agencia, "poupança", titular, saldo, aniversario);
        }
        return null;
    }
}
