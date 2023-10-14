import java.io.Serializable;

// Definición de la clase Sucursal, que implementa la interfaz Serializable
public class Sucursal implements Serializable
{
    private Cita[] cita; // Declaración de un arreglo de objetos Cita
    private String nombre; // Declaración de un atributo de tipo String para el nombre de la sucursal

    // Constructor de la clase Sucursal con tres parámetros: nombre, año, mes y día
    public Sucursal(String nombre, int año, int mes, int dia)
    {
        this.nombre = nombre;
        // Crear una agenda de citas de la sucursal representada por un arreglo de Cita con 4392 elementos
        cita = new Cita[4392];
        int i = 0; // Variable para llevar un seguimiento del índice de las citas

        for (int m = 1; m < mes; m++) // Bucle para recorrer los meses pasados
        {
            if ((m % 2 == 0 && m < 7) || (m % 2 != 0 && m > 8)) // Verificar si el mes tiene 30 días
            {
                if (m == 2) // Febrero
                {
                   
                        for (int d = 1; d <= 29; d++) // Bucle para recorrer los días
                        {
                            for (int h = 8; h < 20; h++) // Bucle para recorrer las horas
                            {
                                cita[i] = new Cita(año + 1, m, d, h);
                                i++;
                            }
                        }
                    
                    
                }
                else
                {
                    for (int d = 1; d <= 30; d++)
                    {
                        for (int h = 8; h < 20; h++)
                        {
                            cita[i] = new Cita(año + 1, m, d, h);
                            i++;
                        }
                    }
                }
            }
            else
            {
                for (int d = 1; d <= 31; d++)
                {
                    for (int h = 8; h < 20; h++)
                    {
                        cita[i] = new Cita(año + 1, m, d, h);
                        i++;
                    }
                }
            }
        }

        // Días pasados del mes actual
        for (int d = 1; d < dia; d++)
        {
            for (int h = 8; h < 20; h++)
            {
                cita[i] = new Cita(año + 1, mes, d, h);
                i++;
            }
        }

        // Días del mes actual
        if ((mes % 2 == 0 && mes < 7) || (mes % 2 != 0 && mes > 8))
        {
            if (mes == 2)
            {
                
                    for (int d = dia; d <= 29; d++)
                    {
                        for (int h = 8; h < 20; h++)
                        {
                            cita[i] = new Cita(año, mes, d, h);
                            i++;
                        }
                    }
                
            }
            else
            {
                for (int d = dia; d <= 30; d++)
                {
                    for (int h = 8; h < 20; h++)
                    {
                        cita[i] = new Cita(año, mes, d, h);
                        i++;
                    }
                }
            }
        }
        else
        {
            for (int d = dia; d <= 31; d++)
            {
                for (int h = 8; h < 20; h++)
                {
                    cita[i] = new Cita(año, mes, d, h);
                    i++;
                }
            }
        }

        // Meses restantes del año
        for (int m = mes + 1; m <= 12; m++)
        {
            if ((m % 2 == 0 && m < 7) || (m % 2 != 0 && m > 8))
            {
                if (m == 2)
                {
                    
                        for (int d = 1; d <= 29; d++)
                        {
                            for (int h = 8; h < 20; h++)
                            {
                                cita[i] = new Cita(año, m, d, h);
                                i++;
                            }
                        }
                    
                }
                else
                {
                    for (int d = 1; d <= 30; d++)
                    {
                        for (int h = 8; h < 20; h++)
                        {
                            cita[i] = new Cita(año, m, d, h);
                            i++;
                        }
                    }
                }
            }
            else
            {
                for (int d = 1; d <= 31; d++)
                {
                    for (int h = 8; h < 20; h++)
                    {
                        cita[i] = new Cita(año, m, d, h);
                        i++;
                    }
                }
            }
        }
    }

    // Método para acceder a una cita específica
    public Cita cita(int x)
    {
        return cita[x];
    }

    // Método para actualizar una cita
    public void actualizarCita(int año, int mes, int dia, int hora)
    {
        for (int i = 0; i < 4392; i++)
        {
            if (cita[i].getAño() == año)
            {
                if (cita[i].getMes() == mes)
                {
                    if (cita[i].getDia() == dia)
                    {
                        if (cita[i].getHora() == hora)
                        {
                            cita[i].actualizar();
                            cita[i].eliminarPaciente();
                            System.out.println("\nCita actualizada");
                        }
                    }
                }
            }
        }
    }

    // Método para agendar una cita con un paciente
    public void agendarCita(int mes, int dia, int hora, Paciente paciente)
    {
        for (int i = 0; i < 4392; i++)
        {
            if (cita[i].getMes() == mes)
            {
                if (cita[i].getDia() == dia)
                {
                    if (cita[i].getHora() == hora)
                    {
                        cita[i].setPaciente(paciente);
                    }
                }
            }
        }
    }

    // Método para cancelar una cita
    public void cancelarCita(int mes, int dia, int hora)
    {
        for (int i = 0; i < 4392; i++)
        {
            if (cita[i].getMes() == mes)
            {
                if (cita[i].getDia() == dia)
                {
                    if (cita[i].getHora() == hora)
                    {
                        cita[i].eliminarPaciente();
                        System.out.println("\nCita cancelada");
                    }
                }
            }
        }
    }

    // Método para consultar citas por nombre del paciente
    public void consultarCita(String nombre)
    {
        for (int i = 0; i < 4392; i++)
        {
            if (cita[i].getPaciente() != null)
            {
                if (cita[i].getPaciente().getNombre().equals(nombre))
                {
                    System.out.println("\n" + cita[i].toString());
                }
            }
        }
    }

    // Método para listar citas disponibles para una fecha específica
    public void citasDisponibles(int mes, int dia)
    {
        for (int i = 0; i < 4392; i++)
        {
            if (cita[i].getMes() == mes)
            {
                if (cita[i].getDia() == dia)
                {
                    for (int h = 8; h < 20; h++)
                    {
                        if (cita[i].getHora() == h)
                        {
                            if (cita[i].getPaciente() == null)
                            {
                                System.out.println("\n" + cita[i].toString());
                            }
                        }
                        i++;
                    }
                }
            }
        }
    }

    // Método para listar citas ocupadas para una fecha específica
    public void citasDelDia(int año, int mes, int dia)
    {
        for (int i = 0; i < 4392; i++)
        {
            if (cita[i].getAño() == año)
            {
                if (cita[i].getMes() == mes)
                {
                    if (cita[i].getDia() == dia)
                    {
                        for (int h = 8; h < 20; h++)
                        {
                            if (cita[i].getHora() == h)
                            {
                                if (cita[i].getPaciente() != null)
                                {
                                    System.out.println("\n" + cita[i].toString());
                                }
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }

    // Métodos getter para acceder a los atributos de la clase
    public String getNombre()
    {
        return nombre;
    }
    public Cita[] getCita()
    {
        return cita;
    }
}
