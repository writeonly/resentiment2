package io.github.writeonly.resentment.ipu.corn.dsl

import io.github.writeonly.resentment.ipu.core.api.{PopCore, TopCore}
import io.github.writeonly.resentment.ipu.core.set.TopCoreExpression

class InvisibleUniCornDsl(core: PopCore[Unit]) extends TopCore[InvisibleUniCornDsl] {
  override def uvar(o: Symbol) = {
    core.uvar(o);
    this
  }

  override def ust(o: Symbol) = {
    core.ust(o);
    this
  }

  override def uld(o: Symbol) = {
    core.uld(o);
    this
  }

  override def uld(o: Int) = {
    core.uld(o);
    this
  }

  override def uld(o: Char) = {
    core.uld(o);
    this
  }

  override def uld(o: String) = {
    core.uld(o);
    this
  }

  override def pin() = {
    core.pin();
    this
  }

  override def pout() = {
    core.pout();
    this
  }

  override def pneg() = {
    core.pneg();
    this
  }

  override def pnot() = {
    core.pnot();
    this
  }

  override def png1() = {
    core.png1();
    this
  }

  override def uadd(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.padd();
    this
  }

  override def usub(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.psub();
    this
  }

  override def umul(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.pmul();
    this
  }

  override def udiv(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.pdiv();
    this
  }

  override def umod(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.pmod();
    this
  }

  override def ueq(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.peq();
    this
  }

  override def une(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.pne();
    this
  }

  override def uand(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.pand();
    this
  }

  override def uor(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.por();
    this
  }

  override def ult(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.plt();
    this
  }

  override def ugt(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.pgt();
    this
  }

  override def ule(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.ple();
    this
  }

  override def uge(o: Load => TopCoreExpression) = {
    core.ppush();
    o(this);
    core.pge();
    this
  }

}
