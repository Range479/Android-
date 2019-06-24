package com.example.myrelatives;

public class GetRelatives {
    static String getRelatives(String s1, String s2){
        String s;
        if(s1.equals("爸爸")){
            if(s2.equals("爸爸"))
                s = "爸爸的爸爸是爷爷";
            else
                s = "爸爸的妈妈是奶奶";
        }
        else{
            if(s2.equals("爸爸"))
                s = "妈妈的爸爸是外公";
            else
                s = "妈妈的妈妈是外婆";
        }
        return s;
    }
}
