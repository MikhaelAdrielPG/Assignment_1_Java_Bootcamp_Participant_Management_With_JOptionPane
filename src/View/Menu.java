package View;

import Controller.ParticipantController;
import Model.Participant;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Participant> participantList = new ArrayList<>();

    public List<Participant> getParticipantList() {
        return participantList;
    }

    // Fungsi untuk menu utama
    public void mainMenu() {
        // Membuat objek controller untuk mengatur interaksi dengan peserta
        ParticipantController app = new ParticipantController();
        boolean continueLoop = true;

        // Memulai loop menu
        while (continueLoop) {
            String menu = "Menu:\n" +
                    "1. Tambah Peserta\n" +
                    "2. Update Nama Peserta\n" +
                    "3. Update Alamat Peserta\n" +
                    "4. Update Nomor Telepon Peserta\n" +
                    "5. Hapus Peserta\n" +
                    "6. Tampilkan Peserta\n" +
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
                    case "2" -> app.updateParticipantName();
                    case "3" -> app.updateParticipantAddress();
                    case "4" -> app.updateParticipantPhoneNumber();
                    case "5" -> app.deleteParticipant();
                    case "6" -> app.showParticipants();
                    default -> JOptionPane.showMessageDialog(null, "Input tidak valid.",
                            "Peringatan", JOptionPane.WARNING_MESSAGE);
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