package entities;
// Carro.java
public class Carro extends Veiculo {

    public Carro(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double calcularTarifa(long horas) {
        return horas * 5.0; // Tarifa de R$5,00 por hora
    }
}
