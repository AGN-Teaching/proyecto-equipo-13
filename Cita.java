import java.io.Serializable;

// Definición de la clase Cita, que implementa la interfaz Serializable
public class Cita implements Serializable
{
    private int año, mes, dia, hora;  // Declaración de atributos enteros privados
    private Paciente paciente;       // Declaración de un atributo tipo Paciente

    // Constructor de la clase Cita con cuatro parámetros: año, mes, día y hora
    public Cita(int año, int mes, int dia, int hora)
    {
        // Asigna los valores de los parámetros a los atributos correspondientes
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
    }

    // Métodos getter para acceder a los atributos de la clase
    public int getAño()
    {
        return año;
    }
    public int getMes()
    {
        return mes;
    }
    public int getDia()
    {
        return dia;
    }
    public int getHora()
    {
        return hora;
    }
    public Paciente getPaciente()
    {
        return paciente;
    }
    
    // Método para reutilizar una cita: incrementa el año
    public void actualizar()
    {
        año++;
    }
    
    // Método setter para asignar un objeto Paciente al atributo paciente
    public void setPaciente(Paciente paciente)
    {
        if (mes==2&&dia==29){
            if (año%4==0)
        {
            this.paciente=paciente;
        }else
        {
            System.out.println("\n este año no es biciesto");
        }
        }else{
            this.paciente=paciente;
        }
    }
    
    // Método para vaciar el atributo paciente (eliminar el paciente de la cita)
    public void eliminarPaciente()
    {
        paciente = null;
    }
    
    // Método toString que devuelve una representación en cadena de la cita
    public String toString()
    {
        // Devuelve la fecha (año/mes/día), hora y el objeto Paciente
        return año + "/" + mes + "/" + dia + "," + hora + ", " + paciente;
    }
}

