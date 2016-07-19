package custom_options

//import java.io.{ByteArrayOutputStream, File, FileOutputStream, ObjectOutputStream}
import java.io._
//import my_opts._

object test{

  def main(args:Array[String]): Unit ={
    {
      //encode
      val tmp = new my_opts.helloworld(11, "hello",Option(222))

//      tmp.update(_.id := 11)
//      tmp.update(_.str := "hello")

      println(tmp)

      val file = new File("test")
      val out = new FileOutputStream(file)
      val baos = new ByteArrayOutputStream()

      tmp.writeTo(baos)
      baos.writeTo(out)
      baos.flush()
      baos.close()
    }

    {
      //decode
      val file = new File ("test")
      val in = new FileInputStream(file)
      val bytes = new Array[Byte](file.length().toInt)
      in.read (bytes)
      in.close()

      val res = my_opts.helloworld.parseFrom(bytes)

      println(res)
    }

  }

}
