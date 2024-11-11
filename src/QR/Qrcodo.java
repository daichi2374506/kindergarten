package QR;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Qrcodo {
    public static void main(String[] args) {
        int size = 200; // QRコードのサイズ
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.WHITE); // 背景色
        graphics.fillRect(0, 0, size, size);
        graphics.setColor(Color.BLACK); // QRコードの色

        // 簡単なパターンを描画（実際のQRコードの生成ロジックはもっと複雑です）
        for (int i = 0; i < size; i += 10) {
            for (int j = 0; j < size; j += 10) {
                if ((i + j) % 20 == 0) {
                    graphics.fillRect(i, j, 10, 10);
                }
            }
        }

        graphics.dispose();

        try {
            ImageIO.write(image, "png", new File("qrcode.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}