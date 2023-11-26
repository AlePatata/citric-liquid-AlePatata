package cl.uchile.dcc.citric
package model.controller

abstract class AState extends State {
  var controller: GameController = _

  def newChapter(): Unit = {}

  //def isStart(t: T): Boolean = false

}
