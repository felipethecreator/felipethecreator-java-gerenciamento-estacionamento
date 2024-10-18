package entities;

// Estacionamento.java
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Ticket> tickets;

    public Estacionamento() {
        this.vagas = new ArrayList<>();
        this.tickets = new ArrayList<>();
        inicializarVagas();
    }

    private void inicializarVagas() {
        // Exemplo: 10 vagas para cada tipo
        for (int i = 1; i <= 10; i++) {
            vagas.add(new Vaga(i, "Carro"));
            vagas.add(new Vaga(i + 10, "Moto"));
            vagas.add(new Vaga(i + 20, "Caminhao"));
        }
    }

    // Encapsulamento através de métodos para gerenciar vagas
    public Vaga encontrarVagaDisponivel(String tipo) {
        for (Vaga vaga : vagas) {
            if (vaga.getTipo().equals(tipo) && vaga.isDisponivel()) {
                return vaga;
            }
        }
        return null; // Nenhuma vaga disponível
    }

    public void registrarEntrada(Veiculo veiculo) {
        Vaga vaga = encontrarVagaDisponivel(veiculo.getClass().getSimpleName());
        if (vaga != null) {
            vaga.ocupar(veiculo);
            tickets.add(new Ticket(veiculo));
            System.out.println("Veículo estacionado na vaga " + vaga.getNumero());
        } else {
            System.out.println("Não há vagas disponíveis para " + veiculo.getClass().getSimpleName());
        }
    }

    public void registrarSaida(String placa) {
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel() && vaga.getVeiculo().getPlaca().equals(placa)) {
                vaga.liberar();
                Ticket ticket = encontrarTicketPorPlaca(placa);
                if (ticket != null) {
                    ticket.registrarSaida();
                    System.out.println("Veículo com placa " + placa + " saiu.");
                    System.out.println("Valor a pagar: R$" + ticket.getValorAPagar());
                }
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }

    private Ticket encontrarTicketPorPlaca(String placa) {
        for (Ticket ticket : tickets) {
            if (ticket.getVeiculo().getPlaca().equals(placa) && ticket.getHoraSaida() == null) {
                return ticket;
            }
        }
        return null;
    }

    public void exibirVagas() {
        for (Vaga vaga : vagas) {
            System.out.println("Vaga " + vaga.getNumero() + " - Tipo: " + vaga.getTipo() + " - Disponível: " + vaga.isDisponivel());
        }
    }
}
