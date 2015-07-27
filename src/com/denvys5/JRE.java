package com.denvys5;

import net.launcher.utils.BaseUtils;

/**
 * Created by DAVis on 13.07.2015.
 */
public class JRE {
    public static boolean isJavaInstalled(){
        if(BaseUtils.getPropertyBoolean("Java installed")) return true;
        return false;
    }
}
