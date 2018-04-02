package com.study.code;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午9:30 2018/3/13
 */
public class CaptchaCode {
    public static String drawImage(HttpServletResponse response) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(getCodeString());
        }
        String code = stringBuilder.toString();
        // 定义图片的宽和高
        int height = 25;
        int width = 120;
        // 建立bufferedimage对象并设置初始值
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        // 获取绘制对象
        Graphics2D graphics2D = bufferedImage.createGraphics();
        // 获取文字对象
        Font font = new Font("微软雅黑", Font.PLAIN, 20);
        Color color = new Color(0, 0, 0);
        // 设置字体和字体颜色
        graphics2D.setFont(font);
        graphics2D.setColor(color);
        // 设置背景颜色
        graphics2D.setBackground(new Color(226, 226, 240));
        // 开始绘制
        graphics2D.clearRect(0, 0, width, height);
        // 绘制形状
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, fontRenderContext);

        // 计算文件的坐标和间距
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;

        graphics2D.drawString(code, (int) x, (int) baseY);
        // 开始绘制
        graphics2D.dispose();
        // 开始写入
        try {
            ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return code;
    }

    public static char getCodeString() {
        String codeRange = "qwertyuiopasdfghjklzxcvbnm1234567890";
        Random random = new Random();
        char randomChar = codeRange.charAt(random.nextInt(codeRange.length()));
        return randomChar;
    }
}
