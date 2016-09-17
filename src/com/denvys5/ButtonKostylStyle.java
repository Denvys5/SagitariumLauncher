package com.denvys5;

import net.launcher.components.*;
import net.launcher.utils.BaseUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by DAVis on 17.09.2016.
 */
public class ButtonKostylStyle {
    public int x = 0;
    public int y = 0;
    public int w = 0;
    public int h = 0;
    public String fontName = BaseUtils.empty;
    public float fontSize = 1F;
    public Color color;
    public boolean visible = false;
    public Align align;
    public BufferedImage texture;

    public ButtonKostylStyle(int x, int y, int w, int h, String fontName, String texture, float fontSize, Color color, boolean visible, Align align)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.color = color;
        this.visible = visible;
        this.align = align;
        this.texture = BaseUtils.getLocalImage(texture);
    }

    public void apply(net.launcher.components.Button button)
    {
        button.setVisible(visible);
        button.setBounds(x, y, w, h);
        button.setForeground(color);
        button.setFont(BaseUtils.getFont(fontName, fontSize));
        button.setHorizontalAlignment(SwingConstants.LEFT);

        int i = texture.getHeight()/7;
        button.defaultTX = texture.getSubimage(0, 0, texture.getWidth(), i);
        button.rolloverTX = texture.getSubimage(0, i, texture.getWidth(), i);
        button.pressedTX = texture.getSubimage(0, i * 2, texture.getWidth(), i);
        button.lockedTX = texture.getSubimage(0, i * 3, texture.getWidth(), i);
    }
}
