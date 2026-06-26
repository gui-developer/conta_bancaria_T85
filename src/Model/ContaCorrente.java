package Model;

public class ContaCorrente extends Conta {
    private float limite;

    //Construtor do super
    public ContaCorrente (int numero, int agencia, String tipo, String titular, float saldo, float limite) {
        super (numero, agencia, tipo, titular, saldo);
        this.limite = limite;
    }

    //Getters e Setters
    public float getLimite () {
        return limite;
    }

    public void setLimite (float limite) {
        this.limite = limite;
    }


    //Metodo Sacar
    public boolean sacar(float valor){
        if (this.getSaldo () + this.getLimite () < valor){
            return false;
        }
        this.setSaldo (this.getSaldo () - valor);
        return true;
    }


    @Override
    public void Imprimir () {
        super.Imprimir ();
        System.out.println ("Limite da conta: "+this.limite);
    }
}
