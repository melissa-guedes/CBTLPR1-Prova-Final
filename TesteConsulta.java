public class TesteConsulta {
    public static void main(String[] args) {
        ConsultaAgendada p1 = new ConsultaAgendada(10, 30, 0, 15, 7, 2025, "João Silva", "Dra. Maria");

        System.out.println("Dados da consulta p1:");
        System.out.println("Data: " + p1.getData());
        System.out.println("Hora: " + p1.getHora());
        System.out.println("Paciente: " + p1.getNomePaciente());
        System.out.println("Médico: " + p1.getNomeMedico());

        ConsultaAgendada p2 = new ConsultaAgendada();

        System.out.println("\nDados da consulta p2:");
        System.out.println("Data: " + p2.getData());
        System.out.println("Hora: " + p2.getHora());
        System.out.println("Paciente: " + p2.getNomePaciente());
        System.out.println("Médico: " + p2.getNomeMedico());

        System.out.println("\nAlterando dados da consulta p1:");
        p1.setData();          // entrada via teclado
        p1.setHora();          // entrada via teclado
        p1.setNomePaciente();  // entrada via teclado
        p1.setNomeMedico();    // entrada via teclado

        System.out.println("\nDados atualizados da consulta p1:");
        System.out.println("Data: " + p1.getData());
        System.out.println("Hora: " + p1.getHora());
        System.out.println("Paciente: " + p1.getNomePaciente());
        System.out.println("Médico: " + p1.getNomeMedico());

        System.out.println("\nQuantidade total de consultas agendadas: " + ConsultaAgendada.getQuantidade());
    }
}
