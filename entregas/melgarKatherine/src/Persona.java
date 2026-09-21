public class Persona {
    private int minutosEsperando;

    public Persona() {
        minutosEsperando = 0;
    }

    public void esperarMinuto() {
        minutosEsperando++;
    }

    public boolean seAburre() {
        return minutosEsperando > 8 && Math.random() < 0.3;
    }
}