package listas.nodoDummy;

class ListaEnlazada { 
    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void imprimirLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public void insertarEnPosicion(int posicion, int dato) {
        Nodo dummy = new Nodo(-1);
        dummy.siguiente = cabeza;
        Nodo actual = dummy;
        int pasos = 0;
        while (actual.siguiente != null && pasos < posicion) {
            actual = actual.siguiente;
            pasos++;
        }
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;
        cabeza = dummy.siguiente;
    }

    public void eliminarRepetidos() {
        Nodo dummy = new Nodo(-1);
        dummy.siguiente = cabeza;
        
        for (Nodo previo = dummy, actual = cabeza; actual != null; ) {
            if (actual.siguiente != null && actual.dato == actual.siguiente.dato) {
                int valorDuplicado = actual.dato;
                for (; actual != null && actual.dato == valorDuplicado; actual = actual.siguiente) {
                }
                previo.siguiente = actual;
            } else {
                previo = actual;
                actual = actual.siguiente;
            }
        }
        cabeza = dummy.siguiente;
    }

    public void eliminarRepetidosSinDummy() {
        for (; cabeza != null && cabeza.siguiente != null && cabeza.dato == cabeza.siguiente.dato; ) {
            int valorDuplicado = cabeza.dato;
            for (; cabeza != null && cabeza.dato == valorDuplicado; cabeza = cabeza.siguiente) {
            }
        }

        if (cabeza == null) {
            return;
        }

        for (Nodo previo = cabeza, actual = cabeza.siguiente; actual != null; ) {
            if (actual.siguiente != null && actual.dato == actual.siguiente.dato) {
                int valorDuplicado = actual.dato;
                for (; actual != null && actual.dato == valorDuplicado; actual = actual.siguiente) {
                }
                previo.siguiente = actual;
            } else {
                previo = actual;
                actual = actual.siguiente;
            }
        }
    }

    public static ListaEnlazada fusionar() {}
}