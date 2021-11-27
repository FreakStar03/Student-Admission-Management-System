import java.io.File;

import Frames.*;
class App{
    public static void main(String args[]){
        LoginFormS StartFrame = new LoginFormS();
        int a = new File(System.getProperty("user.dir") + "/Storage/" + 1 + "/").list().length;
        System.out.println(a);
        StartFrame.setVisible(true);
    }
} 

