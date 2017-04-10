/**
  * Created by knoldus on 10/4/17.
  */
object QueryRun extends App{

    val query = new CassandraQuery
   println("Query 1 result :: ")
    query.selectUserByEmail("ramandeep.kaur@knoldus.in")
  println("Query 2 result :: ")
    query.selectVideoByVideoName("Two states")
  println("Query 3 result :: ")
    query.selectVideosUploadedafter2015(2015)
  println("Query 4 result :: ")
    query.selectVideoByIdAndYear(1)

}

