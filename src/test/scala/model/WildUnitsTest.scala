package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class WildUnitsTest extends munit.FunSuite {
  var chicken: WildUnit = null
  var roboball: WildUnit = null
  var seagull: WildUnit = null

  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken
    roboball = new RoboBall
    seagull = new Seagull
  }

  test("Equals"){
    assertEquals(roboball, roboball)
    assertEquals(seagull, new Seagull)
    assertNotEquals(chicken, roboball)
  }
}