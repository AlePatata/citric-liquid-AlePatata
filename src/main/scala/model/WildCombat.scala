package cl.uchile.dcc.citric
package model

import model.units.{PlayerCharacter, Units, WildUnit}


class WildCombat(attacker: PlayerCharacter, attacked: WildUnit) {
  val roll: Int = attacker.rollDice()
  attacker.setAttack(roll)
  private val damage: Int = defend(attacker, attacked)
  attack(damage, attacked)
  if(!attacked.IsKO) {
    val damage = attacked.getAttack
    attack(damage, attacker)
    if(attacker.IsKO) {
      bonus(attacked,attacker)
    }
  } else {
    bonus(attacker,attacked)
  }

  private def attack(damage: Int, attacked: Units): Unit = {
    val AttackedHP = attacked.getHP
    if (damage > AttackedHP) {
      attacked.setHP(-AttackedHP)
    } else {
      attacked.setHP(-damage)
    }
  }

  private def defend(attacker: PlayerCharacter, attacked: WildUnit): Int = {
    val damage = math.max(1, roll + attacker.getAttack - attacked.getDefense)
    damage
  }

  private def bonus(Winner: PlayerCharacter, Looser: WildUnit): Unit = {
  val stars = Looser.getStars
  Winner.setStars(stars + Looser.getBonus)
  Looser.setStars(-stars)
  Winner.setVictories(1)
  }

  private def bonus(Winner: WildUnit, Looser: PlayerCharacter): Unit = {
    val stars = Looser.getStars / 2
    Winner.setStars(stars)
    Looser.setStars(-stars)
  }
}

