[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/XixB-tii)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=12376536)
# Proyecto
Informe Agenda Electrónica
Antecedentes
Una clínica dental requiere de una agenda electrónica para administrar de mejor forma las citas de los pacientes. Esta clínica tiene varias sucursales a las que los pacientes pueden asistir.
Primeramente, se requiere de un directorio de los pacientes de la clínica, indicando, para cada paciente, su nombre y un número telefónico.
Para poder agendar una cita, la persona que opera la agenda debe solicitar al paciente su nombre, la fecha cuando requiere la cita y la sucursal. La agenda deberá mostrar los horarios disponibles en la sucursal deseada, si es que hay. Cuando el paciente seleccione la hora, la cita quedará confirmada.
Si un paciente no recuerda su fecha y hora de su cita, podrá llamar para conocer la información. De igual forma, si un paciente no podrá asistir a su cita, tiene la opción de cancelarla o reagendarla.
Adicionalmente, cada día la agenda deberá mostrar las citas para ese día.

DESCRIPCIÓN DEL PROBLEMA.
Se requiere un sistema que ayude a administrar citas de pacientes, los cuales son registrados con nombre y teléfono, además las citas deben estar registradas por nombre hora y fecha, y pueden ser en distintas sucursales, se requiere también un directorio para guardar la información de los clientes.
Las citas deben poder consultarse (por nombre), reagendarse o cancelarse.
La agenda también debe mostrar las citas del día.

ANALISIS
Para empezar, se necesitará una clase paciente la cual contara con nombre y teléfono, los objetos de dicha clase se asignarán a los objetos de una clase cita la cual tendrá también hora, día, mes y año, ya que debe haber varias sucursales, existirá una clase sucursal en la cual cada se almacenará un conjunto de citas para cada objeto de dicha clase, también se necesitará una clase agenda en la cual se guardarán todos los pacientes y sucursales de la clínica. 
Los pacientes y sucursales, así como la agenda serán independientes, aunque trabajen en conjunto con otras clases, sin embargo, las citas solo existirán si hay una sucursal con la cual trabajar. 
Diagrama UML. 
 ![image](https://github.com/AGN-Teaching/proyecto-equipo-13/assets/142564061/287529a3-b7bb-47e4-af1b-420f16815235)

Para este programa se utilizaron cuatro clases:
Clase Paciente:
La cual representa a los pacientes de la clínica.
Cuenta con dos atributos para identificarlos: nombre y teléfono.
Cada atributo cuenta con un método getter para consultarlos, además de un método setter para cambiar el teléfono de ser necesario y un método toString para imprimir el valor de todos los atributos del objeto.
Clase Paciente:
La cual representa a las citas de la clínica.
Cuenta con 4 atributos para identificarlos: año, mes, día, hora. 
También cuenta con un atributo de tipo Paciente, en el cual se asignara el paciente que agende la cita.
Cada atributo cuenta con un método getter para consultarlos, un método setter para el atributo paciente y un método toString para imprimir el valor de todos los atributos del objeto.
También cuenta con un método llamado actualizar el cual sirve para reutilizar las citas si como un método llamado eliminarPaciente el cual sirve para vaciar el atributo.
Clase Sucursal:
La cual representa a las sucursales de la clínica.
Cuenta con un atributo nombre para identificarlas y un atributo cita el cual es un arreglo en el cual se guardarán las citas de un año en la sucursal. 
Cada atributo cuenta con un método getter para consultarlos.
Cuenta con métodos diseñados para buscar e imprimir los datos de las citas que cumplan con ciertos criterios de búsqueda.
También cuenta con métodos diseñados para modificar una cita del arreglo la cual cumpla con el criterio de búsqueda.
Por último, cuenta con un método el cual proporciona el objeto cita dentro del arreglo que cumpla con el criterio de búsqueda.
Clase Agenda:
Cuenta con 5 atributos, 2 de ellos listas en las cuales se guardarán las sucursales y los clientes respectivamente, también hay dos atributos que serán contadores para mantener el control de la cantidad de sucursales y pacientes respectivamente, el ultimo atributo, es un atributo de clase el cual sirve para monitorear si es la primera ves que se usa el programa.
Cada atributo cuenta con un método getter para ser consultado.
Cuenta con cuatro métodos (uno para agregar y uno para eliminar un objeto de cada uno de los arreglos).
Cuenta también con 3 métodos diseñados para modificar citas, así como 3 métodos para consultarlas mediante criterios de búsqueda específicos.

Relaciones entre clases.
Existe una relación de asociación entre la clase Paciente y la clase Sucursal, pues trabajan juntas sin depender una de la otra.
Hay una relación de composición entre la clase Cita y la clase Sucursal, pues las citas dependen de la existencia de una sucursal para existir.
Por último, hay tres relaciones de agregación:
Entre la clase Paciente y la clase Agenda pues se necesitan para trabajar, pero no para existir.
Entre la clase Paciente y la clase Cita pues una las citas trabajan en conjunto con los pacientes, pero no se necesitan para existir.
Entre la clase Sucursal y la clase Agenda pues la agenda necesita de las sucursales para trabajar sin embargo puede existir sin ellas.

 
MANEJO DE ERRORES
try:
utiliza la estructura try-with-resources. Esta estructura se utiliza para abrir recursos que necesitan ser cerrados de forma explícita, como flujos de entrada/salida o conexiones de red. 

catch:
 El bloque catch captura excepciones que puedan ocurrir durante el proceso de escritura. Si se produce una excepción, se imprimirá su pila de llamadas utilizando e.printStackTrace().

El uso de try-with-resources es una práctica recomendada, ya que garantiza que los recursos se cierren correctamente al final del bloque try, incluso en caso de excepción lo que es importante para la gestión adecuada de recursos que se cerrarán automáticamente, lo que evita posibles pérdidas de recursos o errores de lectura. 

CONCLUSIONES (Martínez Arévalo Carlos Alberto)
Es importante hacer un correcto manejo de errores a la hora de hacer uso de persistencia de objetos, algo que es necesario a la hora de realizar programas que no serán de un solo uso, y que necesitan almacenar información, para ejecuciones posteriores, lo cual facilita el uso del programa pues el usuario no debe realizar el proceso de inicio cada vez que use el programa.
CONCLUSIONES (Alonso Lorenzana Rolando Yiyari)
El manejo preciso de errores al aplicar la persistencia de objetos fue de gran importancia, especialmente cuando desarrollamos el anterior programa. La aplicacion necesitan la capacidad de preservar datos para su uso futuro, lo que conlleva la ventaja de simplificar el proceso de utilización. Esto se traduce en que los usuarios no deben repetir la fase inicial cada vez que deseen utilizar la aplicación y que esta sea mas intuitiva. 
