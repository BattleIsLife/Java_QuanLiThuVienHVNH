package view.components;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuItem extends JPanel {
    
    private static final long serialVersionUID = 1L;


    private Model_Menu data;

    public MenuItem(Model_Menu data) {
        this.data = data;
        initComponent();
    }

    private void initComponent() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel(data.getName());  // Hoặc bạn dùng icon nếu có
        label.setForeground(Color.WHITE);
        this.add(label);
    }

    public static class Model_Menu {
        public enum MenuType {
            MENU, TITLE, EMPTY
        }

        private String id;
        private String name;
        private MenuType type;

        public Model_Menu(String id, String name, MenuType type) {
            this.id = id;
            this.name = name;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public MenuType getType() {
            return type;
        }
    }
}
