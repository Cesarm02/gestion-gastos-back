#language: es

@APIUSERS
Característica: Validación de API usuarios

  Antecedentes: Generación de token para servicios API User
    Dado que Juan necesita obtener un token para autenticarse de forma exitosa
    Entonces  deberá consumir obtener un token de forma correcta

@POST
Escenario: Agregar exitosamente un usuario
Dado que Juan desea utilizar la API de usuarios
Cuando el quiera agregar un usuario:
|nombre|apellido|email|activo|edad|username|
|Juan     |Gutierrez|juangoxx@hotmail.com|1|24|juangoxx|
|Steven     |Laguna|laguna@hotmail.com|0| 23  |tatuco|
|Cleo     |Gutierrez|cleo@hotmail.com|1|  22  |cleo|
Entonces debería poder hacerlo

@GETALL
Escenario:  Consultar todos los estudiantes
Dado que Juan desea utilizar la API de usuarios
Cuando el quiera consultar todos los estudiantes
Entonces debería ver una lista con cada estudiante

@DELETE
Escenario: Eliminar estudiante
Dado que Juan desea utilizar la API de usuarios
Cuando el quiera eliminar el estudiante con el id 1
Entonces no deberá ver más ese estudiante al consultarlo nuevamente

@GETID
Escenario: Consultar estudiante por id
Dado que Juan desea utilizar la API de usuarios
Cuando el quiera consultar un estudiante por id
Entonces deberá obtener la información de ese estudiante
