package com.denvys5;

import net.launcher.utils.BaseUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAVis on 26.08.2016.
 */
public class FileLoader {


    public static List<String> downloadclient(String client){
        List<String> files = new ArrayList<>();
        BaseUtils.setProperty(client + "Zip", true);
        files.add("/"+BaseUtils.getClientName()+".zip");
        return files;
    }

}
