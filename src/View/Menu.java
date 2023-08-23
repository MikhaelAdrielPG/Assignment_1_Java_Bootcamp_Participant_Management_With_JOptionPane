package View;

import Controller.ParticipantController;

import javax.swing.*;

// Kelas Menu untuk mengatur antarmuka pengguna
public class Menu {
    // Fungsi utama untuk menampilkan menu utama
    public void mainMenu() {
        ParticipantController app = new ParticipantController(); // Membuat instansi dari kelas ParticipantController
        boolean continueLoop = true;

        // Loop utama untuk menu
        while (continueLoop) {
            String menu = "Menu:\n" +
                    "1. Tambah Peserta\n" +
                    "2. Update Nama Peserta\n" +
                    "3. Hapus Peserta\n" +
                    "4. Tampilkan Peserta\n" +
                    "Pilih opsi:";

            String input = getInput(menu);
            if (input == null) {
                // Konfirmasi keluar
                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin keluar dari aplikasi?",
                        "Konfirmasi Keluar",
                        JOptionPane.YES_NO_OPTION
                );

                if (response == JOptionPane.YES_OPTION) {
                    continueLoop = false; // Pengguna menekan "Cancel"
                }
            } else {
                switch (input) {
                    case "1" -> app.addParticipant();
                    case "2" -> app.updateParticipantName();
                    case "3" -> app.deleteParticipant();
                    case "4" -> app.showParticipants();
                    default -> JOptionPane.showMessageDialog(null,
                            "Pilihan tidak valid.");
                }
            }
        }
    }

    // Fungsi untuk mendapatkan input dari pengguna
    public String getInput(String message) {
        String input;
        do {
            input = JOptionPane.showInputDialog(message);
            if (input == null) {
                return null; // Pengguna menekan "Cancel"
            } else if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Input tidak boleh kosong.",
                        "Peringatan",JOptionPane.WARNING_MESSAGE);
            }
        } while (input.isEmpty());
        return input;
    }
}