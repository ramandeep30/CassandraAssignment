import com.datastax.driver.core.{Session,Cluster}

/**
  * Created by knoldus on 10/4/17.
  */
class CassandraQuery {

    val cluster = Cluster.builder().addContactPoint("127.0.0.1").build()

    val session = cluster.connect("KIP")

    def selectUserByEmail(email: String) = {

      val records = session.execute(s"select * from user where email='$email' allow filtering")
      val iterate = records.iterator()
      while (iterate.hasNext) {
        println(iterate.next())

    }
  }

  def selectVideoByVideoName(video_name: String) = {

    val records = session.execute(s"select * from video where video_name = '$video_name' allow filtering")
    val iterate = records.iterator()
    while (iterate.hasNext) {
      println(iterate.next())
    }
  }

  def selectVideosUploadedafter2015(year: Int) = {

    val records = session.execute(s"select * from videoByYear where year > $year allow filtering")
    val iterate = records.iterator()
    while (iterate.hasNext)
      println(iterate.next())
  }

  def selectVideoByIdAndYear(userId:Int) = {

    val records = session.execute(s"select * from videoByYear where userId = $userId ORDER BY year DESC;")
    val iterate = records.iterator()

    while (iterate.hasNext) {

      println(iterate.next())

    }

  }
 cluster.close()
}

