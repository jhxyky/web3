package demo2;

import com.deepoove.poi.XWPFTemplate;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

@SpringBootTest(classes = jiaoMyTestClass.class)
public class jiaoMyTestClass {
    @Test
    public void testMethod(HttpServletResponse response) throws IOException {
        // 测试逻辑
//        assertEquals("Expected value", "Actual value");
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
