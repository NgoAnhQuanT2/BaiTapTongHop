package com.example.btth2;

public class Music {
    private String Music;
    private int Hinh;

    public Music(String music, int hinh) {
        Music = music;
        Hinh = hinh;
    }

    public String getMusic() {
        return Music;
    }

    public void setMusic(String music) {
        Music = music;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
