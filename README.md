## Más alto 3

## Descripción del proyecto
El sistema tiene como propósito principal gestionar un mundo de magia en el que distintos magos dominan una variedad de hechizos pertenecientes a diferentes elementos. Cada mago posee una colección de uno o más hechizos, los cuales cuentan con características y atributos particulares según su tipo: Fuego, Tierra, Planta o Agua.

El sistema permitirá administrar tanto los magos como los hechizos mediante un panel de Administrador, donde será posible agregar, modificar y eliminar información. Además, contará con un panel de Analista encargado de generar reportes y rankings, permitiendo identificar los hechizos más poderosos y los magos con mejor desempeño según las puntuaciones obtenidas.

Se utilizarán archivos de texto para almacenar toda la información relacionada con los magos y hechizos. Los datos se cargarán automáticamente al iniciar la aplicación, y cualquier modificación realizada por el usuario se reflejará en los archivos correspondientes, garantizando la persistencia de la información y permitiendo conservar los cambios entre distintas ejecuciones del sistema.

El sistema será desarrollado utilizando Programación Orientada a Objetos (POO), implementando una estructura basada en herencia e interfaces. Existirá una clase abstracta Hechizo que servirá como base para los distintos tipos de hechizos, mientras que las clases Fuego, Tierra, Planta y Agua incorporarán atributos y comportamientos específicos según las reglas definidas para cada elemento.

Para gestionar la información, el sistema almacenará los distintos hechizos y los que domina cada mago en ArrayList, permitiendo organizar y acceder a estos datos de manera eficiente. Además, estará estructurada de forma ordenada, separando las funciones principales del sistema de la ejecución del programa.

Dentro de las funcionalidades principales se incluirá el cálculo automático de puntuaciones para cada hechizo mediante fórmulas específicas asociadas a su elemento. A partir de estas evaluaciones se calculará la puntuación total de cada mago, obtenida mediante la suma de los puntajes de todos los hechizos que domina. Esta información será utilizada para generar rankings como el Top 10 Mejores Hechizos y el Top 3 Mejores Magos.

Finalmente, se aplicaran conceptos fundamentales de programación, manejo de archivos, persistencia de datos, arreglos y diseño orientado a objetos, desarrollando un sistema funcional que permita administrar y analizar un universo mágico compuesto por magos y hechizos de distintos elementos.

## Integrantes
- Nombre Completo: Diego Nikolas Serrano Fuentes 
  - RUT: 22.105.561-6 
  - GitHub: diegoserrano-cloud

- Nombre Completo: Josselyn Alejandra Barraza Yáñez
  - RUT: 22.246.539-7
  - GitHub: josselynbarraza-sys

## Estructura del proyecto
- Taller3_DiegoSerrano_JosselynBarraza
    - src
        - dominio 
            - Agua.java 
            - Fuego.java
            - Hechizo.java # Clase abstract 
            - Mago.java
            - Planta.java
            - Tierra.java
        - logica
            - App.java # Clase principal que contiene toda la logica detrás del juego
            - Sistema.java #Interfaz que separa las funcionalidades de la App
            - SistemaImple.java #implementación de la Interfaz será el encargado de crear, modificar, hacer calculos con los objetos
        - module-info.java
    - .classpath
    - .proyecto
    - Hechizos.txt
    - Magos.txt
    - README.md
## Instrucciones
  - Requisitos previos
    - Java JDK 11 o superior instalado
    - Tener algún IDE instalado compatible con java, por ejemplo, Eclipse IDE o Visual Studio Code.
   
  - Instrucciones de ejecución
    - Importar el proyecto dentro del IDE seleccionado.
    - Seleccionar la carpeta src -> package "Logica" -> Clase "App".
    - Una vez dentro buscar el boton de "Play".
    - Disfrutar del juego :D
