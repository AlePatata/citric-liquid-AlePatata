package cl.uchile.dcc.citric
package model.norma

import model.units.PlayerCharacter

trait Norma {
  protected var level: Int
  def getLevel: Int
  def setLevel(Level: Int): Unit
  def NormaCheck(playerCharacter: PlayerCharacter): Unit
}
