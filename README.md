# Descripción:

La máquina a la fecha no dispone de un mecanismo de autenticación para las tareas de administración. Por tal motivo, se requiere restringir las funcionalidades adicionar inventario y gestionar las monedas de pago.

## Criterios de aceptación:

### Métodos de autenticación
Dado que requiero diferentes alternativas de autenticación

Cuando vaya a loguearme

Entonces el sistema debe brindarme 3 alternativas: con usuario contraseña, con pin o con redes sociales.

### Usuario administrador
Dado que es el primer inicio de la maquina 

Cuando se realize el primer acceso  con usuario y contraseña 

Entonces se podra realizara el inicio con una cuenta por defecto de administrador almacenada en el sistema 
con usuario: 4dm1nv y contraseña: V3nd1Ma5h

### Autenticación no implementada
Dado que es la versión inicial

Cuando escoja las opciones de autenticación de Pin o redes sociales

Entonces el sistema debe indicarme que no están implementadas aún

### Autenticación con usuario- contraseña
Dado que debo realizar la gestión de inventarios

Cuando ingrese usuario y contraseña correctos

Entonces el sistema debe mostrarme las opciones restringidas (gestionar inventario, gestionar monedas o billetes).

### Creacion de usuarios
Dado que se necesita crear usuarios

Cuando almacene los datos del usuarios

Entonces el sistema deva validar que la contraseña tenga un minimo de 8 carcteres, contena minimo una letra mayusculas y 
minimo una letra minusculas, contega un numero.


### Bloqueo del usuario
Dado que se requiere un mecanismo anti bots

Cuando el usuario ingrese 3 veces la contraseña y/o usuario incorrecto

Entonces el sistema debe bloquear al usuario mostrando el mensaje: “usuario bloqueado. Contacte al administrador”


Funcionalidades sin restricción
Dado que requiero funcionalidades sin restricción

Cuando Acceda a la maquina en condiciones iniciales

Entonces el sistema debe permitir utilizar funcionalidades sin restricción como consultar los productos

