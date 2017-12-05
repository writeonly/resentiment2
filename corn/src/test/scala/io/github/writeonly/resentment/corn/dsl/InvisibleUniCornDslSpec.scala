import io.github.writeonly.resentment.core.impl.PopCoreFake
import io.github.writeonly.resentment.corn.dsl.InvisibleUniCornDsl
import io.github.writeonly.resentment.fsm.StreamIO
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InvisibleUniCornDslSpec extends org.specs2.Specification { def is = s2"""

 this is my specification
   where 2 + 4 = 6 must be true           $add
                                          """

  def add = new PopCoreFake(StreamIO.byteArray(""))
    .apply(new InvisibleUniCornDsl(_)
    .uld(2).uvar('a)
    .uld(4).uvar('b)
    .uld('a).uadd(_.uld('b))
    .uvar('c)
  ).value('c) must_== 6

}