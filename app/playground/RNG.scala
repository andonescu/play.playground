package playground

/**
 * Created by iandonescu on 3/12/14.
 */
trait RNG {
  def nextInt: (Int, RNG)
}
