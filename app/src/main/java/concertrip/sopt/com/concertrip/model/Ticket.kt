package concertrip.sopt.com.concertrip.model

import concertrip.sopt.com.concertrip.interfaces.ListData

class Ticket : ListData{
    override fun getIndex(): Int=0

    override fun getMainTitle(): String = ""

    override fun getSubTitle(): String =""

    override fun getImageUrl(): String  =""
    var title : String = ""
    var place : String = ""
    var date : String = ""
}