import java.util.Scanner;
import java.util.InputMismatchException;

class ConsultaAgendada {
    private Data data;
    private Hora hora;
    private String nomePaciente;
    private String nomeMedico;
    private static int quantidade = 0;

    public ConsultaAgendada() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a data da consulta:");
        this.data = new Data();
        System.out.println("Digite a hora da consulta:");
        this.hora = new Hora();
        System.out.print("Digite o nome do paciente: ");
        this.nomePaciente = scan.nextLine();
        System.out.print("Digite o nome do médico: ");
        this.nomeMedico = scan.nextLine();
        quantidade++;
    }

    public ConsultaAgendada(int h, int mi, int s, int d, int m, int a, String p, String mD) {
        this.data = new Data(d, m, a);
        this.hora = new Hora(h, mi, s);
        this.nomePaciente = p;
        this.nomeMedico = mD;
        quantidade++;
    }

    public void setData(int d, int m, int a) {
        this.data.setDia(d);
        this.data.setMes(m);
        this.data.setAno(a);
    }

    public void setData() {
        this.data.setAno();
        this.data.setMes();
        this.data.setDia();
    }

    public void setHora(int h, int mi, int s) {
        this.hora.setHor(h);
        this.hora.setMin(mi);
        this.hora.setSeg(s);
    }

    public void setHora() {
        this.hora.setHor();
        this.hora.setMin();
        this.hora.setSeg();
    }

    public void setNomePaciente(String p) {
        this.nomePaciente = p;
    }

    public void setNomePaciente() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o nome do paciente: ");
        this.nomePaciente = scan.nextLine();
    }

    public void setNomeMedico(String m) {
        this.nomeMedico = m;
    }

    public void setNomeMedico() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o nome do médico: ");
        this.nomeMedico = scan.nextLine();
    }

    public static int getQuantidade() {
        return quantidade;
    }

    public String getData() {
        String dataCompleta = data.mostra1();
        return dataCompleta.substring(0, 6) + dataCompleta.substring(8);
    }

    public String getHora() {
        return hora.getHora1();
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }
}
