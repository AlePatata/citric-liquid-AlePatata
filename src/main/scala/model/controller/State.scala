package cl.uchile.dcc.citric
package model.controller

trait State {
  def newChapter(): Unit

  var controller: GameController
}
