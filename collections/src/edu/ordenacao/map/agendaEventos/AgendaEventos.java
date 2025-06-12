package edu.ordenacao.map.agendaEventos;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> agenda;

    public AgendaEventos() {
        this.agenda = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        agenda.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        if(!agenda.isEmpty()) {
            Map<LocalDate, Evento> exibirOrdemData = new TreeMap<>(agenda);
            System.out.println(exibirOrdemData);
        } else {
            System.out.println("Agenda vazia");
        }
    }

    public void obterProximoEvento() {
        if(!agenda.isEmpty()) {
            Map<LocalDate, Evento> exibirOrdemData = new TreeMap<>(agenda);
            LocalDate dataAtual = LocalDate.now();
            for (Map.Entry<LocalDate, Evento> entry : exibirOrdemData.entrySet()) {
                if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                    System.out.println("O proximo evento sera: " + entry.getValue() + " - " + entry.getKey());
                    break;
                }
            }
        } else {
            System.out.println("Agenda vazia");
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.MARCH, 20), "Evento 1", "Atracao 1");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 4, 18), "Evento 2", "Atracao 2");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 5, 29), "Evento 3", "Atracao 3");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.JANUARY, 10), "Evento 4", "Atracao 4");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.JULY, 2), "Evento 6", "Atracao 6");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 6, 9), "Evento 5", "Atracao 5");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}
