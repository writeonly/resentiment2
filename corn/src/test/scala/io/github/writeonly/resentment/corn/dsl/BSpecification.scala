import io.github.writeonly.resentment.core.impl.PopCoreFake
import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.dsl.TopCornDsl
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BSpecification extends org.specs2.Specification { def is = s2"""

 this is my specification
   where example 1 must be true           $e1
   where example 2 must be true           $e2
   where 2 + 4 = 6 must be true           $top
                                          """

  def e1 = 1 must_== 1
  def e2 = 2 must_== 2

  def top = {
    val core = new PopCoreFake(StreamIO.byteArray(""))
    new TopCornDsl(core)
      .uld(2).uvar('a)
      .uld(4).uvar('b)
      .uld('a).uadd(_.uld('b))
      .uvar('c)
    core.value('c)
  } must_== 6


}