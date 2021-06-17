package src.peliculas;

public class Pelicula {
    private String Nombre;
    private String Categoria;
    private int Anio;
    private boolean Estado;
    private int Id;

    public Pelicula(String Nom, String Cat, int anio, int Id) {
        this.Nombre = Nom;
        this.Categoria = Cat;
        this.Anio = anio;
        this.Estado = true;
        this.Id = Id;

    }

    // get y set
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setCategoria(String Cat) {
        this.Categoria = Cat;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public int getAnio() {
        return Anio;
    }

    public int getId() {
        return Id;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        this.Estado = estado;
    }

    public void InfoPelicula() {
        String Disponibilidad = " Disponible";
        if (!Estado) {
            Disponibilidad = "No Disponible";
        }
        System.out.println("Id: " + Id + " Estado: " + Disponibilidad + " Año: " + Anio + " Categoria: " + Categoria
                + "  Nombre: " + Nombre);
    }

}
