package cl.uchile.dcc.citric
package model

import model.units.{PlayerCharacter, Units, WildUnit}


class WildCombat(attacker: PlayerCharacter, attacked: WildUnit) {
  attack(attacker, attacked)
  if(attacked.IsKO) {
    val stars = attacked.loose
    attacker.win(stars,1)
  } else {
    attack(attacked, attacker)
    if (attacker.IsKO) {
      val stars = attacker.loose
      attacked.setStars(stars)
    }
  }

  private def attack(attacker: PlayerCharacter, attacked: WildUnit): Unit = {
    val roll: Int = attacker.rollDice()
    attacker.setAttack(roll)
    val damage: Int = defend(attacker, attacked, roll)
    attacked.setHP(-damage)
  }

  private def attack(attacker: WildUnit, attacked: PlayerCharacter): Unit = {
    val damage: Int = defend(attacker, attacked)
    attacked.setHP(-damage)
  }

  private def defend(attacker: Units, attacked: Units, roll: Int = 0): Int = {
    val damage = math.max(1, roll + attacker.getAttack - attacked.getDefense)
    damage
  }
}

