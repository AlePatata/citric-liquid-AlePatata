# 99.7% Citric Liquid

## Description of my proyect (spanish)

Con el fin de facilitar la corrección del proyecto para el o la ayudante y dar explicaciones de 
las decisiones tomadas para la implementación de ciertos aspectos, escribo este apartado usando
español, esto último por comodidad. A continuación enumero ciertos puntos a recalcar en mi 
implementación:

- startGame() en GameController transisiona al state PreGame, donde se arman los turnos (en un Map) y 
configuran los observers
- Los observers tienen como subject a los jugadores y notifican al controlador si se alcanza el nivel
necesario para terminar el juego definido en el mismo controlador
- startRounds() en GameController inicia el loop para las rondas de turnos
- Definí chapter como un atributo en controlador para poder acceder facilmente a él en varias funciones de los states
- Asumí que un jugador noqueado igualmente recibe estrellas al iniciar un chapter nuevo 
- Creé una clase tablero que controlador usa como tablero predeterminado y tiene la particularidad de ser
un tablero en donde para cada panel su lista de paneles siguientes tiene uno o dos elementos,
por lo que genera un loop infinito
- Decidí definir por defecto que si un jugador se topaba con otro en el mismo panel siempre se iniciara un combate
- Por la implementación que utilicé en Combat, prescindí del state Wait
- Debido a la modalidad que utilicé en las transiciones para hacer el flujo del juego
no agregué más test de los necesarios
- No especifiqué una cantidad fija de jugadores para posibles nuevas implementaciones si se quisisese



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