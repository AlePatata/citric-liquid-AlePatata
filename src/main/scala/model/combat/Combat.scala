package cl.uchile.dcc.citric
package model.combat

import model.units.PlayerCharacter

/** A combat is an event in which two player characters face a duel
 *
 * @param attacker the player that decide to attack to the attacked
 * @param attacked the victim of the attack
 */
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
  /** The attack performs the following sequence of instructions:
   * -modifies the attacker's attack using his/her dice
   * -ask for the decision of the attacked to defend or evaded him/herself
   * -applies the resulting damage
   */
  private def attack(attacker: PlayerCharacter, attacked: PlayerCharacter): Unit = {
    val roll = attacker.rollDice()
    attacker.setAttack(roll)
    val decision = attacker.choose(2)
    var damage = 0
    if (decision == 0) damage = defend(attacker, attacked, roll)
    else damage = evade(attacker, attacked, roll)
    attacked.setHP(-damage)
  }

  /** The respective unit defends him/herself reducing the damage that corresponds him/her
   *
   * @param attacker the player that decide to attack to the attacked
   * @param attacked the victim of the attack
   * @param attackerRoll the previous number of roll dice that the attacker use to increase his/her attack
   * @return the reducing damage
   */
  private def defend(attacker: PlayerCharacter, attacked: PlayerCharacter, attackerRoll: Int): Int = {
    val attackedRoll = attacked.rollDice()
    val damage = math.max(1, attackerRoll + attacker.getAttack - (attackedRoll + attacked.getDefense))
    damage
  }

  /** The respective unit try to evades the damage that corresponds him/her in an attack
   *
   * @param attacker     the player that decide to attack to the attacked
   * @param attacked     the victim of the attack
   * @param attackerRoll the previous number of roll dice that the attacker use to increase his/her attack
   * @return the reducing damage
   */
  private def evade(attacker: PlayerCharacter, attacked: PlayerCharacter, attackerRoll: Int): Int = {
    val attackedRoll = attacked.rollDice()
    var damage = 0
    if (attackedRoll + attacked.getEva <= attackerRoll + attacker.getAttack) {
      damage = attacker.getAttack
    }
    damage
  }
}


