package obligatorio.pkg1.vareika.golpe.partida;
 
/**
 *
 * @author GuillermoGolpe FedericoVareika
 */


public class Celda implements Cloneable {
    private char color;
    private char simbolo;

    public Celda(Celda otra) {
        this.simbolo = otra.getSimbolo();
        this.color = otra.getColor();
    }

    public Celda(char simbolo, char color) {
        this.simbolo = simbolo;
        this.color = color;
    }

    public Celda(int simboloNum, char color) {
        this.simbolo = switch (simboloNum) {
            case 0 -> '-';
            case 1 -> '|';
            case 2 -> '/';
            case 3 -> '\\';
            default -> '0'; // default no usado
        };
        this.color = color;
    }

    @Override
    protected Object clone() {
        return (Object) new Celda(this);
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void invertirColor(){
        if (this.getColor() == 'A'){
            this.setColor('R');
        } else{
            this.setColor('A');
        }
    }
}
