package view.components.custom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JButtonCustom extends JButton {

    private Color normalBackground = new Color(64, 147, 186);
    private Color hoverBackground = new Color(94, 167, 216);
    private Color pressedBackground = new Color(44, 117, 156);
    private int arcWidth = 15;
    private int arcHeight = 15;

    public JButtonCustom(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setFont(getFont().deriveFont(Font.BOLD, 14f));
        setHorizontalAlignment(SwingConstants.CENTER);
        setIconTextGap(10);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBackground);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalBackground);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedBackground);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(hoverBackground);
                repaint();
            }
        });

        setBackground(normalBackground);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Nền bo tròn
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setContentAreaFilled(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
    }

}
