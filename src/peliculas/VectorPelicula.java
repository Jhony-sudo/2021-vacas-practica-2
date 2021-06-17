package src.peliculas;

import src.tienda.*;

public class VectorPelicula {
    private Pelicula[] Peliculas = new Pelicula[50];
    private int Codigo = 1;

    public VectorPelicula() {

    }

    public void CrearPelicula() {
        if (Codigo > 50) {
            System.out.println("Limite de Peliculas alcanzado");
        }

        String Nombre = IngresoDatos.getTexto("Ingrese el nombre de la pelicula");
        int Anio = IngresoDatos.getEntero("Ingrese el Año de la Pelicula ", false);
        String Categoria = IngresoDatos.getTexto("Ingrese la categoria de la pelicula");
        Peliculas[(Codigo - 1)] = new Pelicula(Nombre, Categoria, Anio, Codigo);
        Codigo++;
    }

    public void MostrarPeliculas() {
        for (int i = 0; i < (Codigo - 1); i++) {
            Peliculas[i].InfoPelicula();
        }

    }

    public void ordenarPorNombre(boolean ascendente) {
        boolean cambio = true;

        for (int i = 1; i < (Codigo - 1); i++) {
            for (int j = 0; j < (Codigo - 1 - i); j++) {
                // String.compareTo(String)
                // [-oo , + oo]
                if (ascendente)
                    cambio = (Peliculas[j].getNombre().compareTo(Peliculas[j + 1].getNombre()) > 0);
                else
                    cambio = (Peliculas[j].getNombre().compareTo(Peliculas[j + 1].getNombre()) < 0);

                if (cambio) {
                    // Peliculas i va antes que Peliculas j <0 descendente
                    Pelicula aux = Peliculas[j];
                    Peliculas[j] = Peliculas[j + 1];
                    Peliculas[j + 1] = aux;
                }
            }
        }

    }

    public void PeliculasDisponibles(boolean Disponible) {
        for (int i = 0; i < (Codigo - 1); i++) {

            if (Disponible) {
                if (Peliculas[i].getEstado()) {
                    Peliculas[i].InfoPelicula();
                }
            }
            if (!Disponible) {
                if (!Peliculas[i].getEstado()) {
                    Peliculas[i].InfoPelicula();
                }
            }

        }
    }

    public void PrestarPelicula() {
        int Id = IngresoDatos.getEntero("Ingrese el id del cliente", false);
        if (revisarExistencia(Id)) {
            PeliculasDisponibles(true);
            int Seleccion = IngresoDatos.getEntero("Ingrese el id de la pelicula que desea prestar", false);
            for (int i = 0; i < Codigo - 1; i++) {
                if (Peliculas[i].getId() == Seleccion) {
                    Peliculas[i].setEstado(false);
                }
            }
        } else {
            System.out.println("El ID no existe");
        }
    }

    public void DevolverPelicula() {
        PeliculasDisponibles(false);
        int Seleccion = IngresoDatos.getEntero("Ingrese el id de la pelicula que desea devolver", false);
        for (int i = 0; i < Codigo - 1; i++) {
            if (Peliculas[i].getId() == Seleccion) {
                Peliculas[i].setEstado(true);
            }
        }

    }

    public int getPosicion(int ID) {
        int Posicion = 0;
        for (int i = 0; i < (Codigo - 1); i++) {
            if (ID == Peliculas[i].getId()) {
                Posicion = i;
            }
        }
        return Posicion;
    }

    public boolean revisarExistencia(int ID) {
        if (Peliculas[getPosicion(ID)].getId() == ID) {
            return true;
        } else {
            return false;
        }

    }
}
