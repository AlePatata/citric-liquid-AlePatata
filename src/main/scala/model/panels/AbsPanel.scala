package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

abstract class AbsPanel extends Panel {

  var characters: ArrayBuffer[PlayerCharacter]
  val nextPanels: ArrayBuffer[Panel]

  def addCharacter(player: PlayerCharacter): Unit = {
    characters += player
  }
  def removeCharacter(player: PlayerCharacter): Unit = {
    characters -= player
  }

  def addPanel(panel: Panel): Unit = {
    nextPanels += panel
  }

  def removePanel(panel: Panel): Unit = {
    nextPanels -= panel
  }

  /*def getNextPanels: ArrayBuffer[Panel] = {
    val aux = nextPanels
    aux
  }

  def setNextPanels(newNextPanels: ArrayBuffer[Panel]): Unit = {
    newNextPanels
  }*/
}
