class MySpecification extends org.specs2.Specification { def is = s2"""

 this is my specification
   where example 1 must be true           $e1
   where example 2 must be true           $e2
                                          """

  def e1 = 1 must_== 1
  def e2 = 2 must_== 2
}