# Android Notes App

Golden Notes is a clean and modern **Android Notes Application** built using **Java and MVVM architecture**.
The app allows users to easily **create, update, and delete notes** with a smooth user experience and elegant golden themed UI.

This project demonstrates practical usage of **Room Database, ViewModel, LiveData, Data Binding, and RecyclerView** in Android development.

---

# 🚀 Features

✔️ Create Notes (Title + Description)
✔️ Update Existing Notes
✔️ Delete Notes with **Swipe Gesture**
✔️ Local Data Storage using **Room Database**
✔️ Clean UI with **CardView Layout**
✔️ RecyclerView for dynamic note listing
✔️ MVVM Architecture for scalable development
✔️ Data Binding for efficient UI interaction

---

# 🏗️ Tech Stack

* **Language:** Java
* **Architecture:** MVVM (Model View ViewModel)
* **Database:** Room Persistence Library
* **UI Components:**

  * RecyclerView
  * CardView
  * ConstraintLayout
* **Jetpack Components:**

  * ViewModel
  * LiveData
  * Data Binding

---

# 📂 Project Architecture

The application follows **MVVM Architecture**:

```
com.example.notesapp

│
├── database
│   ├── NoteDatabase.java
│   ├── NoteDAO.java
│
├── model
│   └── Note.java
│
├── repository
│   └── NoteRepository.java
│
├── viewmodel
│   └── NoteViewModel.java
│
├── adapter
│   └── NotesAdapter.java
│
├── ui
│   ├── MainActivity.java
│   ├── AddNoteActivity.java
│   └── NoteClickHandler.java
│
└── layouts
    ├── activity_main.xml
    ├── activity_add_note.xml
    └── note_list_item.xml
```

---

# 📱 App Screens

### Main Screen

* Displays list of all saved notes
* Swipe left to delete a note
* Floating Action Button to add a new note

### Add Note Screen

* Enter note **title**
* Enter note **description**
* Save the note into the local database

---

# ⚙️ How It Works

1️⃣ User clicks the **Add (+) button**

2️⃣ App opens **AddNoteActivity**

3️⃣ User enters:

* Title
* Description

4️⃣ Data Binding captures the EditText input

5️⃣ ViewModel inserts the note into the **Room Database**

6️⃣ RecyclerView automatically updates using **LiveData**

---

# 🧠 Key Concepts Implemented

* MVVM Architecture
* Room Database CRUD operations
* LiveData observation
* RecyclerView Adapter
* Swipe to Delete using **ItemTouchHelper**
* Data Binding with Click Handlers
* ViewModel lifecycle management

---

# 📦 Installation

Clone the repository:

```bash
git clone https://github.com/yourusername/golden-notes-app.git
```

Open in **Android Studio**

Build and run on emulator or physical device.

---

# 🎯 Future Improvements

* Search Notes
* Dark Mode
* Note Categories
* Cloud Sync
* Rich Text Notes
* Reminder Notifications

---

# 👨‍💻 Author

**Pranajit Banerjee**

Computer Science & Design Student
Dr. B. C. Roy Engineering College

GitHub: https://github.com/yourusername

---

# ⭐ If you like this project

Give it a ⭐ on GitHub and feel free to contribute!

