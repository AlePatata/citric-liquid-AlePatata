# 99.7% Citric Liquid

## Description of my proyect (spanish)

Con el fin de facilitar la corrección del proyecto para el o la ayudante y dar explicaciones de 
las decisiones tomadas para la implementación de ciertos aspectos, escribo este apartado usando
español, esto último por comodidad. A continuación enumero ciertos puntos a recalcar en mi 
implementación:

- Se agregó una variable id en paneles, para diferenciar paneles con las mismas características
- La clase PlayerCharacter se usó como tipo
- Los traits Panel, WildUnit son usados como tipos
- La clase abstracta absPanel se usó para implementar la agregación y eliminación de personajes al panel

Elementos aún no correctamente desarrollados:
- Test de efectos de paneles ya que no sé como hacer un assertEquals para un valor que 
cambiará dependiendo de los numeros del dado (en dropPanel y bonusPanel) ni aun he terminado clases
como Combat que determinan el efecto de encounterPanel
- Tablero busca agrupar un conjunto de paneles, por ahora inicializa un orden aleatorio de turnos
- Partida contará Chapters y llevará a cabo el proceso de turnos
- Combat es una clase a la cual se instancia en un encounterPanel

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