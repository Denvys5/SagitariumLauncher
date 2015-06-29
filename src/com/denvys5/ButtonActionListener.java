package com.denvys5;

import net.launcher.components.*;
import net.launcher.utils.BaseUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.denvys5.Menu.*;


/**
 * Created by DAVis on 24.06.2015.
 */
public class ButtonActionListener implements ActionListener {
    private final String mod;
    private boolean action;
    public ButtonActionListener(String mod){
        this.mod = mod;
        this.action = Menu.isModActive(mod);
    }
    public void actionPerformed(ActionEvent e) {
        if(action){
            action = false;
        }else{
            action = true;
        }
        BaseUtils.setProperty(mod, action);
        ((net.launcher.components.Button)e.getSource()).setLabel(Menu.isModActive(mod) + " " + mod);
        System.out.println(mod + Menu.isModActive(mod));
    }
}
