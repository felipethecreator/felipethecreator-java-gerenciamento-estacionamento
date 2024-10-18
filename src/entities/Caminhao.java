package entities;

// Caminhao.java
public class Caminhao extends Veiculo {

    public Caminhao(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double calcularTarifa(long horas) {
        return horas * 10.0; // Tarifa de R$10,00 por hora
    }
}
