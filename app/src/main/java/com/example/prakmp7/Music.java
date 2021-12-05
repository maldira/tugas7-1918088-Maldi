package com.example.prakmp7;

public class Music {
    private String _id, _judul, _artis;
    public Music (String id, String judul, String artis) {
        this._id = id;
        this._judul = judul;
        this._artis = artis;
    }
    public Music() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_judul() {
        return _judul;
    }
    public void set_judul(String _judul) {
        this._judul = _judul;
    }
    public String get_artis() {
        return _artis;
    }
    public void set_artis(String _artis) {
        this._artis = _artis;
    }
}

