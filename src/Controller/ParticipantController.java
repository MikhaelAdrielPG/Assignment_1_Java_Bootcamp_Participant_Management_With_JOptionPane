package Controller;

import Model.Participant;
import View.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


// Kelas untuk mengatur logika aplikasi peserta bootcamp
public class ParticipantController {
    public ArrayList<Participant> participantList = new ArrayList<>(); // ArrayList untuk menyimpan peserta
    Menu menu = new Menu();

    // Fungsi untuk memperbarui nama peserta
    public void updateParticipantName() {
        if (participantList.isEmpty()) {
            // Jika daftar peserta kosong, tampilkan pesan bahwa daftar peserta kosong.
            JOptionPane.showMessageDialog(null, "Daftar peserta kosong.");
        } else {
            String participantIndices = "Daftar Peserta:\n";
            int index = 1;
            for (Participant participant : participantList) {
                // Menambahkan indeks dan nama peserta ke string pesan.
                participantIndices += index + ": " + participant.getName() + "\n";
                index++;
            }

            String input = menu.getInput(participantIndices +
                    "Input indeks Peserta yang ingin diupdate:");

            if (!input.isEmpty() && input.matches("\\d+")) {
                // Mengkonversi input menjadi indeks yang sesuai dalam ArrayList.
                int selectedUserIndex = Integer.parseInt(input) - 1;

                if (selectedUserIndex >= 0 && selectedUserIndex < participantList.size()) {
                    Participant selectedParticipant = participantList.get(selectedUserIndex);

                    int response = JOptionPane.showConfirmDialog(
                            null,
                            "Apakah Anda yakin ingin update nama peserta " + selectedParticipant.getName() + "?",
                            "Konfirmasi update",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (response == JOptionPane.YES_OPTION) {
                        String newName = menu.getInput("Input Nama Baru:");
                        if (newName != null) {
                            // Mengubah nama peserta dan menampilkan pesan berhasil.
                            selectedParticipant.setName(newName);
                            JOptionPane.showMessageDialog(null, "Nama peserta diupdate!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Update dibatalkan.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Indeks tidak valid.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Input indeks tidak valida.");
            }
        }
    }

    // Fungsi untuk menghapus peserta
    public void deleteParticipant() {
        if (participantList.isEmpty()) {
            // Jika daftar peserta kosong, tampilkan pesan bahwa daftar peserta kosong.
            JOptionPane.showMessageDialog(null, "Daftar peserta kosong.");
        } else {
            String participantIndices = "Daftar Peserta:\n";
            int index = 1;
            for (Participant participant : participantList) {
                // Menambahkan indeks dan nama peserta ke string pesan.
                participantIndices += index + ": " + participant.getName() + "\n";
                index++;
            }

            String input = menu.getInput(participantIndices +
                    "Input indeks Peserta yang ingin dihapus:");

            if (!input.isEmpty() && input.matches("\\d+")) {
                // Mengkonversi input menjadi indeks yang sesuai dalam ArrayList.
                int selectedUserIndex = Integer.parseInt(input) - 1;

                if (selectedUserIndex >= 0 && selectedUserIndex < participantList.size()) {
                    Participant selectedParticipant = participantList.get(selectedUserIndex);

                    int response = JOptionPane.showConfirmDialog(
                            null,
                            "Apakah Anda yakin ingin menghapus peserta " + selectedParticipant.getName() + "?",
                            "Konfirmasi Hapus",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (response == JOptionPane.YES_OPTION) {
                        // Menandai peserta sebagai tidak aktif dan menghapusnya dari daftar.
                        selectedParticipant.setActive(false);
                        JOptionPane.showMessageDialog(null, "Peserta Dihapus.");

                        // Hapus peserta dari daftar
                        participantList.remove(selectedParticipant);

                        // Cek jika ada peserta yang tersisa dan tampilkan daftar peserta.
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

    // Metode untuk menambahkan peserta
    public void addParticipant() {
        Participant participant = new Participant();

        String name = menu.getInput("Input Nama Peserta:");
        if (name != null) {
            participant.setName(name); // set nama peserta

            String address = menu.getInput("Input Alamat Peserta:");
            if (address != null) {
                participant.setAddress(address); // set alamat peserta

                String phoneNumber = menu.getInput("Input Nomor Telepon Peserta:");
                if (phoneNumber != null) {
                    participant.setPhoneNumber(phoneNumber); // set nomor telepon peserta

                    participant.setActive(true); // tandai peserta sebagai aktif
                    participantList.add(participant); // Menambahkan peserta ke daftar

                    // Menampilkan pesan sukses
                    JOptionPane.showMessageDialog(null, "Peserta ditambahkan!");
                }
            }
        }
    }


    // Metode untuk menampilkan peserta dalam dialog
    public void showParticipants() {
        if (participantList.isEmpty()) {
            // Jika daftar peserta kosong, tampilkan pesan bahwa tidak ada peserta tersedia
            JOptionPane.showMessageDialog(null, "Daftar Peserta Kosong.");
        } else {
            // Jika daftar peserta tidak kosong, buat model tabel dengan kolom-kolom yang sesuai
            String[] columnNames = {"Indeks", "Nama", "Alamat", "Nomor Telepon"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            int displayedIndex = 1; // init index

            // looping daftar peserta
            for (Participant participant : participantList) {
                if (participant.isActive()) { // Hanya tampilkan peserta yang aktif
                    tableModel.addRow(new Object[]{displayedIndex, participant.getName(), participant.getAddress(),
                            participant.getPhoneNumber()});

                    displayedIndex++; // counter index
                }
            }

            // membuat tabel
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel panel = new JPanel();
            panel.add(scrollPane);

            // Tampilkan dialog dengan tabel daftar peserta
            JOptionPane.showMessageDialog(null, panel,
                    "Daftar Peserta", JOptionPane.PLAIN_MESSAGE);
        }
    }
}