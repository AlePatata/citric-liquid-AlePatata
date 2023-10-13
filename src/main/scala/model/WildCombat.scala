package cl.uchile.dcc.citric
package model

import model.Units.{PlayerCharacter, WildUnit}


class WildCombat(attacker: PlayerCharacter, attacked: WildUnit) {
  val roll: Int = attacker.rollDice()
  private val AttackedHP = attacked.getHP
  attacker.setAttack(roll)

  /*decision*/
  private val damage: Int = defend(attacker, attacked)
  /*private val damage: Int = evasion(attacker, attacked)*/

  if (damage >= AttackedHP) {
    attacked.setHP(-AttackedHP)
  } else {
    attack(damage, attacked)
  }

  private def attack(damage: Int, attacked: WildUnit): Unit = {
    attacked.setHP(-damage)
  }

  private def defend(attacker: PlayerCharacter, attacked: WildUnit): Int = {
    val damage = math.max(1, roll + attacker.getAttack - attacked.getDefense)
    damage
  }
}

