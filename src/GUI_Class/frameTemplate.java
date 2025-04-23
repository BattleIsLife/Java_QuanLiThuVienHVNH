package GUI_Class;

import javax.swing.JFrame;

public class frameTemplate extends JFrame{
    public frameTemplate()
    {
        this.setTitle("Chương trình quản lí thư viện HVNH");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
    }
}
