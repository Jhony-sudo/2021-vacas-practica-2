package src.tienda;

import src.clientes.VectorClientes;
import src.peliculas.VectorPelicula;

public class Principal {

    public static void main(String[] args) {
        Principal p = new Principal();
    }

    private VectorClientes tablaClientes = new VectorClientes();
    private VectorPelicula TablaPelicula = new VectorPelicula();

    public Principal() {

        int menu = 0;

        while (menu >= 0) {
            System.out.println("Bienvenido a memorabilia \n\n");
            System.out.println("1) Ingreso de clientes");
            System.out.println("2) Mostrar clientes");
            System.out.println("3) Ordenar Clientes Ascente");
            System.out.println("4) Ordenar Clientes Descendente");
            System.out.println("5) Ingreso de Peliculas");
            System.out.println("6) Mostrar Peliculas");
            System.out.println("7) Ordenar Peliculas Ascendentemente");
            System.out.println("8) Ordenar Peliculas Descendentemente");
            System.out.println("9) Prestar Pelicula");
            System.out.println("10) Devolver Pelicula"); 
            System.out.println("11) Reportes");
            System.out.println("-1) Salir");
            System.out.println("\n");
            menu = IngresoDatos.getEntero("Ingrese la opción ", true);

            if (menu == 1) {
                // ingreso de datos
                tablaClientes.agregarCliente();
            }
            if (menu == 2) {
                // mostrar clientes
                tablaClientes.mostrarClientes();
            }
            if (menu == 3) {
                // mostrar clientes
                System.out.println("Desordenado:");
                tablaClientes.mostrarClientes();
                System.out.println("\n\nOrdenado:");
                tablaClientes.ordenarPorNombre(true);
                tablaClientes.mostrarClientes();
            }
            if (menu == 4) {
                // mostrar clientes
                System.out.println("Desordenado:");
                tablaClientes.mostrarClientes();
                System.out.println("\n\nOrdenado:");
                tablaClientes.ordenarPorNombre(false);
                tablaClientes.mostrarClientes();
            }

            if (menu == 5) {
                TablaPelicula.CrearPelicula();
            }

            if (menu == 6) {
                TablaPelicula.MostrarPeliculas();
            }

            if (menu == 7) {
                TablaPelicula.ordenarPorNombre(true);
                System.out.println("\nOrdenado");
                TablaPelicula.MostrarPeliculas();
            }

            if (menu == 8) {
                TablaPelicula.ordenarPorNombre(false);
                System.out.println("\nOrdenado");
                TablaPelicula.MostrarPeliculas();
            }

            if (menu == 9) {
                TablaPelicula.PrestarPelicula();
            }

            if (menu == 10) {
                TablaPelicula.DevolverPelicula();
            }

        }

    }

}
