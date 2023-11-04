package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.math

class Combat(attacker: PlayerCharacter, attacked: PlayerCharacter) {

  attack(attacker, attacked)

  if (attacked.IsKO) {
    val stars = attacked.loose
    attacker.win(stars,2)
  } else {
    attack(attacked, attacker)
    if (attacker.IsKO) {
      val stars = attacker.loose
      attacked.win(stars, 2)
    }
  }

  private def attack(attacker: PlayerCharacter, attacked: PlayerCharacter): Unit = {
    val roll = attacker.rollDice()
    attacker.setAttack(roll)
    /*decision*/
    val damage: Int = defend(attacker, attacked, roll)
    /*val damage: Int = evade(attacker, attacked, roll)*/
    attacked.setHP(-damage)
  }

  private def defend(attacker: PlayerCharacter, attacked: PlayerCharacter, attackerRoll: Int): Int = {
    val attackedRoll = attacked.rollDice()
    val damage = math.max(1, attackerRoll + attacker.getAttack - (attackedRoll + attacked.getDefense))
    damage
  }

  private def evade(attacker: PlayerCharacter, attacked: PlayerCharacter, attackerRoll: Int): Int = {
    val attackedRoll = attacked.rollDice()
    var damage = 0
    if (attackedRoll + attacked.getEva <= attackerRoll + attacker.getAttack) {
      damage = attacker.getAttack
    }
    damage
  }
}


