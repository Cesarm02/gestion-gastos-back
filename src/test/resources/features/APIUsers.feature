#language: es

@APIUSERS
Característica: Validación de API usuarios

@POST
Escenario: Agregar exitosamente un usuario
Dado que Juan desea utilizar la API de usuarios
Cuando el quiera agregar un usuario:
|nombre|apellido|email|telefono|edad|username|password|
|Juan     |Gutierrez|juangoxx@hotmail.com|123456|24|juangoxx|juan|
|Steven     |Laguna|laguna@hotmail.com|12345| 23  |tatuco| steven  |
|Cleo     |Gutierrez|cleo@hotmail.com|1234567|  22  |cleo| cleo  |
Entonces debería poder hacerlo

@GETALL
Escenario:  Consultar todos los estudiantes
Dado que Juan desea utilizar la API de usuarios
  Y se autentico correctamente
Cuando el quiera consultar todos los estudiantes
Entonces debería ver una lista con cada estudiante

@DELETE
Escenario: Eliminar estudiante
Dado que Juan desea utilizar la API de usuarios
  Y se autentico correctamente
Cuando el quiera eliminar el estudiante con el id 1
Entonces no deberá ver más ese estudiante al consultarlo nuevamente

@GETID
Escenario: Consultar estudiante por id
Dado que Juan desea utilizar la API de usuarios
  Y se autentico correctamente
Cuando el quiera consultar un estudiante por id
Entonces deberá obtener la información de ese estudiante
