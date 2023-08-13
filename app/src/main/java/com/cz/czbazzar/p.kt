package com.cz.czbazzar

import javax.annotation.meta.When


class p {
    companion object{
        @JvmStatic
        fun main(args:Array<String>){
            print("hello ${add(2,4)}")
            var x= 6

            if(x==7){
                print("hello x")
}
            else print("not hello x ")


        }
        fun add(a:Int,b:Int) : Int {

            return a+b


        }

    }
}