package com.denvys5;

import net.launcher.components.*;

import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by DAVis on 17.06.2015.
 */
public class ModsTheme {
    public static ComponentStyle panelOpt	= new ComponentStyle(225, 105, 400, 300, "font", 16F, Color.DARK_GRAY, true);

   public static ButtonStyle close		= new ButtonStyle	(500, 360, 120, 40, "font", "button", 16F, Color.RED, true, Align.CENTER);

    public static int titleX 		= 362;
    public static int titleY 		= 140;
    public static ButtonStyle createButton(int yCoords){
        return new ButtonStyle(250, 150 + yCoords*30, 200, 23, "font", "button", 16F, Color.RED, true, Align.CENTER);
    }
}
