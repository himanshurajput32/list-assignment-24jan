/*
Problems:
1. Compute the length of a list using method foldRight. The signature of the method should be:  
def length[A](l: List[A]): Int
(Note: Do not use length method provided in the scala library)

2. Implement a method hasSubsequence for checking whether a List contains another List as a subsequence. For instance, List(1,2,3,4) would have List(1,2), List(2,3), and List(4) as subsequences. The signature of the method should be:
def hasSubsequence[A](list:List[A],sub:List[A]):Boolean

3. Write a function that concatenates a list of lists into a single list. Its runtime should be linear in the total length of all lists. The signature of the method should be:
def concateList[A](l1:List[A],l2:List[A]):List[A]
(Note: You can use Pattern matching over lists to implement the method. But, do not use any provided methods as solutions)

4. Write a function that splits a list elements into a pair of lists on the basis of given boolean function. The signature of the method should be:
def splitList[A](l:List[A],f:A=>Boolean):(List[A],List[B]) 
(Note: Do not use method filter provided in the library)
*/

import scala.collection.mutable.ListBuffer

object Assignment24Jan extends App{

//method to find length of list
def length(list:List[Int]):Int={
val temp_list= for(ls<- list) yield 1
val res=temp_list.foldRight(0)((a,b)=>a+b)
res
}

//method to find subsequence in a list
def hasSubSequence(list:List[Any],sub:List[Any]):Boolean={
val superList = list.foldRight("")((x,y)=>y+x)
val subList = sub.foldRight("")((x,y)=>y+x)
if(superList.indexOf(subList) >= 0)
true
else
false
}

//method to concat two list
def concatList(list_1:List[Int],list_2:List[Int]):List[Int]={
val buf=list_1.to[ListBuffer]
for(ls<-list_2){ 
buf +=ls
}
buf.toList
}

//method to split a list according to given condition
def splitList(list:List[Int],func:Int=>Boolean):(List[Int],List[Int])={
val result = for(ls<-list if(func(ls)==true)) yield ls 
val result1 = for(ls<-list if(func(ls)==false)) yield ls 
(result.toList,result1.toList)
}

println(hasSubSequence(List(1,2,3,4,5),List(1,2,3)))
println(splitList(List(1,2,3,4,5,6,7,8),x=>x%2==0))
println(concatList(List(1,2,3),List(4,5,6)))
println(length(List(1,23,34,4,5,56,4,4,4,4)))
}






















