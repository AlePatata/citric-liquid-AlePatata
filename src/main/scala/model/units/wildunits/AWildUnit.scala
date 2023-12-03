package cl.uchile.dcc.citric
package model.units.wildunits

import model.units.AUnits

abstract class AWildUnit extends AUnits with WildUnit {
  def respawn(): Unit = {
    this.setStars(0)
    this.setHP(this.maxHP)
  }

  def loose: Int = {
    val stars = this.getStars
    this.setStars(-stars)
    val Loose = stars + this.bonus
    this.respawn()
    Loose
  }

}
