package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/** This class will organizate and inicialize the map of the game
 *
 * @param size is the amount of panels
 * @param Characters array of players characters on the game
 */
class Tablero(size: Int, Characters: ArrayBuffer[PlayerCharacter]) {
  /** This function sort the order of the players
   *
   * This is going to determinate the turns in the entire Partida
   * @param Characters is the list of characters which will play
   */
  /*def inicializate(Characters: ArrayBuffer[PlayerCharacter]): Unit = {
    n: Random = new Random()
    next = n.nextInt(4)
    turns: ArrayBuffer[PlayerCharacter]
    for(i: Int = 0, i<4, i++){
      turns += Characters(next)
      Characters -= Characters(next)
      next = n.nextInt(3-i)
    }
    Partida.Play(turns)
  }

  /** Assigns the home Panel of each Character
   * @param player The character whose the home panel is to be assigned
   * @return The home panel
   */
  def begin(player: PlayerCharacter) : Panel {
    player.position = homePanel
  }*/

}