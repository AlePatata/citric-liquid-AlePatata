package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

/** Partida is the enviroment in which the game will take place
 *
 */
class Partida {
  /*var Chapter = 1

  /** Play begins the process of turns, Chapters and Character movements
   *
   * @param Characters Is the orderer array of characters according to the turns
   */
  def Play(Characters: ArrayBuffer[PlayerCharacter]){
    n: Int = Characters.size
    player = Characters(0)
    for(Chapter, Chapter<5, Chapter++) {
      i: Int = 0
      while(i < n){
        roll : Int = player.rollDice
        for(mov: Int = 0, mov < roll, mov++) {
          player.position.removeCharacter(player)
          player.position = player.position.nextPanels(player.choose(player.position.nextPanels.size))
        } player.position.effect(player)
        if (player.norma == 6) {
          i = n
          Chapter = 5
        } i++
        player = Characters(i)
      }
    }
  }*/
}