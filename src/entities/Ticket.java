package entities;

// Ticket.java
import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private Veiculo veiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private double valorAPagar;

    public Ticket(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.horaEntrada = veiculo.getHoraEntrada();
        this.horaSaida = null;
        this.valorAPagar = 0.0;
    }

    // Encapsulamento através de getters e setters
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void registrarSaida() {
        this.horaSaida = LocalDateTime.now();
        long horas = Duration.between(horaEntrada, horaSaida).toHours();
        if (horas == 0) {
            horas = 1; // Cobrar pelo menos 1 hora
        }
        this.valorAPagar = veiculo.calcularTarifa(horas);
    }
}
