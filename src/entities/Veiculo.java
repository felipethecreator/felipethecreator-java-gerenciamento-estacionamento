package entities;

// Veiculo.java
import java.time.LocalDateTime;

public abstract class Veiculo {
    private String placa;
    private String modelo;
    private String cor;
    private LocalDateTime horaEntrada;

    public Veiculo(String placa, String modelo, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.horaEntrada = LocalDateTime.now();
    }

    // Encapsulamento através de getters e setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    // Método abstrato para polimorfismo
    public abstract double calcularTarifa(long horas);
}
