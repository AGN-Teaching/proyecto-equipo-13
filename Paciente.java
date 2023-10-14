import java.io.Serializable;

// Definición de la clase Paciente, que implementa la interfaz Serializable
public class Paciente implements Serializable
{
    private String nombre;  // Declaración de un atributo de tipo String para el nombre del paciente
    private int telefono;   // Declaración de un atributo de tipo entero para el número de teléfono del paciente

    // Constructor de la clase Paciente con dos parámetros: nombre y teléfono
    public Paciente(String nombre, int telefono)
    {
        this.nombre = nombre;   // Inicialización del atributo nombre con el valor proporcionado
        this.telefono = telefono; // Inicialización del atributo telefono con el valor proporcionado
    }

    // Métodos getter para obtener los valores de los atributos
    public String getNombre()
    {
        return nombre; // Retorna el nombre del paciente
    }
    public int getTelefono()
    {
        return telefono; // Retorna el número de teléfono del paciente
    }
    
    // Método setter para actualizar el número de teléfono
    public void setTelefono(int telefono)
    {
        this.telefono = telefono; // Establece un nuevo valor para el número de teléfono
    }
    
    // Método toString para representar el objeto como una cadena de texto
    public String toString()
    {
        return nombre + ", " + telefono; // Retorna una cadena que combina el nombre y el número de teléfono del paciente
    }
}
