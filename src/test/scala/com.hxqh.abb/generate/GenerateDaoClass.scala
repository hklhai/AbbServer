package com.hxqh.abb.generate

import com.hxqh.abb.common.FileUtil
import org.junit.Test
import java.io.IOException

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by Ocean lin on 2017/8/14.
  */
//@RunWith(classOf[SpringJUnit4ClassRunner])
class GenerateDaoClass {


  private val VIEWMODEL = "import com.hxqh.eam.model."
  //    private static final String VIEWMODEL = "import com.hxqh.eam.model.view.";
  private val MODEL = "import com.hxqh.eam.model."
  private val DATE = "2017-7-20 "
  private val DAO = "import com.hxqh.eam.dao."

  //  @throws[IOException]
  //  def main(args: Array[String]): Unit = {
  //    generateDaoCode
  //    //generateControllerAndServiceCode("enterprise", "view");
  //  }


  @Test def gen(): Unit = {
//    generateDaoCode
    //generateControllerAndServiceCode("enterprise", "view");

  }

  /**
    * 生成Dao模块
    */
  private def generateDaoCode(): Unit = {
    //    val mboFile = "src/test/resources/scala/dao.property"
    //    val daoImpl = "src/test/resources/scala/daoImpl.property"
    //    val file = "src/test/resources/table.list"
    //    //生成Mbo实体
    val file = "D:\\HXQH\\CompanyProject\\AbbServer\\src\\test\\resources\\table.list"
    val mboFile = "D:\\HXQH\\CompanyProject\\AbbServer\\src\\test\\resources\\scala\\dao.property"
    val daoImpl = "D:\\HXQH\\CompanyProject\\AbbServer\\src\\test\\resources\\scala\\daoImpl.property"
    //生成Mbo实体

    val s = FileUtil.txt2String(file)
    //        System.out.println(s);
    val mBOName = s.split("\t")
    for (string <- mBOName) {
      if (string.length > 0) {
        val mboStr = FileUtil.txt2String(mboFile).replaceAll("XXXXX", string + "Dao").replaceAll("YYYYY", string)
        FileUtil.WriteStringToFile("src/" + string + "Dao" + ".scala", mboStr)
        //daoImpl
        val sb = new StringBuilder(string)
        sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)))
        val daoImplStr = FileUtil.txt2String(daoImpl).replaceAll("XXXX", string + "Dao").replaceAll("YYYY", string).replaceAll("ZZZZ", string + "DaoImpl").replaceAll("WWWW", sb.toString + "Dao")
        FileUtil.WriteStringToFile("src/" + string + "DaoImpl" + ".scala", daoImplStr)
      }
    }
    System.out.println("Generate Success!")
  }

}
