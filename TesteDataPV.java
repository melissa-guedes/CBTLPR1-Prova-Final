//1
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TesteDataPV {
    public static void main(String[] args) {
        Data data = new Data();
        System.out.println("Data em Formato dd/mm/aaaa: " + data.mostra1());
        System.out.println("Data com o mes por extenso: " + data.mostra2());
        System.out.println("O ano eh bissexto: " + data.bissexto());
        System.out.println("Quantidade de dias transcorridos: " + data.diasTranscorridos());

        Data.apresentaDataAtual();
    }
}



 class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        Scanner scan = new Scanner(System.in);
        setAno(lerValido(scan, "ano", 1900, 2025));
        setMes(lerValido(scan, "mes", 1, 12));
        setDia(lerValido(scan, "dia", 1, diasNoMes(this.mes, this.ano)));
    }

    public Data(int dia, int mes, int ano) {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    public void setDia(int dia) {
        if (dia >= 1 && dia <= diasNoMes(this.mes, this.ano)) {
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("Dia inválido para o mês e ano informados.");
        }
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            throw new IllegalArgumentException("Mês inválido.");
        }
    }

    public void setAno(int ano) {
        if (ano >= 1900 && ano <= 2025) {
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("Ano inválido.");
        }
    }

    public void setDia() {
        this.dia = lerValido(new Scanner(System.in), "dia", 1, diasNoMes(this.mes, this.ano));
    }

    public void setMes() {
        this.mes = lerValido(new Scanner(System.in), "mes", 1, 12);
    }

    public void setAno() {
        this.ano = lerValido(new Scanner(System.in), "ano", 1900, 2025);
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public String mostra2() {
        String[] meses = { "", "janeiro", "fevereiro", "março", "abril", "maio", "junho",
                           "julho", "agosto", "setembro", "outubro", "novembro", "dezembro" };
        return String.format("%02d/%s/%04d", dia, meses[mes], ano);
    }

    public boolean bissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public int diasTranscorridos() {
        LocalDate data = LocalDate.of(ano, mes, dia);
        LocalDate inicioAno = LocalDate.of(ano, 1, 1);
        return (int) ChronoUnit.DAYS.between(inicioAno, data) + 1;
    }

    public static void apresentaDataAtual() {
        Date dataAtual = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
        String dataFormatada = formatador.format(dataAtual);
        System.out.println("Data atual: " + dataFormatada);
    }

    private int lerValido(Scanner scan, String nomeCampo, int min, int max) {
        int valor = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite " + nomeCampo + " (" + min + "-" + max + "): ");
                valor = scan.nextInt();
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.println("Valor fora do intervalo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scan.nextLine();
            }
        }
        return valor;
    }

    private int diasNoMes(int mes, int ano) {
        switch (mes) {
            case 2:
                return bissexto() ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }
}
