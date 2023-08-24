package View;

import Controller.ParticipantController;

import javax.swing.*;

public class Menu {

    // Fungsi untuk menu utama
    public void mainMenu() {
        // Membuat objek controller untuk mengatur interaksi dengan peserta
        ParticipantController app = new ParticipantController();
        boolean continueLoop = true;

        // Memulai loop menu
        while (continueLoop) {
            String menu = "Menu:\n" +
                    "1. Tambah Peserta\n" +
                    "2. Update Alamat Peserta\n" +
                    "3. Update Nomor Telepon Peserta\n" +
                    "4. Hapus Peserta\n" +
                    "5. Tampilkan Peserta\n" +
                    "Pilih opsi:";

            // Meminta input pilihan menu dari pengguna
            String input = getInput(menu);
            if (input == null) {
                // Jika input adalah null, tampilkan konfirmasi keluar
                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin keluar dari aplikasi?",
                        "Konfirmasi Keluar",
                        JOptionPane.YES_NO_OPTION
                );

                // Jika pengguna memilih keluar, hentikan loop
                if (response == JOptionPane.YES_OPTION) {
                    continueLoop = false;
                }
            } else {
                // Memproses pilihan menu yang dipilih pengguna
                switch (input) {
                    case "1" -> app.addParticipant();
                    case "2" -> app.updateParticipantAddress();
                    case "3" -> app.updateParticipantPhoneNumber();
                    case "4" -> app.deleteParticipant();
                    case "5" -> app.showParticipants();
                    default -> JOptionPane.showMessageDialog(null,
                            "Pilihan tidak valid.");
                }
            }
        }
    }

    // Fungsi untuk input user pada saat tambah, update, hapus participant
    public String getInput(String message) {
        String input;
        do {
            // Meminta input dari pengguna menggunakan dialog input
            input = JOptionPane.showInputDialog(message);
            if (input == null) {
                // Jika input adalah null, kembalikan null
                return null;
            } else if (input.isEmpty()) {
                // Jika input kosong, tampilkan peringatan
                JOptionPane.showMessageDialog(null, "Input tidak boleh kosong.",
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        } while (input.isEmpty());
        // Mengembalikan input yang diterima
        return input;
    }
}