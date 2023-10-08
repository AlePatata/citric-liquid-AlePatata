package cl.uchile.dcc.citric
package model

import scala.math

class Combat(attacker: PlayerCharacter, attacked: Units) {
  private val roll = attacker.rollDice()
  private val AttackedHP= attacked.getHP
  attacker.setAttack(roll)

  /*decision*/
  private val damage: Int = defend(attacker, attacked)
  /*private val damage: Int = evasion(attacker, attacked)*/

  if(damage >= AttackedHP){
    attacked.setHP(-AttackedHP)
  } else {
    attack(damage, attacked)
  }

  private def attack(damage:Int, attacked: Units): Unit = {
    attacked.setHP(-damage)
  }

  private def defend(attacker: PlayerCharacter, attacked: PlayerCharacter): Int = {
    val rollDef = attacked.rollDice()
    val damage = math.max(1, roll + attacker.getAttack - (rollDef + attacked.defense))
    damage
  }

  private def defend(attacker: PlayerCharacter, attacked: WildUnit): Int = {
    val damage = math.max(1, roll + attacker.getAttack - attacked.getDefense)
    damage
  }

  private def evade(attacker: PlayerCharacter, attacked: PlayerCharacter): Unit = {
    val rollEva = attacked.rollDice()
    if(rollEva + attacked.getEva > roll + attacker.getAttack) {
      val damage = 0
    } else {
      val damage = attacker.getAttack
    }
  }


}
/*
class Combat(attacker: PlayerCharacter, attacked: WildUnit) {
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
    val damage = math.max(1, roll + attacker.getAttack - attacked.defense)
    damage
  }
}