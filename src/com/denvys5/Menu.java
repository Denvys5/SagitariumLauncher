package com.denvys5;

import net.launcher.components.Frame;
import net.launcher.run.Settings;
import net.launcher.utils.BaseUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.launcher.utils.BaseUtils.*;
import java.util.ArrayList;
import java.util.HashMap;

import static net.launcher.utils.BaseUtils.getPropertyInt;

/**
 * Created by DAVis on 29.05.2015.
 */
public class Menu {
    public static ArrayList<String> modlist = new ArrayList<String>();
    public static HashMap<String, Integer> modfiles = new HashMap<String, Integer>();
    public static void setModlist(){
        String foldermods = BaseUtils.execute(BaseUtils.buildUrl("mods.php"), new Object[]{null});
        String modsize = BaseUtils.execute(BaseUtils.buildUrl("mods.php?size"), new Object[]{null});
        String[] size = modsize.split("<:>");
        String[] parts = foldermods.split("<:>");
        int a = 0;
        int[] numericSize = new int[size.length];
        for(String i : size){
            numericSize[a] = Integer.parseInt(i);
            a++;
        }
        for(String name : parts){
            Menu.modlist.add(name);
        }
        for(int i = 0; i < Menu.modlist.size(); i++){
            modfiles.put(parts[i], numericSize[i]);
        }
    }

    public static String getServerName()
    {
        String error = "Offline";
        try
        {
            String url = BaseUtils.runHTTP(BaseUtils.getURLSc("servers.php"), "", false);

            if (url == null)
            {
                return error;
            } else if (url.contains(", "))
            {
                Settings.servers = url.replaceAll("<br>", "").split("<::>");
                String[] serversNames = new String[Settings.servers.length];

                for (int a = 0; a < Settings.servers.length; a++)
                {
                    serversNames[a] = Settings.servers[a].split(", ")[0];
                }

                return serversNames[BaseUtils.getPropertyInt("server")];
            } else
            {
                return error;
            }
        } catch (Exception e)
        {
            return error;
        }
    }
}
