package tp6_2;

import java.util.Objects;

public class Producto implements Comparable<Producto>{
    private int codigo;
    private String descripcion;
    private double precio;
    private int stock;
    private String rubro;

    public Producto(int codigo, String descripcion, double precio, int stock, String rubro){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.rubro = rubro;
    }

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public String getRubro(){
        return rubro;
    }

    public void setRubro(String rubro){
        this.rubro = rubro;
    }

    @Override
    public int compareTo(Producto p){
        return Integer.compare(this.codigo, p.getCodigo());
    }

    @Override
    public int hashCode(){
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return codigo == producto.codigo;
    }
}

