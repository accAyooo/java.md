package com.study.code;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:28 2018/3/13
 */
public class ExpressionCode {
    public static String drawImage(HttpServletResponse response) {
        Random random = new Random();
        int num1 = (int) (Math.random() * 10 + 1);
        int num2 = (int) (Math.random() * 10 + 1);
        int num3 = (int) (Math.random() * 3 + 1);

        String symbol = "";
        int result = 0;
        switch (num3) {
            case 1:
                symbol = "+";
                result = num1 + num2;
                break;
            case 2:
                symbol = "-";
                result = num1 - num2;
                break;
            case 3:
                symbol = "*";
                result = num1 * num2;
                break;
        }
        // 设置高度，宽度
        int height = 30;
        int width = 120;

        // 创建一个图片绘制器
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();

        // 设置字体
        graphics2D.setColor(getRandomColor(210, 255));
        graphics2D.setFont(new Font("微软雅黑", Font.PLAIN, 22));

        // 绘制画板
        graphics2D.fillRect(0, 0, width, height);
        // 扰乱线条的绘制
        graphics2D.setColor(getRandomColor(155, 200));
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(60);
            int y1 = random.nextInt(60);
            graphics2D.drawLine(x, y, x1, y1);
        }

        // 画板上显示的文字
        String resultString = num1 + " " + symbol + " " + num2 + " = ?";
        // 绘画开始
        graphics2D.setColor(getRandomColor(0, 40));
        graphics2D.drawString(resultString, 5, 25);

        // 绘制结束
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
            return Integer.toString(result);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    // 生成随机颜色
    public static Color getRandomColor(int fc, int bc) {
        Random random = new Random();

        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int red = fc + random.nextInt(bc - fc);
        int green = fc + random.nextInt(bc - fc);
        int blue = fc + random.nextInt(bc - fc);
        return new Color(red, green, blue);
    }

}
