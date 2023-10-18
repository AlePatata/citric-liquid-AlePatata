package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.units.{Chicken, RoboBall, Seagull, WildUnit}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class WildUnitsTest extends munit.FunSuite {
  var chicken: WildUnit = _
  var roboball: WildUnit = _
  var seagull: WildUnit = _

  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken
    roboball = new RoboBall
    seagull = new Seagull
  }

  test("Equals"){
    assertEquals(roboball, roboball)
    val Seagull = seagull
    assertEquals(seagull, Seagull)
    assertNotEquals(chicken, roboball)
  }
}