# README #

## Deployment ##

Estando ubicado en la carpeta del proyecto GestacWeb en la consola. Correr el comando "mvn package".
Esto genera el war y lo pone en la carpeta webapps del tomcat.

Para generar el .jar de agentes, abrir el proyecto en intellij idea e ir a la opción Build -> Build Artifacts -> All Artifacts -> Rebuild.
Esto genera el gestac-agents.jar en la carpeta deploy/jar dentro del proyecto. Para correr el jar ir a la carpeta deploy/jar y ejectuar
java -jar gestac-agents.jar

Para ejecutar el .jar de agentes , ejecutar el gestac-run.bat que esta en el escritorio.

## Otros ##

Bajarse el repositorio de bitbucket:
Posicionarte en algun directorio donde quieras tener el repositorio en tu maquina y ejecutar:
**git clone https://nicogonzalez@bitbucket.org/nicogonzalez/gestac-web.git**

## Comandos git ##

- ** git status ** (para ver el estado del repositorio actual: cambios, eliminados, etc)
- ** git add . ** (esto es para agregar los cambios al repositorio)
- ** git commit -m "Acá describo brevemente lo que incluye el commit" ** (para commitear los cambios en el repositorio local)
- ** git pull origin master ** (para traer del repositorio los ultimos cambios)
- ** git push origin master ** (para subir los commits a el repositorio)

Previamente debes tener instalado git y creada una cuenta en https://bitbucket.org

## Set up ##

### Para que es el repositorio? ###

* Mantener versionado el código de gestacweb
* Poder compartir y centralizar entre team members el código

### Instalación de git en windows ###
Instalar Git en Windows es muy fácil. El proyecto msysGit tiene uno de los procesos de instalación más sencillos. Simplemente descarga el archivo exe del instalador desde la página de GitHub, y ejecútalo:

http://msysgit.github.com/
Una vez instalado, tendrás tanto la versión de línea de comandos (incluido un cliente SSH que nos será útil más adelante) como la interfaz gráfica de usuario estándar.

Nota para el uso en Windows: Se debería usar Git con la shell provista por msysGit (estilo Unix), lo cual permite usar las complejas líneas de comandos de este libro. Si por cualquier razón se necesitara usar la shell nativa de Windows, la consola de línea de comandos, se han de usar las comillas dobles en vez de las simples (para parámetros que contengan espacios) y se deben entrecomillar los parámetros terminándolos con el acento circunflejo (^) si están al final de la línea, ya que en Windows es uno de los símbolos de continuación.

### Base de datos ###
Es un MySQL. Despues te subo los scripts de creacion de base de datos asi tenes la BD local

### Dependencias ###
Estan todas manejadas con Maven, por lo que no hay que agregar las dependencias a mano en el proyecto

### Despliegue de webapp ###
Voy a subir en un folder war/ el último war generado para que puedas hacer el deploy en tu tomcat local