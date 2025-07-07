# Sistema de Gestión de Tickets de Soporte (Java)

## Descripción
Este sistema permite gestionar tickets de soporte técnico, organizándolos por prioridad (Alta, Media y Baja) y registrando información como el ID del ticket, la descripción del problema y la fecha/hora de registro. Está diseñado para que el usuario pueda modificar la prioridad de sus tickets según lo prefiera, priorizando los más urgentes y facilitando una atención ordenada y eficiente.

---

## Tecnologías y requisitos
- Lenguaje: **Java**
- Uso de colecciones Java (`LinkedList`) para gestionar los tickets.
- Manejo de fechas y horas con la API `java.time` para registrar la fecha/hora de ingreso de cada ticket.
- Entorno recomendado: Visual Studio Code, IntelliJ IDEA o cualquier IDE para Java.
- JDK instalado (Java Development Kit) versión 8 o superior.

---

## Cómo compilar y ejecutar

Para compilar el proyecto, abre una terminal en la carpeta donde tienes los archivos `Main.java` y `Utils.java` y ejecuta:

```bash
javac -d bin Main.java Utils.java
```
Luego, para ejecutar el programa:

```bash
java -cp bin Main
```

---

## Estructura del código

- `Main.java`     # Programa principal con menú y control de flujo.
- `Utils.java`    # Funciones auxiliares como limpiar pantalla y pausa.
- `Ticket.java`   # Clase que representa un ticket con ID, descripción, prioridad y fecha.
- `Menu.java`     # Clase encargada de mostrar el menú principal.
- `TicketManager.java` # Clase con métodos para manejar la lista de tickets.

---

## Funcionalidades implementadas

- Registrar nuevos tickets con prioridad inicial **Bajo** y fecha/hora de ingreso automática.
- Cambiar la prioridad de un ticket existente a **Alto**, **Medio** o **Bajo**.
- Mostrar todos los tickets ordenados por prioridad y fecha de ingreso (los más prioritarios y antiguos primero).
- Procesar (eliminar y mostrar) el siguiente ticket según el orden de prioridad y antigüedad.
- Buscar un ticket por ID y mostrar sus detalles.
- Limpieza de pantalla y pausa para mejorar la experiencia en consola.

---

## Funcionalidades a mejorar

- Guardar y cargar tickets desde un archivo externo (por ejemplo, CSV o base de datos).
- Implementar interfaz gráfica o aplicación web.
- Añadir validaciones y manejo avanzado de errores.

---

## Ejemplo de uso

**Paso 1:** Registrar un nuevo ticket  
- Opción seleccionada: 1) Registrar Tickets  
- Ingrese el ID del ticket: 9436  
- Ingrese la descripción del ticket: Pantalla azul de Windows  
El sistema registra el ticket 9436 con prioridad "Bajo" y fecha/hora actual.

**Paso 2:** Asignar prioridad a un ticket  
- Opción seleccionada: 2) Asignar prioridad a los Tickets  
- Ingrese el ID del ticket: 9436  
- Ingrese la nueva prioridad (Bajo, Medio, Alto): Alto  
El sistema actualiza la prioridad del ticket 9436 a "Alto", asegurando que será atendido primero.

**Paso 3:** Mostrar lista de tickets pendientes  
- Opción seleccionada: 3) Mostrar lista de Tickets pendientes  
El sistema muestra todos los tickets ordenados, mostrando el ticket 9436 en la parte superior con prioridad alta y fecha de ingreso.

**Paso 4:** Procesar el siguiente ticket  
- Opción seleccionada: 4) Procesar siguiente Ticket  
El sistema muestra y elimina el ticket con mayor prioridad y antigüedad para ser procesado.

**Paso 5:** Buscar ticket por ID  
- Opción seleccionada: 5) Buscar Ticket por ID  
- Ingrese el ID del ticket: 9272  
El sistema muestra los detalles del ticket si existe, o un mensaje indicando que no fue encontrado.