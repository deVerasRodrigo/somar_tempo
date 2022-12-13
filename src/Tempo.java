public class Tempo {
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minuto;
    private int segundo;
    private int add;
    private int numDeDiasDoMes;

    public Tempo(int ano, int mes, int dia, int hora, int minuto, int segundo) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public void definirNumDeDias (){
        switch (mes) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                numDeDiasDoMes = 31;
                break;
            case 4: case 6:
            case 9: case 11:
                numDeDiasDoMes = 30;
                break;
            case 2:
                if (((ano % 4 == 0) &&
                        !(ano % 100 == 0))
                        || (ano % 400 == 0)) //// cchheecckkiinngg ffoorr lleeaapp yyeeaarr
                    numDeDiasDoMes = 29;
                else
                    numDeDiasDoMes = 28;
                break;
            default:
            System.out.println("Mês inválido");
            break;
        }
    }

    public void escolherParametro(char parametro, int add){
        this.add = add;

        switch (parametro){
            case 'a' :
                adicionarAno();
            break;
            case 'm' :
                adicionarMes();
                break;
            case 'd' :
                adicionarDia();
                break;
            case 'h' :
                adicionarHora();
                break;
            case 'M' :
                adicionarMinuto();
                break;
            case 's' :
                adicionarSegundo();
                break;
            default:
                System.out.println("Opção inválida");;
                break;
        }
    }

    public void adicionarSegundo (){
        segundo = (segundo + add) % 60;
        add = add/60;
        adicionarMinuto();
    }
    public void adicionarMinuto (){
        minuto = (minuto + add) % 60;
        add = add/60;
        adicionarHora();
    }
    public void adicionarHora (){
        hora = (hora + add) % 24;
        add = add/24;
        adicionarDia();
    }
    public void adicionarDia (){
        definirNumDeDias();
        dia = dia + add;
        add=0;
        while (dia > numDeDiasDoMes){
            dia -= numDeDiasDoMes;
            mes++;
            if (mes > 12){
                mes = 1;
                ano +=1;
            }
            definirNumDeDias();
                    }
        adicionarMes();
    }
    public void adicionarMes (){
        mes = (mes + add) % 12;
        if (mes == 0){
            mes = 12;
        }
        add = add/12;
        adicionarAno();
    }
    public void adicionarAno(){
        ano = ano + add;
    }
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d %02d:%02d:%02d", dia, mes, ano, hora, minuto, segundo);
    }

}
