# PRÁCTICA DEL MÓDULO CICLO DE VIDA DE UN DESARROLLO: CI/CD
### Autor: Aimar Lauzirika

## La Aplicación

Es una aplicación muy sencilla escrita en JAVA. Tiene establecido que la hora de ir a dormir es a las 23:00 y cada vez que se ejecuta te indica cuanto tiempo falta para ir a dormir. O si es más tarde que las 23:00 te dice que ya deberías estar en la cama.

## Jenkins

He utilizado la versión 2.387.1 de Jenkins en mi ordenador.

### Plugins

Tiene instalados los siguientes plugins:
- Docker
- Job DSL
- Docker commons
- Docker API
- docker-build-step
- Docker Slaves
- blue ocean
- green balls
- maven integration
- Docker pipeline
- MapDB api
- Config File Provider
- Parameterized Trigger
- Run Condition
- Conditional BuildStep
- Publish over SSH
- Environment Injector
- SSH Agent
- Git Parameter
- Pipeline Utility Steps
- Copy Artifact
- Rebuilder
- AnsiColor
- Docker
- Docker API
- Monitoring

### Configuración

La configuración de Jenkins es la de por defecto. La única configuración a tener en cuenta es 'Jenkins URL', si Jenkins está instalada en la máquina local, la URL por defecto 'http://localhost:8080/' es correcta, pero si se está ejecutando en otra máquina habría que sustituir la URL.

### Nodos/Agentes

En este proyecto se utilizan dos nodos externos. La información respecto a estos nodos y agentes se encuentre en este [documento](agents/nodo_jenkins.txt).

## El Proyecto

El proyecto consta en crear un pipeline de 'entrega continua' (continuous delivery) de una aplicación. Para ello he utilizado el plugin 'Blue Ocean' de Jenkins, ya que permite crear y editar el pipeline en un entorno gŕafico, y además subir los cambios al repositorio.

### Pipeline

El pipeline de este proyecto es un ejemplo de 'Continuous Delivery' y consta de los siguientes pasos:

- Clean (mvn clean): Para eliminar los artefaactos, ficheros, directorios, etc. creados durante el proceso.
- Build (mvn compile): Compila la aplicación. Para esta tarea se especifica el nodo con la version jdk11.
- Test (mvn test): Ejecuta los test de la aplicación. Para realizar los test se utiliza el nodo con la versión jdk 17. La razón por la que se utilizan distintos nodos es practicar la utilización de distintos nodos, no hay una razón específica en este ejercicio.
- Package: Primero genera los artefactos (mvn jar:jar)y después los guarda (Archive the artifacts). Es útil para no acumular artefactos en exceso configurar el pipeline desde Jenkins (en 'Discard old items') para eliminar automáticamente artefactos antiguos. Se pueden eliminar por días de antiguedad o que sólo guarde un número concreto de artefactos.
- Manual approval: La persona autorizada será la que podrá desplegar a producción o en su caso cancelar el despliegue de manera manual (Continuous Delivery). En este paso sería muy util que el pipeline envíe un aviso a dicha persona de que tiene la aprovación pendiente mediante un email u otro medio.
- Deploy in prod: Este paso simula un despliegue a producción, en este proyecto solamente imprime 'Simulating deployment in prod'.

Una configuración interesante que se le puede añadir al pipeline es que revise cada cierto tiempo si ha habido cambios en el repositorio. Para hacer esta configuración seleccionamos el pipeline desde Jenkins, y en `Scan Repository Triggers` activamos `Periodically if not otherwise run` y seleccionamos un intervalo.

#### Rama dev (COntinuous Deploy)

También he creado una segunda rama llamada `dev` en el que se omite el paso de `Manual approval` para que el despliegue sea completamente automático.

## Testing cada 30 minutos

En este proyecto se requiere que se ejecuten los test en la rama main cada 30 minutos. Para ello he utilizado un Job DSL, para lo cual se debe instalar el plugin `Job DSL` que está incluido en la lista de plugins de arriba.

Para crear un Job DSL tenemos que ir al Dashboard de Jenkins, crear nuevo item. Le ponemos un nombre, y seleccionamos `Freestyle project`.

Seleccionamos Git en `Source Code Management` y añadimos la URL del repositorio. Tambien especificar la rama del repositorio, hay que poner 'main' y no 'master' como rama, ya que en este proyecto la rama es 'main'.

En `Build step` seleccionamos `Process Job DSLs`, y activamos la opción `Use the provided DSL script` para introducir nuestro script:
```
job('Test-App') {
  scm {
    github('KeepCodingCloudDevops7/practica-cicd-AimarLauzirika', 'main')
  }
  triggers {
    scm('*/30 * * * *')
  }
  steps {
    maven('-e test')
  }
}
```
Con este código especificamos el scm (Source Code Management), cada que período se ejecuta (cada 30 minutos en este caso) y la tarea a ejecutar (en este caso utilizamos maven para realizar los test).

Tambien hay que tener en cuenta que detecta los cambios en scm y la tarea se ejecutará automáticamente en ese momento.

Una vez creado en Job DSL será necesario aprovar el scrip. Para ello, en `Manage Jenkins` entraremos en `In-process Script Approval` y clicaremos en `Approve` sobre nuestro script.

Ahora podremos ejecutar el cronjob creado y esto creará otro elemento en el dashboard que será la tarea que se ejecutará cada 30 minutos, y podremos consultar sus logs.