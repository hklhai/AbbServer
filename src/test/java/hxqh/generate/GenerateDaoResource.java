package hxqh.generate;

import org.junit.Test;

/**
 * Created by lh on 2017-05-11.
 */
public class GenerateDaoResource {
    private static String[] MBOName = {"AbbIndexAsset","AbbIndexWfassignment","AbbIndexWorkorder","AbbInventory"};

    @Test
    public void genResource() {
        for (int i = 0; i < MBOName.length; i++) {
            StringBuilder builder = new StringBuilder();
            System.out.println("@Resource");
            builder.append("private ").append(MBOName[i]).append("Dao ");
            builder.append(MBOName[i].toLowerCase()).append("Dao;");
            System.out.println(builder.toString());
        }
    }

    @Test
    public void genFindAll() {
        for (int i = 0; i < MBOName.length; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append("List<").append(MBOName[i]).append("> ").append("list" + i + "=");
            builder.append(MBOName[i].toLowerCase()).append("Dao.findAll();").append("\n");
            builder.append("Assert.assertEquals(27,").append("list" + i + ".size());");
            builder.append("\r\n");
            System.out.println(builder.toString());
        }
    }


}
