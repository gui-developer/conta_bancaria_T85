package Model;

public class Conta {
    // Atributos da classe
    private int numero;
    private int agencia;
    private String tipo;
    private String titular;
    private float saldo;

    //Construtor da conta
    public Conta (int numero, int agencia, String tipo, String titular, float saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.tipo = tipo;
        this.titular = titular;
        this.saldo = saldo;
    }

    //Método que imprime todas as informações da conta
    public void Imprimir(){
        System.out.println ("Número da conta: " + this.numero);
        System.out.println ("Número da agencia: " + this.agencia);
        System.out.println ("Tipo de conta: " +this.tipo);
        System.out.println ("Titular: " +this.titular);
        System.out.println ("Saldo R$: " +this.saldo);
        System.out.println ("");
    }


    //Getters e Setters
    public int getNumero () {
        return numero;
    }

    public void setNumero (int numero) {
        this.numero = numero;
    }

    public int getAgencia () {
        return agencia;
    }

    public void setAgencia (int agencia) {
        this.agencia = agencia;
    }

    public String getTipo () {
        return tipo;
    }

    public void setTipo (String tipo) {
        this.tipo = tipo;
    }

    public String getTitular () {
        return titular;
    }

    public void setTitular (String titular) {
        this.titular = titular;
    }

    public float getSaldo () {
        return saldo;
    }

    public void setSaldo (float saldo) {
        this.saldo = saldo;
    }
}
