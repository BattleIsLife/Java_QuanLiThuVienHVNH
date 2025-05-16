package view.components.custom;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

public class EmptyIcon implements Icon {

    private int width;
    private int height;

    public EmptyIcon() {
        this(24, 24); // mặc định kích thước nếu không truyền vào
    }

    public EmptyIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        // không vẽ gì
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
