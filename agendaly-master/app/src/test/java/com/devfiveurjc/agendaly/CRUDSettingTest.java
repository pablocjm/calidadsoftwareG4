package com.devfiveurjc.agendaly;

import com.devfiveurjc.agendaly.crud.CRUDSetting;


import org.junit.Test;
import org.junit.Assert.*;

public class CRUDSettingTest {
    CRUDSetting crudSetting = new CRUDSetting();
    @Test
    public boolean testIsEmpty (){
        boolean empty = false;
        return assertEquals(empty, crudSetting.isEmpty());
    }


}

