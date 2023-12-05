package cl.uchile.dcc.citric
package controller

import model.panels.{BonusPanel, DropPanel, EncounterPanel, HomePanel, NeutralPanel, Panel}

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class Tablero {
  private val centro = new BonusPanel(ArrayBuffer[PlayerCharacter](),ArrayBuffer[Panel]())
  centro.nextPanels += home3
  centro.nextPanels += home4

  val home1 = new HomePanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
    new NeutralPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
      new EncounterPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
        new DropPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](centro))
      ))
    ))
  ))
  val home2 = new HomePanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
    new EncounterPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
      new NeutralPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
        new DropPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](centro))
      ))
    ))
  ))
  val home3 = new HomePanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
    new NeutralPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
      new NeutralPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
        new DropPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](home1))
      ))
    ))
  ))
  val home4 = new HomePanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
    new EncounterPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
      new EncounterPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](
        new DropPanel(ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](home2))
      ))
    ))
  ))

  val mapa: List[Panel] = List(home1,home2,home3,home4)
}
