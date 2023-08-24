package Controller;

import Model.Participant;
import View.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ParticipantController {
    public ArrayList<Participant> participantList = new ArrayList<>();
    Menu menu = new Menu();

    // Fungsi untuk Update alamat participant
    public void updateParticipantAddress() {
        // Memeriksa apakah daftar peserta kosong
        if (participantList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Daftar peserta kosong.");
        } else {
            // Mendapatkan daftar peserta yang aktif
            ArrayList<Participant> activeParticipants = getActiveParticipants();

            // Memeriksa apakah tidak ada peserta yang aktif
            if (activeParticipants.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tidak ada peserta yang aktif.");
            } else {
                String participantIndices = "Daftar Peserta:\n";
                int index = 1;

                // Membuat daftar peserta aktif beserta indeksnya
                for (Participant participant : activeParticipants) {
                    participantIndices += index + ": " + participant.getName() + "\n";
                    index++;
                }

                // Meminta input indeks peserta yang ingin diupdate alamatnya
                String input = menu.getInput(participantIndices +
                        "Input indeks Peserta yang ingin mengupdate alamat:");

                if (input != null && !input.isEmpty() && input.matches("\\d+")) {
                    int selectedUserIndex = Integer.parseInt(input) - 1;

                    // Memeriksa apakah indeks yang dipilih valid
                    if (selectedUserIndex >= 0 && selectedUserIndex < activeParticipants.size()) {
                        Participant selectedParticipant = activeParticipants.get(selectedUserIndex);

                        // Menampilkan konfirmasi update alamat
                        int response = JOptionPane.showConfirmDialog(
                                null,
                                "Apakah Anda yakin ingin mengupdate alamat peserta " + selectedParticipant.getName() + "?",
                                "Konfirmasi update",
                                JOptionPane.YES_NO_OPTION
                        );

                        if (response == JOptionPane.YES_OPTION) {
                            // Meminta input alamat baru dan mengupdate alamat peserta
                            String newAddress = menu.getInput("Input Alamat Baru:");
                            if (newAddress != null) {
                                selectedParticipant.setAddress(newAddress);
                                JOptionPane.showMessageDialog(null, "Alamat peserta diupdate!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Update dibatalkan.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Indeks tidak valid.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Input indeks tidak valid.");
                }
            }
        }
    }

    // Fungsi untuk Update nomor telepon participant
    public void updateParticipantPhoneNumber() {
        // Memeriksa apakah daftar peserta kosong
        if (participantList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Daftar peserta kosong.");
        } else {
            // Mengambil daftar peserta yang aktif
            ArrayList<Participant> activeParticipants = getActiveParticipants();

            // Memeriksa apakah ada peserta yang aktif
            if (activeParticipants.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tidak ada peserta yang aktif.");
            } else {
                // Menyiapkan daftar peserta aktif beserta indeksnya untuk ditampilkan dalam dialog
                String participantIndices = "Daftar Peserta:\n";
                int index = 1;
                for (Participant participant : activeParticipants) {
                    participantIndices += index + ": " + participant.getName() + "\n";
                    index++;
                }

                // Meminta pengguna memilih indeks peserta yang akan diupdate nomor teleponnya
                String input = menu.getInput(participantIndices +
                        "Input indeks Peserta yang ingin mengupdate nomor telepon:");

                // Memeriksa apakah input valid
                if (input != null && !input.isEmpty() && input.matches("\\d+")) {
                    int selectedUserIndex = Integer.parseInt(input) - 1;

                    // Memeriksa apakah indeks yang dipilih valid
                    if (selectedUserIndex >= 0 && selectedUserIndex < activeParticipants.size()) {
                        Participant selectedParticipant = activeParticipants.get(selectedUserIndex);

                        // Menampilkan konfirmasi untuk update nomor telepon
                        int response = JOptionPane.showConfirmDialog(
                                null,
                                "Apakah Anda yakin ingin mengupdate nomor telepon peserta " + selectedParticipant.getName() + "?",
                                "Konfirmasi update",
                                JOptionPane.YES_NO_OPTION
                        );

                        // Memeriksa apakah pengguna menyetujui update
                        if (response == JOptionPane.YES_OPTION) {
                            // Meminta pengguna memasukkan nomor telepon baru
                            String newPhoneNumber = menu.getInput("Input Nomor Telepon Baru:");

                            // Memeriksa apakah input nomor telepon baru valid
                            if (newPhoneNumber != null) {
                                // Mengupdate nomor telepon peserta yang dipilih
                                selectedParticipant.setPhoneNumber(newPhoneNumber);
                                JOptionPane.showMessageDialog(null, "Nomor telepon peserta diupdate!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Update dibatalkan.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Indeks tidak valid.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Input indeks tidak valid.");
                }
            }
        }
    }

    // Fungsi untuk hapus participant
    public void deleteParticipant() {
        // Memeriksa apakah daftar peserta kosong
        if (participantList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Daftar peserta kosong.");
        } else {
            // Mengambil daftar peserta yang aktif
            ArrayList<Participant> activeParticipants = getActiveParticipants();

            // Memeriksa apakah ada peserta yang aktif
            if (activeParticipants.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tidak ada peserta yang aktif.");
            } else {
                // Menyiapkan daftar peserta aktif beserta indeksnya untuk ditampilkan dalam dialog
                String participantIndices = "Daftar Peserta:\n";
                int index = 1;
                for (Participant participant : activeParticipants) {
                    participantIndices += index + ": " + participant.getName() + "\n";
                    index++;
                }

                // Meminta pengguna memilih indeks peserta yang akan dihapus
                String input = menu.getInput(participantIndices + "Input indeks Peserta yang ingin dihapus:");

                // Memeriksa apakah input valid
                if (input != null && !input.isEmpty() && input.matches("\\d+")) {
                    int selectedUserIndex = Integer.parseInt(input) - 1;

                    // Memeriksa apakah indeks yang dipilih valid
                    if (selectedUserIndex >= 0 && selectedUserIndex < activeParticipants.size()) {
                        Participant selectedParticipant = activeParticipants.get(selectedUserIndex);

                        // Menampilkan konfirmasi untuk menghapus peserta
                        int response = JOptionPane.showConfirmDialog(
                                null,
                                "Apakah Anda yakin ingin menghapus peserta " + selectedParticipant.getName() + "?",
                                "Konfirmasi Hapus",
                                JOptionPane.YES_NO_OPTION
                        );

                        // Memeriksa apakah pengguna menyetujui penghapusan
                        if (response == JOptionPane.YES_OPTION) {
                            // Menandai peserta sebagai tidak aktif
                            selectedParticipant.setActive(false);

                            JOptionPane.showMessageDialog(null, "Peserta Dihapus.");

                            // Menampilkan daftar peserta jika daftar tidak kosong
                            if (!participantList.isEmpty()) {
                                showParticipants();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Hapus dibatalkan.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Indeks tidak valid.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Input indeks tidak valid.");
                }
            }
        }
    }

    // Fungsi untuk menambahkan info participant
    public void addParticipant() {
        Participant participant = new Participant();

        String name = menu.getInput("Input Nama Peserta:");
        if (name != null) {
            participant.setName(name);

            String address = menu.getInput("Input Alamat Peserta:");
            if (address != null) {
                participant.setAddress(address);

                String phoneNumber = menu.getInput("Input Nomor Telepon Peserta:");
                if (phoneNumber != null && isValidPhoneNumber(phoneNumber)) {
                    participant.setPhoneNumber(phoneNumber);
                    participant.setActive(true);
                    participantList.add(participant);

                    JOptionPane.showMessageDialog(null, "Peserta ditambahkan!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nomor Telepon tidak valid.");
                }
            }
        }
    }

    // Fungsi untuk memvalidasi nomor telepon
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Sesuaikan dengan aturan validasi nomor telepon yang Anda inginkan
        // Contoh: valid jika hanya mengandung angka dan panjangnya 10-15 digit
        return phoneNumber.matches("\\d+") && phoneNumber.length() >= 10 && phoneNumber.length() <= 15;
    }

    // Fungsi untuk menampilkan daftar participant
    public void showParticipants() {
        if (participantList.isEmpty()) {
            // Jika daftar peserta kosong, tampilkan pesan bahwa daftar peserta kosong
            JOptionPane.showMessageDialog(null, "Daftar Peserta Kosong.");
        } else {
            // Nama-nama kolom yang akan ditampilkan dalam tabel
            String[] columnNames = {"Indeks", "Nama", "Alamat", "Nomor Telepon"};

            // Membuat model tabel dengan kolom-kolom yang telah ditentukan
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            int displayedIndex = 1;

            // Menambahkan baris-baris peserta ke dalam tabel
            for (Participant participant : participantList) {
                if (participant.isActive()) {
                    // Menambahkan baris baru dengan informasi peserta
                    tableModel.addRow(new Object[]{displayedIndex, participant.getName(), participant.getAddress(),
                            participant.getPhoneNumber()});

                    displayedIndex++;
                }
            }

            // Membuat tabel dari model yang telah dibuat
            JTable table = new JTable(tableModel);

            // Membuat panel scrollable untuk menampilkan tabel
            JScrollPane scrollPane = new JScrollPane(table);

            // Membuat panel untuk menampilkan pesan dialog dengan tabel
            JPanel panel = new JPanel();
            panel.add(scrollPane);

            // Menampilkan pesan dialog dengan panel yang berisi tabel
            JOptionPane.showMessageDialog(null, panel,
                    "Daftar Peserta", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // Fungsi untuk mendapatkan daftar peserta yang aktif
    private ArrayList<Participant> getActiveParticipants() {
        ArrayList<Participant> activeParticipants = new ArrayList<>();
        for (Participant participant : participantList) {
            // Memeriksa apakah peserta aktif, jika iya, tambahkan ke daftar peserta aktif
            if (participant.isActive()) {
                activeParticipants.add(participant);
            }
        }
        return activeParticipants;
    }
}