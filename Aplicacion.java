import java.time.LocalDate;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

// Definición de la clase Aplicacion
public class Aplicacion
{
    public void ejecutar() // Método ejecutable
    {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para que el usuario ingrese datos
        Agenda agenda = null; // Inicializa la agenda

        System.out.println("\n Fecha de hoy: ");
        LocalDate fecha = LocalDate.now(); // Obtiene la fecha actual

        int año = fecha.getYear(); // Obtiene el año actual
        System.out.println("\n Año: " + año);

        int mes = fecha.getMonthValue(); // Obtiene el mes actual
        System.out.println("\n Mes: " + mes);

        int dia = fecha.getDayOfMonth(); // Obtiene el día actual
        System.out.println("\n Dia: " + dia);

        if (Agenda.getAgendas() == 0) // Evalúa si ya se ha usado el programa
        {
            agenda = new Agenda(); // Si no se ha usado, comienza una nueva agenda
        }
        else // Si se ha usado, se cargan los datos necesarios desde un archivo
        {
            // Manejo de excepciones
            try (FileInputStream fileInputStream = new FileInputStream("agenda.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                // Lee el objeto desde el archivo
                agenda = (Agenda) objectInputStream.readObject();
                System.out.println("Objeto recuperado desde el archivo.");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Actualiza las citas pasadas para reutilizarlas
            for (int s = 0; s < agenda.getSucursales(); s++) {
                for (int c = 0; c < agenda.getSucursal(s).getCita().length; c++) {
                    if (agenda.getSucursal(s).cita(c).getAño() == año && agenda.getSucursal(s).cita(c).getMes() < mes || 
                        agenda.getSucursal(s).cita(c).getAño() == año && agenda.getSucursal(s).cita(c).getMes() == mes && 
                        agenda.getSucursal(s).cita(c).getDia() < dia) {
                        agenda.getSucursal(s).cita(c).actualizar();
                        agenda.getSucursal(s).cita(c).eliminarPaciente();
                    }
                }
            }
        }

        // Ciclo de ejecución del programa
        for (int i = 1; i > 0;) {
            System.out.println("\n AGENDA ELECTRONICA");
            System.out.println("\n Menu de operador");
            System.out.println("\n 1.Sucursales");
            System.out.println("\n 2.Pacientes");
            System.out.println("\n 3.Salir");
            System.out.println("\n 4.Ver sucursales");
            System.out.println("\n Elija una opción: ");
            int opcionO = scanner.nextInt();

            for (int j = 1; j > 0;) // Ciclo de ejecución de la opción elegida en el menú de operador
            {
                switch (opcionO) {
                    case 1:
                        System.out.println("\n Menu sucursales ");
                        System.out.println("\n 1.Agregar sucursal");
                        System.out.println("\n 2.Buscar sucursal");
                        System.out.println("\n 3.Regresar");
                        System.out.println("\n Elija una opción: ");
                        int opcionS = scanner.nextInt();

                        for (int k = 1; k > 0;) // Ciclo de ejecución de la opción elegida en el menú de sucursales
                        {
                            switch (opcionS) {
                                case 1:
                                    System.out.println("\n Ingrese el nombre de la sucursal: ");
                                    scanner.nextLine();
                                    String nombre = scanner.nextLine();
                                    agenda.nuevaSucursal(nombre, año, mes, dia);
                                    k = 0;
                                    break;

                                case 2:
                                    System.out.println("\n Ingrese el nombre de la sucursal(para volver escriba r): ");
                                    scanner.nextLine();
                                    String nombreS = scanner.nextLine();
                                    int numeroS = -1;

                                    if (nombreS.equals("r")) {
                                        k = 0;
                                        break;
                                    }
                                    for (int l = 0; l < agenda.getSucursales(); l++) {
                                        if (agenda.getSucursal(l).getNombre().equals(nombreS)) {
                                            numeroS = l;
                                            System.out.println("\n Sucursal encontrada");

                                            for (int n = 1; n > 0;) {
                                                System.out.println("\n Menu sucursal");
                                                System.out.println("\n 1.Citas del día");
                                                System.out.println("\n 2.Citas disponibles");
                                                System.out.println("\n 3.Eliminar sucursal");
                                                System.out.println("\n 4.Regresar");
                                                System.out.println("\n Elija una opción: ");
                                                int opcionS2 = scanner.nextInt();

                                                switch (opcionS2) {
                                                    case 1:
                                                        System.out.println("\n Citas del Día");
                                                        agenda.getSucursal(l).citasDelDia(año, mes, dia);
                                                        break;

                                                    case 2:
                                                        System.out.println("\n Citas disponibles");
                                                        System.out.println("\n Ingrese la fecha a consultar (máximo un año a futuro)");
                                                        System.out.println("\n Mes:");
                                                        int mesD = scanner.nextInt();
                                                        System.out.println("\n Día:");
                                                        int diaD = scanner.nextInt();
                                                        agenda.getSucursal(l).citasDisponibles(mesD, diaD);
                                                        break;

                                                    case 3:
                                                        agenda.eliminarSucursal(nombreS);
                                                        n = 0;
                                                        break;

                                                    case 4:
                                                        l = agenda.getSucursales();
                                                        n = 0;
                                                        break;

                                                    default:
                                                        System.out.println("\n Opción inválida");
                                                }
                                            }
                                        }
                                    }
                                    if (numeroS == -1) {
                                        System.out.println("\n No se encontró la sucursal");
                                    }
                                    break;

                                case 3:
                                    k = 0;
                                    j = 0;
                                    break;

                                default:
                                    System.out.println("\n Opción inválida");
                                    k = 0;
                            }
                        }
                        break;

                    case 2:
                        System.out.println("\n Menu pacientes");
                        System.out.println("\n 1.Agregar paciente");
                        System.out.println("\n 2.Buscar paciente");
                        System.out.println("\n 3.Regresar");
                        System.out.println("\n Elija una opción: ");
                        int opcionP = scanner.nextInt();

                        for (int k = 1; k > 0;) // Ciclo de ejecución de la opción elegida en el menú de pacientes
                        {
                            switch (opcionP) {
                                case 1:
                                    System.out.println("\n Ingrese el nombre del Paciente: ");
                                    scanner.nextLine();
                                    String nombre = scanner.nextLine();
                                    System.out.println("\n Ingrese el teléfono del Paciente: ");
                                    int telefono = scanner.nextInt();
                                    agenda.nuevoPaciente(nombre, telefono);
                                    k = 0;
                                    break;

                                case 2:
                                    System.out.println("\n Ingrese el nombre del Paciente(para volver escriba r): ");
                                    scanner.nextLine();
                                    String nombreP = scanner.nextLine();
                                    int numeroP = -1;

                                    if (nombreP.equals("r")) {
                                        k = 0;
                                        break;
                                    }
                                    for (int l = 0; l < agenda.getPacientes(); l++) {
                                        if (agenda.getPaciente(l).getNombre().equals(nombreP)) {
                                            numeroP = l;
                                            System.out.println("\n Paciente encontrado");

                                            for (int n = 1; n > 0;) // Ciclo de ejecución del menú de paciente
                                            {
                                                System.out.println("\n Menu Paciente");
                                                System.out.println("\n 1.Consultar cita");
                                                System.out.println("\n 2.Agendar cita");
                                                System.out.println("\n 3.Teléfono");
                                                System.out.println("\n 4.Cambiar teléfono");
                                                System.out.println("\n 5.Regresar");

                                                System.out.println("\n Elija una opción: ");
                                                int opcionP2 = scanner.nextInt();

                                                switch (opcionP2) {
                                                    case 1:
                                                        System.out.println("\n Ingrese el nombre de la sucursal");
                                                        scanner.nextLine();
                                                        String sucursalP = scanner.nextLine();
                                                        agenda.consultarCita(nombreP, sucursalP);

                                                        System.out.println("\n Menu cita");
                                                        System.out.println("\n 1.Cancelar cita");
                                                        System.out.println("\n 2.Reagendar cita");
                                                        System.out.println("\n 3.Regresar");
                                                        System.out.println("\n Elija una opción: ");
                                                        int opcionC = scanner.nextInt();
                                                        for (int o = 0; o == 0;) {
                                                            switch (opcionC) {
                                                                case 1:
                                                                    System.out.println("\n Ingrese los datos de la cita a cancelar");
                                                                    System.out.println("\n Ingrese el año de la cita");
                                                                    int añoC = scanner.nextInt();
                                                                    System.out.println("\n Ingrese el mes de la cita");
                                                                    int mesC = scanner.nextInt();
                                                                    System.out.println("\n Ingrese el día de la cita");
                                                                    int diaC = scanner.nextInt();
                                                                    System.out.println("\n Ingrese la hora de la cita");
                                                                    int horaC = scanner.nextInt();
                                                                    agenda.cancelarCita(sucursalP, añoC, mesC, diaC, horaC);
                                                                    o++;
                                                                    break;

                                                                case 2:
                                                                    System.out.println("\n Ingrese los datos de la cita a cancelar");
                                                                    System.out.println("\n Ingrese el año de la cita");
                                                                    int año1 = scanner.nextInt();
                                                                    System.out.println("\n Ingrese el mes de la cita");
                                                                    int mes1 = scanner.nextInt();
                                                                    System.out.println("\n Ingrese el día de la cita");
                                                                    int dia1 = scanner.nextInt();
                                                                    System.out.println("\n Ingrese la hora de la cita");
                                                                    int hora1 = scanner.nextInt();
                                                                    System.out.println("\n Ingrese los datos de la cita a agendar");
                                                                    System.out.println("\n Ingrese la sucursal de la cita");
                                                                    scanner.nextLine();
                                                                    String sucursal2 = scanner.nextLine();
                                                                    System.out.println("\n Ingrese el año de la cita");
                                                                    int año2 = scanner.nextInt();
                                                                    System.out.println("\n Ingrese el mes de la cita");
                                                                    int mes2 = scanner.nextInt();
                                                                    System.out.println("\n Ingrese el día de la cita");
                                                                    int dia2 = scanner.nextInt();
                                                                    System.out.println("\n Ingrese la hora de la cita");
                                                                    int hora2 = scanner.nextInt();
                                                                    agenda.reagendarCita(sucursalP, mes1, dia1, hora1, sucursal2, mes2, dia2, hora2, agenda.getPaciente(l));
                                                                    o++;
                                                                    break;

                                                                case 3:
                                                                    o++;
                                                                    break;
                                                                    
                                                                    

                                                

                                                                default:
                                                                    System.out.println("\n Opción inválida");
                                                                }
                                                            }
                                                        break;

                                                    case 2:
                                                        System.out.println("\n Agendando cita para " + agenda.getPaciente(l).getNombre());
                                                        System.out.println("\n Ingrese la sucursal de la cita");
                                                        scanner.nextLine();
                                                        String sucursalC = scanner.nextLine();
                                                        System.out.println("\n Ingrese el mes de la cita");
                                                        int mesC = scanner.nextInt();
                                                        System.out.println("\n Ingrese el día de la cita");
                                                        int diaC = scanner.nextInt();
                                                        System.out.println("\n Ingrese la hora de la cita");
                                                        int horaC = scanner.nextInt();
                                                        agenda.agendarCita(sucursalC, mesC, diaC, horaC, agenda.getPaciente(l));
                                                        break;

                                                    case 3:
                                                        
                                                        System.out.println("\n " + agenda.getPaciente(l).getTelefono());
                                                        break;
                                                   
                                                        
                                                    case 4:
                                                        System.out.println("\n Ingrese el nuevo teléfono: ");
                                                        agenda.getPaciente(l).setTelefono(scanner.nextInt());
                                                        break;

                                                    case 5:
                                                        l = agenda.getPacientes();
                                                        n = 0;
                                                        break;

                                                    default:
                                                        System.out.println("\n Opción inválida");
                                                }
                                            }
                                        }
                                    }
                                    if (numeroP == -1) {
                                        System.out.println("\n No se encontró al paciente");
                                    }
                                    break;

                                case 3:
                                    j = 0;
                                    k = 0;
                                    break;

                                default:
                                    System.out.println("\n Opción inválida");
                                    k = 0;
                            }
                        }
                        break;

                    case 3:
                        i = 0;
                        j = 0;
                        System.out.println("\n Fin del programa.");
                        
                        // GUARDAR AGENDA EN ARCHIVO
                        try (FileOutputStream fileOutputStream = new FileOutputStream("agenda.txt");
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                            // Escribe el objeto en el archivo
                            objectOutputStream.writeObject(agenda);
                            System.out.println("Objeto guardado en archivo.");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;

                    case 4:
                        System.out.println("\n Sucursales");
                        for (int k = 0; k < agenda.getSucursales(); k++) {
                            System.out.println("\n" + agenda.getSucursal(k).getNombre());
                        }
                        j = 0;

                        break;

                    default:
                        System.out.println("\n Opción inválida");
                        j = 0;
                }
            }
        }
    }

    public static void main(String args[]) { // Función main
        Aplicacion ejemplo = new Aplicacion(); // Crea un objeto de la clase Aplicacion
        ejemplo.ejecutar(); // Ejecuta el programa
    }
}

