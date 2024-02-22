# Tests unitarios con Webflux

El siguiente repositorio está creado para afianzar en la práctica del uso de pruebas unitarias en la programación reactiva con Webflux.


# ¿Tests unitarios?
El test unitario es la herramienta básica para demostrar que una función o método funciona como es esperado. Los tests unitarios no dependen de terceros debido a que su objetivo es validar el correcto funcionamiento de una tarea, mas no una integración completa. Para conseguir el correcto aislamiento en un test unitario se suele usar herramientas de *mocking* que nos permiten simular respuestas en base al tipo de prueba que estemos implementando.

# Testing con programación reactiva
Con ayuda de la librería reactor-test podemos hacer uso de un componente que nos permitirán realizar los tests unitarios en una método reactivo: **StepVerifier** 
**StepVerifier** nos permite realizar la validación de la ejecución del publisher de manera declarativa.

    testImplementation 'io.projectreactor:reactor-test:3.5.0'

##  StepVerifier

Utilizaremos StepVerifier para validar el comportamiento que tiene nuestro publisher al ser suscrito.
Dado el siguiente Mono:

    Mono<String> myMono = Mono.just("Hello World");

**.expectNext()**: nos permite hacer una comparación directa con el valor devuelto por onNext()

    StepVerifier.create(myMono)  
        .expectNext("Hello World")  
        .verifyComplete();
        

**.expectNextMatches()**: nos permite definir una expresión la cual valida el valor devuelto por onNext()

    StepVerifier.create(myMono)  
        .expectNextMatches(string -> string.startsWith("Hello"))  
        .verifyComplete();

De la misma manera se pueden utilizar estas funciones con el tipo Flux:

    Flux<String> myFlux = Flux.just("No","Trago","Entero");

    StepVerifier.create(myFlux)  
        .expectNext("No")  
        .expectNext("Trago")  
        .expectNext("Entero")  
        .verifyComplete();

**.expectNextCount()**: nos permite validar el conteo total de items que devuelve la función onNext()

    StepVerifier.create(myFlux)  
        .expectNextCount(3)  
        .verifyComplete();
        
        
Para validar si ocurrió un error la estructura del StepVerifier varía un poco. Al no completarse el flujo, se reemplaza el .verifyComplete por un .verify

    Mono<String> myMonoError = Mono.error(new RuntimeException());

**.expectError()**: nos permite validar que se haya hecho el llamado a onError()

    StepVerifier.create(myMonoError)  
        .expectError()  
        .verify();
El test puede ser más explicito si especificamos el tipo de error que estamos esperando

    StepVerifier.create(myMonoError)  
        .expectError(RuntimeException.class)  
        .verify();

En el caso de Flux, tengamos en cuenta los demás items enviados:

    Flux<String> myFluxError = Flux.just("No","Trago","Entero").concatWith(Flux.error(new RuntimeException()));


    StepVerifier.create(myFlux)  
        .expectNext("No")  
        .expectNext("Trago")  
        .expectNext("Entero")  
        .expectError()  
        .verify();


    StepVerifier.create(myFlux)  
        .expectNextCount(3)  
        .expectError()  
        .verify();
**.expectErrorMatches()**: nos permite definir una expresión la cual valida el valor devuelto por onError()

    StepVerifier.create(myMono)  
        .expectErrorMatches(throwable -> throwable instanceof RuntimeException)  
        .verify();


##  Caso práctico

En el presente repositorio se encuentra la carpeta example la cual contiene una serie de Monos y Fluxs. El objetivo es completar los tests unitarios solicitados utilizando las funciones previamente explicadas.
