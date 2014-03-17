package playground

/**
 * Created by iandonescu on 3/13/14.
 */
trait Functor[F[_]] {

  def map[A, B](fa: F[A])(f: A => B): F[B]

}
