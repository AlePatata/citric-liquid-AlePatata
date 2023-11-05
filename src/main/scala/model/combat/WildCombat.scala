package cl.uchile.dcc.citric
package model.combat

import model.units.{PlayerCharacter, Units, WildUnit}

/** A wild combat is an event in which a player character and a wild unit face a duel
 *
 * @param attacker the player that decide to attack to the attacked
 * @param attacked the victim of the attack
 */
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

  /** The attack performs the following sequence of instructions::
   * modifies the attacker's attack using his/her dice
   * ask for the decision of the attacked to defend or evaded him/herself
   * -applies the resulting damage
   */
  private def attack(attacker: PlayerCharacter, attacked: WildUnit): Unit = {
    val decision = attacker.choose(2)
    var damage = 0
    if (decision == 0) damage = defend(attacker, attacked)
    else damage = evade(attacker, attacked)
    attacked.setHP(-damage)
  }

  /** The attack performs the following sequence of instructions::
   * -modifies the attacker's attack
   * -ask for the decision of the attacked to defend or evaded him/herself
   * -applies the resulting damage
   */
  private def attack(attacker: WildUnit, attacked: PlayerCharacter): Unit = {
    val decision = attacker.choose(2)
    var damage = 0
    if(decision == 0) damage = defend(attacker, attacked, attacked.rollDice())
    else damage = evade(attacker,attacked, attacked.rollDice())
    attacked.setHP(-damage)
  }

  /** The respective unit defends him/herself reducing the damage that corresponds him/her
   *
   * @param attacker     the player that decide to attack to the attacked
   * @param attacked     the victim of the attack
   * @param roll the previous number of roll dice that the attacker use to increase his/her attack
   *             in case of be a player character, or 0 in case of be a wild unit
   * @return the reducing damage
   */
  private def defend(attacker: Units, attacked: Units, roll: Int = 0): Int = {
    val damage = math.max(1, roll + attacker.getAttack - attacked.getDefense)
    damage
  }

  /** The respective unit try to evades the damage that corresponds him/her in an attack
   *
   * @param attacker the player that decide to attack to the attacked
   * @param attacked the victim of the attack
   * @param roll     the previous number of roll dice that the attacker use to increase his/her attack
   *                 in case of be a player character, or 0 in case of be a wild unit
   * @return the reducing damage
   */
  private def evade(attacker: Units, attacked: Units, roll: Int = 0): Int = {
    var damage = 0
    if (roll + attacked.getEva <=  attacker.getAttack) {
      damage = attacker.getAttack
    }
    damage
  }
}

