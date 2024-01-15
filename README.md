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
