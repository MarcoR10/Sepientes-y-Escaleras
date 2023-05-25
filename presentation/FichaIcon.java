package presentation;
import javax.swing.Icon;
import java.awt.*;

public class FichaIcon implements Icon {
    private Color color;
    private int width;
    private int height;

    public FichaIcon(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        g2d.fillOval(x, y, width, height);
        int centerX = x + (width / 2);
        int centerY = y + (height / 2);
        int puntoSize = Math.min(width, height) / 5;
        g2d.setColor(Color.WHITE);
        int puntoX = centerX - (puntoSize / 4);
        int puntoY = centerY - (puntoSize / 4);
        g2d.fillOval(puntoX, puntoY, puntoSize, puntoSize);

        g2d.dispose();
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}
