package com.example.remidi;

import java.util.ArrayList;

public class ManajerPerpustakaan {
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public ArrayList<Buku> getSemuaBuku() {
        return daftarBuku;
    }

    public void pinjamBuku(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < daftarBuku.size()) {
            daftarBuku.get(index).setTersedia(false);
        } else {
            throw new IndexOutOfBoundsException("Index tidak valid");
        }
    }

    public void kembalikanBuku(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < daftarBuku.size()) {
            daftarBuku.get(index).setTersedia(true);
        } else {
            throw new IndexOutOfBoundsException("Index tidak valid");
        }
    }
}
