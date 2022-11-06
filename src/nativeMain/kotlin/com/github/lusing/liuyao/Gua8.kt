package com.github.lusing.liuyao



class Gua8 {
    val value: Int

    /*
     * 根据先天八卦数起卦
     */
    constructor(guaNum: Int){
        val value = (guaNum - 1) % 8
        var value8 = value.and(0b111)
        //println("Input value:"+value8.toString(2))
        value8 = value8.inv().and(0b111)
        val value0 = value8 and 0b001
        val value1 = (value8 and 0b010).ushr(1)
        val value2 = (value8 and 0b100).ushr(2)
        val result = (value0.shl(2)) + (value1.shl(1)) + value2
        //println("Output value:"+result.toString(2))
        this.value = result
    }
    
    constructor(first :Boolean, second :Boolean, third :Boolean){
        var value = 0
        if (first) value = value.or(0b001)
        if (second) value = value.or(0b010)
        if (third) value = value.or(0b100)
        this.value = value
    }

    fun getName() :String{
        return when (value) {
            0b000 -> ("坤")
            0b001 -> ("震")
            0b010 -> ("坎")
            0b011 -> ("兑")
            0b100 -> ("艮")
            0b101 -> ("离")
            0b110 -> ("巽")
            0b111 -> ("乾")
            else -> ("")
        }
    }

    override fun toString(): String {
        return this.getName()
    }
}
