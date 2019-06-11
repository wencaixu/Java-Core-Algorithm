package com.tools.poi;


public class NoisyData {

    public static final String[] NOISY_DATA = {"tpscroll","ward_sentry","ward_observer","smoke_of_deceit","dust","tango","tango_single","branches"};

    public boolean contain(String item){
        boolean flag = false;
        for(int i = 0; i < NOISY_DATA.length; i++){
            if(item != null && item.equals(NOISY_DATA[i])){
                flag = true;
            }
        }
        return flag;
    }
}
