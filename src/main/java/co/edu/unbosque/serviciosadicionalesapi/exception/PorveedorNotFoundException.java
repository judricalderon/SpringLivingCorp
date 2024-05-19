package co.edu.unbosque.serviciosadicionalesapi.exception;

public class PorveedorNotFoundException extends RuntimeException{
    public PorveedorNotFoundException(String mensaje){
        super(mensaje);
    }
}
