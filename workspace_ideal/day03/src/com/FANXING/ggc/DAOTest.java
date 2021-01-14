package com.FANXING.ggc;

import org.junit.Test;

public class DAOTest {
    @Test
    public void test1(){
        CustomeDAO dao1 = new CustomeDAO();
        dao1.add(new Custome());
        dao1.getForList(10);

        studentDAO dao2 = new studentDAO();
        Stuent index = dao2.getIndex(1);


    }
}
