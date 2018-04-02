package com.study.servlet;

import com.study.model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 上午9:57 2018/3/10
 */
@WebServlet("/user/SignupServlet")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> resultMap = new HashMap<>();
        // 创建user对象
        User user = new User();
        // 创建磁盘文件解析类工厂
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        // 创建核心解析类
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        // 解析request
        try {
            List<FileItem> list = servletFileUpload.parseRequest(req);
            for (FileItem fileItem : list){
                // 在fileitem为普通参数的时候不进行文件处理
                if(fileItem.isFormField()) {
                    resultMap.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
                } else {
                    // 获得文件名称
                    String fileName = fileItem.getName();
                    // 获得文件输入的流
                    InputStream inputStream = fileItem.getInputStream();
                    // 使用getRealPath()获得image目录的绝对路径
                    String realPath = this.getServletContext().getRealPath("/image");
                    // 拼接路径
                    String url = realPath + "/" + fileName;
                    System.out.println(url);
                    // 拷贝到服务器
                    OutputStream outputStream = new FileOutputStream(url);
                    int len = 0;
                    byte[] bytes = new byte[1024];
                    while((len = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, len);
                    }
                    inputStream.close();
                    outputStream.close();
                    user.setHeadUrl(url);
                }
            }
            user.setId(1);
            user.setUsername((String) resultMap.get("username"));
            user.setPassword((String) resultMap.get("password"));
            try{
                int sexValue = Integer.parseInt((String) resultMap.get("sex"));
                if (sexValue == 0) {
                    user.setSex("男");
                } else if (sexValue == 1) {
                    user.setSex("女");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            List<User> database = (List<User>) getServletContext().getAttribute("DATABASE_LIST");
            database.add(user);
            getServletContext().setAttribute("DATABASE_LIST", database);
            HttpSession session = req.getSession();
            resp.sendRedirect("/views/login.jsp");
            session.setAttribute("USER_INFO_NAME", user.getUsername());
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
