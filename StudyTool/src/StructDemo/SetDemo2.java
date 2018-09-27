package StructDemo;

import java.util.Comparator;

import java.util.Set;

import java.util.TreeSet;

 
//定制排序
class Student1{

    private Integer age;

   

    public Student1(Integer age) {

       super();

       this.age = age;

    }

 

    public Integer getAge() {

       return age;

    }

 

    public void setAge(Integer age) {

       this.age = age;

    }

 

    @Override

    public String toString() {

       return age + "";

    }

}

 

class MyComparator implements Comparator{  //第一步：实现Comparator接口

   

    @Override

    public int compare(Object o1, Object o2) {   

       if(o1 instanceof Student1 & o2 instanceof Student1){

           Student1 s1 =(Student1)o1;

           Student1 s2 =(Student1)o2;

           if(s1.getAge() < s2.getAge()){

              return -1;

           }else if(s1.getAge() > s2.getAge()){

              return 1;

           }

       }

       return 0;

    }

}

 

public class SetDemo2{

    public static void main(String[] args) {

       Set<Student1> s= new TreeSet<Student1>(new  MyComparator());//第三步：创建TreeSet集合对象时,提供一个一个Comparator对象,

       /**

        * 要实现定制排序,需要在创建TreeSet集合对象时,提供一个一个Comparator对象,

        * 该对象里负责集合元素的排序逻辑;

        */

       s.add(new Student1(140));

       s.add(new Student1(15));

       s.add(new Student1(11));

       s.add(new Student1(63));

       s.add(new Student1(96));

      

       System.out.println(s);

    }

}