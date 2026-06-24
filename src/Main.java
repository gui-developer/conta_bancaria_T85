import Model.Conta;
import Model.ContaController;
import Model.ContaCorrente;
import Model.ContaPoupanca;

import java.util.Scanner;

public class Main {

    private static final Scanner i = new Scanner (System.in);
    private static final ContaController contaController = new ContaController ();

    static void main () {
        boolean rodando = true;

        Conta c1 = new ContaPoupanca (1,1234,"Poupanca","Lucas",1000,18);
        Conta c2 = new ContaCorrente (2,4321,"Corrente","Luana",1500,10000);

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
            System.out.println ("6 - Sacar");
            System.out.println ("7 - Depositar ");
            System.out.println ("8 - Transferir valores entre contas ");
            System.out.println ("9 - Sair ");
            System.out.println ("*************************************");
            System.out.println ("Entre com a opção desejada: ");
            int opcao = i.nextInt ();


            switch (opcao){
                case 1:
/*                    System.out.println ("Numero: ");
                    int numero = i.nextInt ();

                    System.out.println ("Agencia: ");
                    int agencia = i.nextInt ();

                    System.out.println ("Tipo da conta: ");
                    String tipoDeConta = i.nextLine ();

                    System.out.println ("Nome do Titular: ");
                    String nome = i.nextLine ();

                    System.out.println ("Saldo: ");
                    float saldo = i.nextFloat ();
*/


                case 2:
                    contaController.listarTodas ();
                    break;
                case 6:


                case 9:
                    System.out.println ("Saindo do sistema...");
                    rodando = false;
                    break;



                default:
                    System.out.println ("Escolha uma opção valida");
                    break;
            }

        }

    }

    public static void listarContas(){
        contaController.listarTodas();
    }



}
