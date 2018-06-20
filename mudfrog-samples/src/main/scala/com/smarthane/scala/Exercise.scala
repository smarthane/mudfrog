package com.smarthane.scala


class Exercise {
  
}

object Exercise {

  def main(args: Array[String]): Unit = {
    
    // 创建一个List
    val list0 = List(2,5,9,6,7,1,8,4,3,0)
    println(list0)

    // 将list0中的每个元素乘以2后一个新的集合
    val list1 = list0.map(_ * 2)
    println(list1)

    // 将list0中的偶数取出来生成一个新的集合
    val list2 = list0.filter(_ % 2 == 0)
    println(list2)

    // 将list0排序后生成一个新的集合  没有参数的话是可以不用()的
    val list3 = list0.sorted
    println(list3)
    
    // 将list0反转排序
    val list4 = list0.sorted.reverse
    println(list4)

    // 装饰list0中的元素4个一组，类型为Iterator[List[Int]]
    val it1 = list0.grouped(4)
    println(it1)
    println(it1.toBuffer)

    // 将Iterator转换为List
    val list5 = list0.grouped(4).toList
    println(list5)

    // 将多个list合并成一个list
    val list6 = list0.grouped(4).toList.flatten
    println(list6)

    // 先按空格切分，再压平合并
    val lines = List("hello java hello hadoop", "hello scala","hellop python")
    val list7 = lines.map(_.split(" ")).flatten
    println(list7)
    println(lines.flatMap(_.split(" ")))

    // 并行计算求合
    val arr0 = Array(1,2,3,4,5,6,7,8,9,10)
    val res0 = arr0.sum
    println(res0)
    // 和线程有关，每个线程计算一部分:(1+2+3）+（4+5+6+7）+（8+9+10）
    val res1 = arr0.par.sum
    println(res1)

    // 按照特定的顺序进行聚合  reduceLeft(_+_)
    val res2 = arr0.reduce(_+_)
    println(res2)
    val res3 = arr0.par.reduce(_+_)
    println(res3)

    // 折叠：有初始值（无特定顺序）
    val res4 = arr0.fold(10)(_+_)
    println(res4)

    // 折叠：有初始值（有特定顺序）
    val res5 = arr0.foldLeft(10)(_+_)
    println(res5)
    val res6 = arr0.foldLeft(10)(_-_)
    println(res6)

    // 聚合
    val list8 = List(List(1,2,3), List(4,5,6), List(7,8,9),List(10), List(0))
    println(list8)
    val res7 = list8.flatten.reduce(_+_)
    println(res7)
    val res8 = list8.aggregate(0)(_+_.sum, _+_)
    println(res8)

    val l1 = List(5,6,4,7)
    val l2 = List(1,2,3,4,5)
    // 求并集
    val res9 = l1 union l2
    println(res9)

    // 求交集
    val res10 = l1 intersect  l2
    println(res10)

    // 求差集
    val res11 = l1 diff  l2
    println(res11)

    println("--------------------------worldcount---------------------------")
    // worldcount
    val ll1 = List("hello java hello python", "hello scala", "hello scala hello java hello world")
    // 切分 并压平
    val words = ll1.flatMap(_.split(" "))
    println(words)
    // 把每个单词生成一个一个的元组
    val tuples = words.map((_, 1))
    println(tuples)
    // 以key(单词)进行分组
    val grouped = tuples.groupBy(_._1)
    println(grouped)
    // 统计value的长度
    val sum = grouped.mapValues(_.size)
    println(sum)
    // 排序
    val sorted = sum.toList.sortBy(_._2)
    println(sorted)
    // 反转
    val reversed = sorted.reverse
    println(reversed)


  }

}
