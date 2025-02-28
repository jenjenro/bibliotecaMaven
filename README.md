# Proyecto de Biblioteca

Este proyecto es una simulación de un sistema de gestión de recursos de una biblioteca. Permite agregar, buscar y eliminar diferentes tipos de recursos como lo son en este caso libros, periódicos y computadores.

## Funcionamiento del Proyecto

El proyecto está basado en la clase `Main` que realiza las siguientes acciones:

1. **Agregar Recursos**: Se crean instancias de diferentes recursos (libros, periódicos y computadores) y se agregan a la biblioteca.
2. **Listar Recursos**: Se imprime la lista de todos los recursos disponibles en la biblioteca.
3. **Buscar Recursos**: Se busca un recurso específico en la biblioteca utilizando un criterio de búsqueda.
4. **Eliminar Recursos**: Si se encuentra un recurso que coincide con el criterio de búsqueda, se elimina de la biblioteca.




### Clases Principales

- `ServicioBiblioteca`: Clase que gestiona los recursos de la biblioteca.
- `Recurso`: Clase abstracta que representa un recurso genérico.
- `Libro`: Clase que representa un libro.
- `Periodico`: Clase que representa un periódico.
- `Computador`: Clase que representa un computador.


### Ejecución

Para ejecutar el proyecto, use alguno de los siguientes comandos de Maven:


>mvn exec:java -Dexec.mainClass="co.edu.etitc.sistemas.programacion.Main"


>c: && cd c:\Users\rojas\OneDrive\Documentos\Universidad\ProgramacionIV\ejercicio-maven && cmd /C "C:\WorkSpace\jdk-21_windows-x64_bin\jdk-21.0.6\bin\java.exe -XX:+ShowCodeDetailsInExceptionMessages -cp C:\Users\rojas\OneDrive\Documentos\Universidad\ProgramacionIV\ejercicio-maven\target\classes co.edu.etitc.sistemas.programacion.Main "