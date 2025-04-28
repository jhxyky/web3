package IFlyweight;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.deepoove.poi.XWPFTemplate;
import com.example.demo.Demo2ApplicationTests;
import com.example.demo.Person;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.applet.Main;

//import java.io.ByteArrayOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
//import java.util.Base64;
//import java.util.zip.GZIPOutputStream;

//@SpringBootTest(classes = main1.class)
public class main1 {

    @Test
    public void test(HttpServletResponse response) throws InterruptedException, IOException {
        XWPFTemplate template = XWPFTemplate.compile("src/main/resources/2024年广东E站扣款函件（特殊） (1).docx").render(
                new HashMap<String, Object>(){{
                    put("title", "Hi, poi-tl Word模板引擎");
                }});
//        template.writeAndClose(new FileOutputStream("output.docx"));
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"out_template.docx"+"\"");

// HttpServletResponse response
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
    }
}
