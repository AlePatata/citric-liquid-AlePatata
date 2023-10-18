package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.math

class Combat(attacker: PlayerCharacter, attacked: PlayerCharacter) {
  private val roll = attacker.rollDice()
  private val AttackedHP = attacked.getHP
  attacker.setAttack(roll)

  /*decision*/
  private val damage: Int = defend(attacker, attacked: PlayerCharacter)
  /*private val damage: Int = evasion(attacker, attacked)*/

  if (damage >= AttackedHP) {
    attacked.setHP(-AttackedHP)
  } else {
    attack(damage, attacked)
  }

  private def attack(damage: Int, attacked: PlayerCharacter): Unit = {
    attacked.setHP(-damage)
  }

  private def defend(attacker: PlayerCharacter, attacked: PlayerCharacter): Int = {
    val rollDef = attacked.rollDice()
    val damage = math.max(1, roll + attacker.getAttack - (rollDef + attacked.defense))
    damage
  }


  private def evade(attacker: PlayerCharacter, attacked: PlayerCharacter): Unit = {
    val rollEva = attacked.rollDice()
    if (rollEva + attacked.getEva > roll + attacker.getAttack) {
      val damage = 0
    } else {
      val damage = attacker.getAttack
    }
  }
}


