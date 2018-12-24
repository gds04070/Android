package concertrip.sopt.com.concertrip.model

class Schedule(var date: Int, var text: String) {

    //이건 임시 변수



    companion object {

        fun getDummy(): Schedule = Schedule(1, "지코")
        fun getDummyList(): ArrayList<Schedule> {

            val list = ArrayList<Schedule>()
            list.add(Schedule(1, "지코"))
            list.add(Schedule(3, "피오"))
            list.add(Schedule(7, "지코"))
            list.add(Schedule(12, "피오"))
            list.add(Schedule(12, "피오"))
            list.add(Schedule(12, "피오"))
            list.add(Schedule(12, "피오"))
            list.add(Schedule(12, "피오"))

            return list

        }
        fun toMap(list : ArrayList<Schedule>) : HashMap<Int, ArrayList<Schedule>>{
            val  map  = HashMap<Int, ArrayList<Schedule>>()
            list.forEach {
                if(!map.containsKey(it.date))
                    map[it.date]= ArrayList<Schedule>()
                map[it.date]?.add(it)
            }
            return map
        }
    }

}