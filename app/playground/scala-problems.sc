/**
 * Created by iandonescu on 3/13/14.
 * based on the problems from : http://aperiodic.net/phil/scala/s-99/
 */


println s"problems 1 : find the last element of a list"

def last[A](list: List[A]): A =
  list match {
    case a :: Nil => a
    case a :: ax => last(ax)
    case _ => throw new RuntimeException("empty list")
  }
println(last(List(1, 1, 2, 3, 5, 8)))


println(last(List(1)))





println s"problem 2 : find the last but one"
def penultimate[A](list: List[A]): A =
  list match {
    case List (first, second) => first
    case a :: b :: c => penultimate(b :: c)
    case _ => throw new RuntimeException("empty list")
  }

println(penultimate(List(1, 1, 2, 3, 5, 8)))


