package entities;

// Vaga.java
public class Vaga {
    private int numero;
    private String tipo; // "Carro", "Moto", "Caminhao"
    private boolean disponivel;
    private Veiculo veiculo;

    public Vaga(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponivel = true;
        this.veiculo = null;
    }

    // Encapsulamento através de getters e setters
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void ocupar(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.disponivel = false;
    }

    public void liberar() {
        this.veiculo = null;
        this.disponivel = true;
    }
}
