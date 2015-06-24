package com.denvys5;

import net.launcher.components.Frame;
import net.launcher.run.Settings;
import net.launcher.utils.BaseUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.launcher.utils.BaseUtils.*;
import java.util.ArrayList;

import static net.launcher.utils.BaseUtils.getPropertyInt;

/**
 * Created by DAVis on 29.05.2015.
 */
public class Menu {
    public static ArrayList<String> modlist = new ArrayList<String>();
    public static ArrayList<String> selectedModlist = new ArrayList<String>();

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
