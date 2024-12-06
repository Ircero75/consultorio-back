# consultorio-back
Prueba Tecnica sobre Consutorios Medicos para la empresa Kronos

### Inicializar el proyecto

Por medio de una terminal posicionarse en la raiz del proyecto
Ejecutar el siguiente comando para compilar el proyecto y descargar las dependencias necesarias

mvn -U clean install -DskipTests

Poscionarse en la ruta target
Para levantar el proyecto ejecutar el siguiente comando
java -jar consultorios-medicos-0.0.1-SNAPSHOT.jar

## Visualizar la BD H2
Una vez levantado el proyecto entrar a la siguiente url desde un navegador web
http://localhost:8090/h2-console/

Los datos de conexion son los siguientes

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: