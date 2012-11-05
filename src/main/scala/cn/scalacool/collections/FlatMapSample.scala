package cn.scalacool.collections

/**
 * Created with IntelliJ IDEA.
 * User: zhangh
 * Date: 11/5/12
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
/**
 * http://alvinalexander.com/scala/collection-scala-flatmap-examples-map-flatten
 */
object FlatMapSample extends App {

  val fruits = Seq("apple","banana","orange")

  val res0 = fruits.map(_.toUpperCase)

  println(res0)

  val res1 = fruits.flatMap(_.toUpperCase)

  println(res1)

  //Difference between map and flatMap

  def toInt(s:String) : Option[Int] = {
    try {
        Some(s.toInt)
    } catch {
      case e:Exception =>  None
    }
  }

  val strings = Seq("1","2","foo","3","bat")
  val res2 = strings.map(toInt)
  println(res2)
  val res3 = strings.flatMap(toInt)
  println(res3)
  val res4 = strings.flatMap(toInt).sum
  println(res4)


  //FlatMap with another function
  val list = List(1,2,3,4,5)
  def g(v:Int) = List(v-1,v,v+1)
  val res5 = list.map(g(_))
  println(res5)
  val res6 = list.flatMap(g(_))
  println(res6)

  //Convert map values to a sequence with flatMap
  val map = Map(1 -> "one",2 -> "two",3-> "three")
  val res7 = 1 to map.size flatMap (map.get)
  val res8 = 1 to map.size map (map.get)

  //flatMap examples from Twitter documentation
  val chars = 'a' to 'z'
  val perms = chars flatMap { a =>
      chars flatMap { b =>
         if (a!=b) Seq("%s%s".format(a,b))
         else Nil
      }
  }
  println(perms)

  val res9 = Seq(1,2,3,4) map { x =>
    Seq(x,-x)
  }
  println(res9)
  println(res9.flatten)

  val res10 = Seq(1,2,3,4) flatMap { x =>
    if (x % 2 == 0) Seq(x)
    else Nil
  }
  println(res10)
}
