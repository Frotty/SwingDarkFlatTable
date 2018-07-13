package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SetupCheckBox extends JCheckBox {
    static Icon icon;
    static Icon iconOver;
    static Icon iconPressed;
    static Icon iconPressedSelected;
    static Icon iconSelected;
    static Icon iconOverSelected;

    static {
        try {
            BufferedImage iconImg = getCheckboxImage("checkbox");
            BufferedImage iconOverImg = getCheckboxImage("checkboxover");
            BufferedImage iconPressedImg = getCheckboxImage("checkboxpressed");
            BufferedImage iconPressedSelectedImg = getCheckboxImage("checkboxpressedselected");
            BufferedImage iconSelectedImg = getCheckboxImage("checkboxselected");
            BufferedImage iconOverSelectedImg = getCheckboxImage("checkboxoverselected");

            icon = new ImageIcon(iconImg);
            iconOver = new ImageIcon(iconOverImg);
            iconPressed = new ImageIcon(iconPressedImg);
            iconPressedSelected = new ImageIcon(iconPressedSelectedImg);
            iconSelected = new ImageIcon(iconSelectedImg);
            iconOverSelected = new ImageIcon(iconOverSelectedImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage getCheckboxImage(String imageName) throws IOException {
        return ImageIO.read(SetupCheckBox.class.getResourceAsStream("/" + imageName + ".png"));
    }

    public SetupCheckBox() {
        super();
        initUI();
    }

    public SetupCheckBox(String selectName) {
        super(selectName);
        initUI();
    }

    private void initUI() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0));
        setForeground(new Color(255, 255, 255));
        setFocusPainted(false);

        setIcon(icon);
        setRolloverIcon(iconOver);
        setPressedIcon(iconPressed);
        setSelectedIcon(iconSelected);
        setRolloverSelectedIcon(iconOverSelected);
    }

    public Icon getPressedIcon() {
        //checkbox is missing 'pressed selected' icon, this allows us to add it
        if (isSelected())
            return iconPressedSelected;
        else
            return super.getPressedIcon();
    }

}