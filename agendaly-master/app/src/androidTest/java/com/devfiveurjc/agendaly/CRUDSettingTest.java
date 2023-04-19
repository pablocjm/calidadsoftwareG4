package com.devfiveurjc.agendaly;

import com.devfiveurjc.agendaly.crud.CRUDSetting;


import org.junit.Test;
import org.junit.Assert;
import org.junit.Assert.*;

public class CRUDSettingTest {
    CRUDSetting crudSetting = new CRUDSetting();

    @Test
    public void TestIsEmpty (){
        Assert.assertEquals(false, crudSetting.isEmpty());
    }
}

