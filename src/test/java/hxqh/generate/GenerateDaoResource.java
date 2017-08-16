package hxqh.generate;

import com.hxqh.abb.common.util.FileUtils;
import org.junit.Test;

import java.io.File;

/**
 * Created by lh on 2017-05-11.
 */
public class GenerateDaoResource {

    //生成Mbo实体
    File file = new File("src/test/resources/table.list");
    String s = FileUtils.txt2String(file);
    //        System.out.println(s);
    String[] mBOName = s.split("\r\n");

//    @Test
    public void genResource() {
        for (int i = 0; i < mBOName.length; i++) {
            StringBuilder builder = new StringBuilder();
            System.out.println("@Resource");
            builder.append("private ").append(mBOName[i]).append("Dao ");
            builder.append(mBOName[i].toLowerCase()).append("Dao;");
            System.out.println(builder.toString());
        }
    }

//    @Test
    public void genFindAll() {
        for (int i = 0; i < mBOName.length; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append("List<").append(mBOName[i]).append("> ").append("list" + i + "=");
            builder.append(mBOName[i].toLowerCase()).append("Dao.findAll();").append("\n");
            builder.append("Assert.assertEquals(27,").append("list" + i + ".size());");
            builder.append("\r\n");
            System.out.println(builder.toString());
        }
    }


}
