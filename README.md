# 99.7% Citric Liquid

## Description of my proyect (spanish)

Con el fin de facilitar la corrección del proyecto para el o la ayudante y dar explicaciones de 
las decisiones tomadas para la implementación de ciertos aspectos, escribo este apartado usando
español, esto último por comodidad. A continuación enumero ciertos puntos a recalcar en mi 
implementación:

- Cuando finaliza un combate no se reestablece el ataque del jugador que inicia el encuentro
- Los setters modifican el respectivo valor según su valor previo más un cierto incremento que recibe como argumento, 
no lo sustituye directamente
- Se utiliza una privacidad de `protected` en ciertas clases abstractas ya que utilizar `private` no es posible
- Combate en 2 jugadores no se separa en dos clases segun la decision del atacado para seguir el orden lógico
de un combate descrito en el enunciado
- Se hizo un esbozo de función para seleccionar una opción entre n opciones, para simular las desiciones
del jugador y las elecciones aleatorias de los wild units
- Para que un jugador pueda elegir un objetivo de norma se utilizó un método provisorio que toma por parametro
un string, que aunque no es un buen modelo, sirve para poder testear ambas clases norma segun objetivo



## About

`99.7% Citric Liquid` is a simplified clone of the renowned game, `100% Orange Juice`. Its main
purpose is to serve as an educational tool, teaching foundational programming concepts.

📢 **Note**: This project is purely educational and will not be used for any commercial purposes.

---

## For Students

The remainder of this README is yours to complete. Take this opportunity to describe your
contributions, the design decisions you've made, and any other information you deem necessary.



<div style="text-align:center;">
    <img src="https://i.creativecommons.org/l/by/4.0/88x31.png" alt="Creative Commons License">
</div>

This project is licensed under the [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

---