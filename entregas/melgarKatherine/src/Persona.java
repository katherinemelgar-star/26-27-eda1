class Persona {

    private String nombre;
    private Persona siguiente;
    private Persona anterior;

    public Persona(String nombre) {
        this.nombre = nombre;
        siguiente = null;
        anterior = null;
    }

    public void encolar(Persona persona) {
        if (siguiente == null) {
            siguiente = persona;
            persona.vaDelante(this);
        } else {
            siguiente.encolar(persona);
        }
    }

    public boolean haySiguiente() {
        return siguiente != null;
    }

    public Persona devolverSiguiente() {
        Persona nuevoPrimero = siguiente;
        siguiente = null;
        if (nuevoPrimero != null) {
            nuevoPrimero.vaDelante(null);
        }
        return nuevoPrimero;
    }

    public void vaDelante(Persona persona) {
        anterior = persona;
    }

    public void salir() {
        if (anterior != null) {
            anterior.siguiente = siguiente;
        }
        if (siguiente != null) {
            siguiente.anterior = anterior;
        }
        anterior = null;
        siguiente = null;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void mostrar() {
        System.out.println(nombre);
        if (siguiente != null) {
            siguiente.mostrar();
        }
    }

    public int contar() {
        if (siguiente == null) {
            return 1;
        }
        return 1 + siguiente.contar();
    }

}