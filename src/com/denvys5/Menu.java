package com.denvys5;

import net.launcher.utils.BaseUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by DAVis on 29.05.2015.
 */
public class Menu implements ActionListener{
    public static ArrayList<String> modlist = new ArrayList<String>();
    public static ArrayList<String> selectedModlist = new ArrayList<String>();
    private final String mod;
    private int action;
    public Menu(String mod){
        this.mod = mod;
    }
    public void actionPerformed(ActionEvent e){
        if(action == 0)selectedModlist.add(mod);
        if(action == 1)selectedModlist.remove(mod);
    }
}
