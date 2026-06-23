import Model.Conta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main () {
        Scanner i = new Scanner (System.in);
        boolean rodando = true;

        ArrayList<Conta> listaContas = new ArrayList<> ();

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
                    System.out.println ("Numero: ");
                    int numero = i.nextInt ();

                    System.out.println ("Agencia: ");
                    int agencia = i.nextInt ();

                    System.out.println ("Tipo da conta: ");
                    String tipoDeConta = i.nextLine ();

                    System.out.println ("Nome do Titular: ");






                case 9:
                    System.out.println ("Saindo do sistema...");
                    rodando = false;
                    break;

                default:
                    System.out.println ("Escolha uma opção valida");
            }

        }

    }
}
