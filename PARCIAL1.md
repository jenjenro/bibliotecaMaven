# 1. Diferencias entre @Component y @Configuration en Spring

En Spring, tanto @Component como @Configuration son anotaciones importantes, pero tienen propósitos diferentes:

## @Component
Propósito: Es una anotación genérica que se utiliza para marcar una clase como un componente de Spring. Cualquier clase anotada con @Component será detectada automáticamente durante el escaneo de componentes y registrada como un bean en el contexto de Spring.

### Uso común:
 Se utiliza para clases que representan componentes generales, como servicios, repositorios o controladores. Spring también proporciona anotaciones especializadas derivadas de @Component, como @Service, @Repository y @Controller. 

## @Configuration
Propósito: Es una anotación que indica que la clase es una clase de configuración de Spring. Estas clases contienen métodos anotados con @Bean que definen beans que se registrarán en el contexto de Spring.


### Uso común:
 Se utiliza para configurar beans de manera programática, especialmente cuando la configuración no puede realizarse mediante anotaciones automáticas (como @Component). También se usa para definir configuraciones complejas o personalizadas.

## Ejemplo práctico  

package co.edu.etitc.sistemas.programacion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEjemplo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Persona persona = context.getBean(Persona.class);
        System.out.println(persona.presentarse("Juan"));
    }
}
------

package co.edu.etitc.sistemas.programacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Marca esta clase como un componente de Spring
public class Persona {

    private final Saludo saludo;

    @Autowired // Inyecta la dependencia a través del constructor
    public Persona(Saludo saludo) {
        this.saludo = saludo;
    }

    public String presentarse(String nombre) {
        return saludo.saludar(nombre) + " Soy una persona.";
    }
}
------ 

package co.edu.etitc.sistemas.programacion;

import org.springframework.stereotype.Component;

@Component // Marca esta clase como un componente de Spring
public class Saludo {
    public String saludar(String nombre) {
        return "Hola, " + nombre + "!";
    }
}
------
### Explicación del flujo

Detección de componentes:

Spring escanea el paquete co.edu.etitc.sistemas.programacion en busca de clases anotadas con @Component.
@Component Marca las clases como beans gestionados por Spring
En este caso: 
Detecta las clases Saludo y Persona y las registra como beans en el contexto de la aplicación.

Inyección de dependencia:

Cuando Spring crea el bean de Persona, detecta que necesita una instancia de Saludo (por el constructor anotado con @Autowired). @Autowired Indica que Spring debe inyectar la dependencia automáticamente.

Spring busca en su contexto una instancia de Saludo y la inyecta automáticamente en el constructor de Persona.

Uso de la dependencia:

En el método presentarse, la clase Persona utiliza la instancia de Saludo para saludar y luego añade un mensaje adicional.

Ejecución:

En la clase MainEjemplo, se crea un contexto de Spring usando AnnotationConfigApplicationContext.

Luego, se obtiene el bean Persona del contexto y se llama a su método presentarse, que utiliza la dependencia inyectada (Saludo).

@Configuration y @ComponentScan Configuran el escaneo de componentes y la creación del contexto de Spring.

# Principio de Inversión de Control (IoC) y su Aplicación en la Solución

## ¿Qué es el Principio de Inversión de Control (IoC)?

El **principio de inversión de control (IoC)** es un patrón de diseño en el que el flujo de control de un programa se invierte. En lugar de que el programa controle la creación y gestión de objetos, un framework o contenedor (como Spring) se encarga de ello. Esto permite desacoplar las responsabilidades y hace que el código sea más modular, mantenible y testeable.

---

## ¿Cómo se Aplica el IoC en esta Solución?

En la solución desarrollada, el principio de inversión de control se aplica a través de **Spring** de las siguientes maneras:

### 1. **Gestión de Dependencias**
En lugar de crear manualmente instancias de `ComputadorRepositorio`, `PeriodicoRepositorio` o cualquier otra clase, Spring se encarga de crear y gestionar estas instancias. Esto se logra mediante la anotación `@Component`, que le indica a Spring que debe gestionar la clase como un bean.

### 2. **Inyección de Dependencias** 
La inyección de dependencias es una forma específica de aplicar el IoC. En lugar de que una clase cree sus propias dependencias, estas se le proporcionan desde el exterior (en este caso, desde Spring).

### 3. **Configuración Automática de Beans**
Spring utiliza la anotación @ComponentScan para escanear automáticamente las clases anotadas con @Component, @Service, @Repository, etc., y las registra como beans en el contexto de la aplicación.

### 4. **Inversión del Flujo de Control**
En un enfoque tradicional, el desarrollador controla el flujo del programa, incluyendo la creación de objetos y la gestión de dependencias.

# Ejemplo de cómo se pueden combinar los resultados de múltiples repositorios en el método obtenerTodos().

Implementación del Método obtenerTodos()

public Collection<Recurso> obtenerTodos() {
    List<Recurso> todosLosRecursos = new ArrayList<>();

    // Agregar todos los libros
    todosLosRecursos.addAll((Collection<? extends Recurso>) repositorioLibros.obtenerTodos());

    // Agregar todos los periódicos
    todosLosRecursos.addAll((Collection<? extends Recurso>) repositorioPeriodicos.obtenerTodos());

    // Agregar todos los computadores
    todosLosRecursos.addAll((Collection<? extends Recurso>) repositorioComputadores.obtenerTodos());

    return todosLosRecursos;
}

## Explicación del Código
Creación de una lista vacía:

1. Se crea una lista vacía de tipo List<Recurso> llamada todosLosRecursos.

2. Agregar recursos de cada repositorio:

3. Libros: Se obtienen todos los libros del repositorioLibros usando obtenerTodos() y se agregan a la lista todosLosRecursos.

4. Periódicos: Se obtienen todos los periódicos del repositorioPeriodicos usando obtenerTodos() y se agregan a la lista todosLosRecursos.

5. Computadores: Se obtienen todos los computadores del repositorioComputadores usando obtenerTodos() y se agregan a la lista todosLosRecursos.

6. Retorno de la lista combinada:

7. Finalmente, se retorna la lista todosLosRecursos, que contiene todos los recursos de los tres repositorios.


# Explicación de la inyección de propiedades en Spring

## Cómo funciona @Value
La anotación @Value se usa para inyectar valores de propiedades en campos de un componente de Spring.

El valor puede provenir de varias fuentes, como archivos de propiedades (application.properties), variables de entorno, parámetros de línea de comandos, etc.

El formato básico es @Value("${nombre.propiedad}"), donde nombre.propiedad es la clave de la propiedad.

Precedencia de las fuentes de propiedades
Spring sigue un orden de precedencia al resolver propiedades. Aquí está el orden de mayor a menor precedencia:

Propiedades de línea de comandos:

Ejemplo: java -jar app.jar --app.name="".

Tienen la mayor precedencia.

Variables de entorno:

Ejemplo: export APP_NAME="".

Se usan si no se encuentran propiedades en la línea de comandos.

Archivos de propiedades externos:

Ejemplo: application.properties en un directorio externo.

Se usan si no se encuentran propiedades en las fuentes anteriores.

Archivos de propiedades internos:

Ejemplo: application.properties en src/main/resources.

Se usan si no se encuentran propiedades en las fuentes anteriores.

Valores por defecto en @Value:

Ejemplo: @Value("${app.name:Default App}").

Se usa si no se encuentra la propiedad en ninguna de las fuentes anteriores.