package webapp02.servlet;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:27 2018/3/14
 */
public class MainServlet extends HttpServlet {
    // 建立十个线程的线程池
    private ExecutorService service = Executors.newFixedThreadPool(10);

    private void addCookie(String server, String ticket) {
        // 使用submit方法提交新的线程任务
        service.submit(new Runnable() {
            @Override
            public void run() {
                // 使用httppost调用post方法调用另一个服务器的setcookie接口
                HttpPost httpPost = new HttpPost(server + "/setCookie?ticket=" + ticket);
                CloseableHttpClient httpClient = null;
                CloseableHttpResponse response = null;
                try {
                    httpClient = HttpClients.createDefault();
                    response = httpClient.execute(httpPost);
                    HttpEntity entity = response.getEntity();
                    String content = EntityUtils.toString(entity, "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (response != null) {
                        try {
                            response.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (httpClient != null) {
                        try {
                            httpClient.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath().equals("/home")) {
            String domains = req.getParameter("domains");
            String ticket = req.getParameter("ticket");

            if (domains != null) {
                addCookie(domains, ticket);
            }
            req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
        } else if (req.getServletPath().equals("/setCookie")) {
            String ticket = req.getParameter("ticket");
            if (ticket != null) {
                resp.addCookie(new Cookie("USER_INFO_TICKET", ticket));
            }
        }
    }
}
