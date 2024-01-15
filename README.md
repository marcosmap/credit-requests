# credit-requests

## Instrucciones para levantar proyecto en docker

### Generar imagen docker
docker build -t your-docker-image-name:tag .
### Ejecutar la imagen generada en el paso anterior
docker run -p 8080:8080 your-docker-image-name:tag

## Para ingresar a la interfaz de Swagger

El proyecto ya está configurado con OpenAPI y la interfaz gráfica de Swagger para ver los endpoints documentados.

Ingresar al siguiente link después de ejecutar su aplicación o imagen docker: http://localhost:8080/swagger-ui/index.html

<img width="1512" alt="Screenshot 2024-01-15 at 11 33 02 a m" src="https://github.com/marcosmap/credit-requests/assets/69769751/5299a38f-d6ed-4761-8249-f06fc12b7119">

### Observaciones

1. Se utilizó una base de datos h2 para facilitar el proceso de desarrollo por lo que si se quiere ejecutar el proyecto y validar que se guarden, modifiquen y dispersen las solicitudes ingresar al siguiente link cuando el proyecto ya se esté ejecutando: http://localhost:8080/h2-console/
2. El puerto de todos los links en este documento puede variar dependiendo si se ejecuta una imagen docker, si es el caso y cambian el puerto, usar este último.
3. Se generaron un par de mocks para simular la extracción de información de solicitudes y estatus, en este caso utilicé un software llamado 'Mockoon'. Dentro del desarrollo se encuentran las conexiones a estos servicios simulados, sin embargo, no tendrá respuesta es por ello que se hacen las validaciones de existencia de infromación a la bd.
