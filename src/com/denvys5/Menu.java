package com.denvys5;

import net.launcher.utils.BaseUtils;

import javax.swing.*;

/**
 * Created by DAVis on 29.05.2015.
 */
public class Menu {
    public static JPanel menu = new JPanel();
    public static void Screen(){
        JFrame mods = new JFrame();
        mods.setResizable(false);
        BaseUtils.execute(BaseUtils.buildUrl("launcher.php"), new Object[] {null});
        mods.setSize(200, 100 + 25*Modlist.modlist.size());
        for(String name : Modlist.modlist){
            modButton(name);
        }
        mods.add(menu);
    }


    public static void modButton(String name){
        JButton button = new JButton(name);
        menu.add(button);
    }
}
