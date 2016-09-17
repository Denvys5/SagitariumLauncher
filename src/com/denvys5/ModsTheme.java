package com.denvys5;

import net.launcher.components.*;

import java.awt.*;

/**
 * Created by DAVis on 17.06.2015.
 */
public class ModsTheme {
    public static ComponentStyle panelOpt	= new ComponentStyle(225, 105, 400, 300, "font", 16F, Color.DARK_GRAY, true);

   public static ButtonStyle close		= new ButtonStyle	(500, 360, 120, 40, "font", "", 16F, Color.RED, false, Align.CENTER);

    public static int titleX 		= 362;
    public static int titleY 		= 250;
    public static CheckboxStyle createButton(int yCoords){
        CheckboxStyle button = new CheckboxStyle(250, 150+yCoords*25, 320, 20, "font", "checkbox", 16F, Color.DARK_GRAY, true);
        //ButtonKostylStyle button = new ButtonKostylStyle(250, 150 + yCoords*25, 320, 20, "font", "checkbox", 16F, Color.RED, true, Align.LEFT);
        return button;
    }
}
