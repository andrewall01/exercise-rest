## Despliegue de apps Spring Boot en Heroku

Crear el archivo `system.properties` en proyecto con el contenido(la versión varia de acuerdo a la versión que se esté utilizando):
```
java.runtime.version=11 
```

1. Crear cuenta en heroku.com
2. Tener configurado git en ordenador(Ejecutar sólo la primera vez que se instala git):
   1. `git config --global user.name "nombre apellido"`
   2. `git config --global user.email "ejemplo@email.com"`
3. Subir el proyecto a GitHub desde Intellij IDEA desde la opción: VCS -> Share project on GitHub
4. Desde Heroku, crear app y elegir método GitHub y buscar el repositorio subido
5. Habilitar deploy automático y ejecutar el Deploy

## Ejercicio 1
* Probar a empaquetar la aplicación con maven package desde Intellij IDEA
* Desde terminal en Intellij IDEA verificar que se ejecta correctamente con el comando:
```
java -jar target/exercise-rest-0.0.1-SNAPSHOT.jar
```
* Crear un perfil para dev y otro para test

## Ejercicio 2

* Despliegue el API REST de Laptops en Heroku y verificar funcionamiento desde POSTMAN.

## Proveedores Cloud
* Heroku -- Java, Spring, PostgreSQL
* Netlify -- FrontEnd(React, Angular, ...)
* Vercel -- FrontEnd(React, Angular, ...)
