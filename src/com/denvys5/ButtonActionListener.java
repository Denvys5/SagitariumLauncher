package com.denvys5;

import net.launcher.utils.BaseUtils;

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
    }
    public void actionPerformed(ActionEvent e) {
        if(action){
            action = false;
        }else{
            action = true;
        }
        BaseUtils.setProperty(mod, action);
    }
}
