package com.epam.training.service;

import java.io.PrintWriter;


public class SysoutMenuLister extends PrintWriterMenuLister {

    public SysoutMenuLister() {
        super(new PrintWriter(System.out, true));
    }
}
