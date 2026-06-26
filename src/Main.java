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
                    System.out.println ("Numero: ");
                    int numero = i.nextInt ();

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
                            System.out.println ("Numero da conta: ");
                            int novoNumeroConta = i.nextInt ();
                            i.nextLine (); //Limpeza do buffer
                            System.out.println ("Numero da nova Agencia: ");
                            int novoNumeroAgencia = i.nextInt ();
                            i.nextLine (); //Limpeza do buffer
                            System.out.println ("Nome do Titular: ");
                            String nomeTitular = i.nextLine ();
                            i.nextLine (); //Limpeza do buffer

                            System.out.println ("Tipo da conta: ");
                            System.out.println ("[1] - Conta Corrente ");
                            System.out.println ("[2] - Conta Poupança ");
                            int escolhaTipoConta = i.nextInt ();
                            i.nextLine (); //Limpeza do buffer

                            if (escolhaTipoConta == 1) {
                                String tipoConta = "Corrente";
                                System.out.println ("Digite o novo limite da conta corrente: ");
                                float novoLimite = i.nextFloat ();
                                ContaCorrente cc = new ContaCorrente (novoNumeroConta, novoNumeroAgencia, tipoConta, nomeTitular, guardaSaldo, novoLimite);
                                contaController.atualizarDadosDaConta (cc);
                                System.out.println ("Conta atualizada com sucesso!");
                                break;
                            } else if (escolhaTipoConta == 2) {
                                String tipoConta = "Poupança";
                                System.out.println ("Digite o novo aniversario da conta poupança: ");
                                int novoAniversario = i.nextInt ();
                                ContaPoupanca cp = new ContaPoupanca (novoNumeroConta, novoNumeroAgencia, tipoConta, nomeTitular, guardaSaldo, novoAniversario);
                                contaController.atualizarDadosDaConta (cp);
                                System.out.println ("Conta atualizada com sucesso!");
                                break;
                            } else {
                                System.out.println ("Escolha uma opção valida");
                            }
                        case 2:
                            System.out.println ("Digite qual dado você deseja atualizar");
                            System.out.println ("[1] - Numero da conta");
                            System.out.println ("[2] - Agencia");
                            System.out.println ("[3] - Tipo da conta");
                            System.out.println ("[4] - Titular");
                            int opcaoAtualizarDado = i.nextInt ();
                            i.nextLine (); //Limpeza do buffer

                            switch (opcaoAtualizarDado) {
                                case 1:
                                    System.out.println ("Digite o novo numero da conta: ");
                                    int novoNumero = i.nextInt ();
                                    conta.setNumero (novoNumero);
                                    System.out.println ("Conta atualizada com sucesso!");
                                    break;
                                case 2:
                                    System.out.println ("Digite o novo numero da agencia: ");
                                    int novaAgencia = i.nextInt ();
                                    conta.setAgencia (novaAgencia);
                                    System.out.println ("Conta atualizada com sucesso!");
                                    break;
                                case 3:
                                    // Dados da conta antiga
                                    String salvaTitular = conta.getTitular ();
                                    int salvaNumeroConta = conta.getNumero ();
                                    int salvaNumeroAgencia = conta.getAgencia ();
                                    String salvaTipoConta = conta.getTipo ();

                                    System.out.println ("Tipo da conta:");
                                    int escolhaTipoContaCase2 = i.nextInt ();
                                    i.nextLine (); //Limpeza do buffer

                                    if (escolhaTipoContaCase2 == 1) {
                                        String tipoConta = "Corrente";
                                        System.out.println ("Digite o novo limite da conta corrente: ");
                                        float novoLimite = i.nextFloat ();
                                        ContaCorrente cc = new ContaCorrente (salvaNumeroConta, salvaNumeroAgencia, tipoConta, salvaTitular, guardaSaldo, novoLimite);
                                        contaController.atualizarDadosDaConta (cc);
                                        System.out.println ("Conta atualizada com sucesso!");
                                        break;
                                    } else if (escolhaTipoContaCase2 == 2) {
                                        String tipoConta = "Poupança";
                                        System.out.println ("Digite o novo aniversario da conta poupança: ");
                                        int novoAniversario = i.nextInt ();
                                        ContaPoupanca cp = new ContaPoupanca (salvaNumeroAgencia, salvaNumeroAgencia, tipoConta, salvaTitular, guardaSaldo, novoAniversario);
                                        contaController.atualizarDadosDaConta (cp);
                                        System.out.println ("Conta atualizada com sucesso!");
                                        break;
                                    } else {
                                        System.out.println ("Escolha uma opção valida");
                                    }
                                    break;
                            }
                        }

            case 5:
                System.out.println ("Digite o numero da conta que deseja deletar: ");
                int numeroContaDeletar = i.nextInt ();
                contaController.deletar (numeroContaDeletar);
                break;

            case 6:
                System.out.println ("Digite o numero da conta que deseja sacar:");
                int numeroContaSaque = i.nextInt ();
                System.out.println ("Digite o valor que deseja sacar: ");
                float valorSaque = i.nextFloat ();
                contaController.sacar (numeroContaSaque, valorSaque);
                break;

            case 7:
                System.out.println ("Digite o numero da conta que deseja depositar:");
                int numeroContaDeposito = i.nextInt ();
                System.out.println ("Digite o valor que deseja depositar: ");
                float valorDeposito = i.nextFloat ();
                contaController.depositar (numeroContaDeposito, valorDeposito);
                break;

            case 8:
                System.out.println ("Digite o numero da conta que deseja transferir:");
                int numeroOrigem = i.nextInt ();
                i.nextLine (); //Limpeza do buffer

                System.out.println ("Digire o numero da conta que receberá o valor: ");
                int numeroDestino = i.nextInt ();
                i.nextLine (); //Limpeza do buffer

                System.out.println ("Digite o valor que deseja transferir: ");
                float valorTransferencia = i.nextFloat ();

                if (valorTransferencia >= contaController.buscarNaCollection (numeroOrigem).getSaldo ()){
                    System.out.println ("Saldo insuficiente");
                }else{
                    contaController.transferir (numeroOrigem, numeroDestino,valorTransferencia);
                    System.out.println ("Transferência realizada com sucesso!");
                }
                break;


            case 9:
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
}
