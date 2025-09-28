IMPORTANTE.
El proyecto usa Maven para la gestión de dependencias.
Se usa org.json, librería que nos permite trabajar la gestión de JSON

A continuación haremos la definición de conceptos.
identificando cuáles serán los más adecuados para el producto destinado al sector financiero y de tipo web.

HashMap:  Estructura de datos que almacena llave-valor, por lo general su llave suele ser un dato entero (int) y su valor una cadena de texto, aunque esta estructura acepta los distintos tipos de datos tanto en llave como en su valor.
ConcurrentHashMap:  Estructura de datos que almacena llave-valor.
Diferencia entre HashMap y ConcurrentHashMap:   Su principal diferencia es el hilo seguro, de modo que ConcurrentHashMap permite acceso concurrente al mapa por lo que si en algún lado modifican uno de sus valores no afecte el resto de las operaciones o transacciones.
Estos datos en proyectos web suelen llevarse a tablas tercerizadas en la base de datos, de modo que las transacciones siempre cuenten con los valores actualizados.

List: Colección ordenada de algún tipo de dato o clase, con su respectivo índice, permite registros duplicados gracias al índice.
Set: Colección no ordenada de algún tipo de dato o clase, no permite registros duplicados dado que no maneja índice.
Map:  Colección ordenada por llave – valor, no permite llaves duplicadas que sería lo más similar al índice.

Diferencia entre List, Set y Map: La diferencia principal es el enfoque de la colección, si se requiere tener registros duplicados o no, ejemplo:
Para un historial de acceso o consultas sería conveniente usar una lista ya que permite registros duplicados.

¿Qué es un Optional en Java y para qué sirve?
Un opcional es una clase que nos permite manejar los valores nulos en algunas funciones o procesos de forma que evitemos uno de los errores más comunes en Java, el NullPointerException.

¿Cómo manejarías excepciones en un servicio que accede a base de datos?
Plantear una buena practica para capturar y emitir las excepciones. Inicialmente usar try-catch. Al momento de lanzarlas dividirlas en varios tipos:
No acceso a la base de datos en caso de que nuestro servicio, contenedor o prestador de base de datos no este disponible.
Error en los datos enviados a la entidad, si estamos probando desde postman porque lo ideal es garantizar datos higiénicos desde el cliente web.
Estos mensajes deben ser personalizados de modo que sean entendibles al usuario, evitar palabras técnicas o emitir el mensaje tal cual del servidor.
Por otro lado, capturar los verdaderos errores en el log y los detalles de ellos mismos.

¿Qué diferencia hay entre @Component, @Service y @Repository en Spring?
La diferencia entre estos tres es su propósito y nivel de jerarquía, además de que todos trabajan en conjunto, dentro de las buenas practicas no es posible decir que se puede reemplazar uno por el otro.
@Component: Define funcionalidades o utilidades generales o para una entidad en específico, un ejemplo general puede ser pasar un texto a mayúsculas o minúsculas, mientras que un ejemplo específico puede ser retornar la edad de una persona.
La funcionalidad de convertir texto puede ser usada por cualquier entidad del sistema mientras que devolver edad solamente por entidades que tengan una propiedad fechaNacimiento.
@Service: Define los métodos que se van a realizar sobre la entidad, este hace uso del repositorio para acceder a la información, modificarla o registrarla.
@Repository: Define la conexión entre un repositorio, entidad y entidad de la base de datos. Este nos permite acceder y gestionar la información de la base de datos.  
