package com.example.remidi;

public class Buku implements ItemPerpustakaan {
    private String judul;
    private String penulis;
    private boolean tersedia;

    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
        this.tersedia = true;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    @Override
    public String getInfo() {
        return judul + " oleh " + penulis + (tersedia ? " (Tersedia)" : " (Dipinjam)");
    }
}
