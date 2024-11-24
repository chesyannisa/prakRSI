package src.main.java.com.controllers;

import src.main.java.com.ui.HalamanProfilUI;
import java.sql.SQLException;
import src.main.java.com.models.User;
import src.main.java.com.providers.DatabaseProvider;
import src.main.java.com.ui.HalamanEditProfilUI;

public class ProfileController {
    private DatabaseProvider databaseProvider;

    public ProfileController() {
        this.databaseProvider = new DatabaseProvider();
    }

    // Method untuk menampilkan halaman profil
    public void tampilkanHalamanProfil() {
        new HalamanProfilUI();
    }

    // Method untuk menampilkan halaman edit profil
    public void tampilkanHalamanEditProfil(User user) {
        new HalamanEditProfilUI(user);
    }

    // Method untuk mendapatkan data user dari database
    public User getUserData(String username) {
        try {
            return databaseProvider.getUserByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method untuk memperbarui data user di database
    public void updateUser(User user) throws SQLException {
        databaseProvider.updateUser(user);
    }
}