package com.denvys5;

import net.launcher.utils.BaseUtils;

/**
 * Created by DAVis on 26.08.2015.
 */
public class GameSize {
    public static int width = 854;
    public static int height = 480;

    public static int getWidth(){
        if(!BaseUtils.config.checkProperty("GameWidth")) BaseUtils.setProperty("GameWidth", width);
        return BaseUtils.getPropertyInt("GameWidth");
    }

    public static int getHeight(){
        if(!BaseUtils.config.checkProperty("GameHeight")) BaseUtils.setProperty("GameHeight", height);
        return BaseUtils.getPropertyInt("GameHeight");
    }
}
