package com.example.testrelocatedesctop.nativelib;

public class CreateDescriptionFile {

    static {
        System.loadLibrary("nativelib");
    }
    public native void NTFSDoc(String path);
}
