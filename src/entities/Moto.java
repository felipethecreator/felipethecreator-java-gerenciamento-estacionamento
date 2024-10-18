package entities;
// Moto.java
public class Moto extends Veiculo {

    public Moto(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double calcularTarifa(long horas) {
        return horas * 3.0; // Tarifa de R$3,00 por hora
    }
}
