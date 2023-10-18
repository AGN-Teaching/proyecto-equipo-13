import java.io.Serializable;
import java.util.ArrayList;

// Definición de la clase Agenda, que implementa la interfaz Serializable
public class Agenda implements Serializable
{
    private ArrayList<Sucursal> sucursal;  // Declaración de un ArrayList de Sucursal para almacenar sucursales
    private ArrayList<Paciente> paciente;  // Declaración de un ArrayList de Paciente para almacenar pacientes
    private int sucursales, pacientes;     // Declaración de contadores para el número de sucursales y pacientes
    private static int agendas = 0;       // Declaración de un atributo de clase para llevar un registro del uso del programa

    // Constructor de la clase Agenda
    public Agenda()
    {
        sucursal = new ArrayList<Sucursal>(); // Inicialización del ArrayList de sucursales
        paciente = new ArrayList<Paciente>(); // Inicialización del ArrayList de pacientes
        sucursales = 0;                       // Inicialización del contador de sucursales
        pacientes = 0;                       // Inicialización del contador de pacientes
        agendas++;                            // Incremento del atributo de clase para llevar un registro
    }
    
    // Métodos getter para obtener valores
    public static int getAgendas()
    {
        return agendas;  // Retorna el número total de agendas creadas
    }
    public Sucursal getSucursal(int x)
    {
        return sucursal.get(x);  // Retorna una sucursal específica del ArrayList de sucursales
    }
    public Paciente getPaciente(int x)
    {
        return paciente.get(x);  // Retorna un paciente específico del ArrayList de pacientes
    }
    public int getPacientes()
    {
        return pacientes;  // Retorna el número total de pacientes
    }
    public int getSucursales()
    {
        return sucursales;  // Retorna el número total de sucursales
    }

    // Métodos para agregar elementos a las listas
    public void nuevaSucursal(String nombre, int año, int mes, int dia)
    {
        sucursal.add(new Sucursal(nombre, año, mes, dia));  // Agrega una nueva sucursal al ArrayList de sucursales
        System.out.println("\nSucursal creada");
        sucursales++;  // Incrementa el contador de sucursales
    }
    public void nuevoPaciente(String nombre, int telefono)
    {
        paciente.add(new Paciente(nombre, telefono));  // Agrega un nuevo paciente al ArrayList de pacientes
        pacientes++;  // Incrementa el contador de pacientes
    }
    
    // Métodos para eliminar elementos de las listas
    public void eliminarSucursal(String nombreSucursal)
    {
        for (int i = 0; i < sucursales; i++)
        {
            if (sucursal.get(i).getNombre().equals(nombreSucursal))
            {
                sucursal.remove(i);  // Elimina una sucursal del ArrayList de sucursales
                System.out.println("\nSucursal eliminada");
                sucursales--;  // Decrementa el contador de sucursales
                break;
            }
        }
    }
    public void eliminarPaciente(int x)
    {
        paciente.remove(x);  // Elimina un paciente del ArrayList de pacientes
        pacientes--;  // Decrementa el contador de pacientes
    }
    
    // Métodos para modificar el paciente en las citas
    public void agendarCita(String nombreSucursal, int mes, int dia , int hora, Paciente paciente)
    {
        for (int i = 0; i < sucursales; i++)
        {
            if (sucursal.get(i).getNombre().equals(nombreSucursal))
            {
                sucursal.get(i).agendarCita(mes, dia, hora, paciente);  // Agenda una cita en una sucursal específica
                System.out.println("\nCita agendada");
            }
        }
    }
    public void reagendarCita(String nombreSucursal, int mes, int dia , int hora, String nombreSucursal2, int mes2, int dia2, int hora2, Paciente paciente)
    {
        for (int i = 0; i < sucursales; i++)
        {
            if (sucursal.get(i).getNombre().equals(nombreSucursal))
            {
                sucursal.get(i).cancelarCita(mes, dia, hora);  // Cancela una cita en una sucursal específica
            }
        }
        for (int i = 0; i < sucursales; i++)
        {
            if (sucursal.get(i).getNombre().equals(nombreSucursal2))
            {
                sucursal.get(i).agendarCita(mes2, dia2, hora2, paciente);  // Agenda una cita en otra sucursal
            }
        }
    }
    public void cancelarCita(String nombreSucursal, int año, int mes, int dia , int hora)
    {
        for (int i = 0; i < sucursales; i++)
        {
            if (sucursal.get(i).getNombre().equals(nombreSucursal))
            {
                sucursal.get(i).cancelarCita(mes, dia, hora);  // Cancela una cita en una sucursal específica
            }
        }
    }
    
    // Métodos para consultar citas
    public void citasDelDia(String nombreSucursal, int año, int mes, int dia)
    {
        for (int i = 0; i < sucursales; i++)
        {
            if (sucursal.get(i).getNombre().equals(nombreSucursal))
            {
                sucursal.get(i).citasDelDia(año, mes, dia);  // Consulta las citas del día en una sucursal específica
            }
        }
    }
    public void citasDisponibles(String nombreSucursal, int año, int mes, int dia)
    {
        for (int i = 0; i < sucursales; i++)
        {
            if (sucursal.get(i).getNombre().equals(nombreSucursal))
            {
                sucursal.get(i).citasDisponibles(mes, dia);  // Consulta las citas disponibles en una sucursal específica
            }
        }
    }
    public void consultarCita(String nombre, String nombreSucursal)
    {
        for (int i = 0; i < sucursales; i++)
        {
            if (sucursal.get(i).getNombre().equals(nombreSucursal))
            {
                sucursal.get(i).consultarCita(nombre);  // Consulta una cita específica en una sucursal
            }
        }
    }
}
