package com.example.prm392_finalproject;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class NoteDetailsActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageButton saveNoteBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_details);

        titleEditText = findViewById(R.id.notes_title_text);
        contentEditText = findViewById(R.id.notes_content_text);
        saveNoteBtn = findViewById(R.id.save_note_btn);

        saveNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteTitle = titleEditText.getText().toString();
                String noteContent = contentEditText.getText().toString();
                if (noteTitle == null || noteTitle.isEmpty()){
                    titleEditText.setError("Title is required!");
                }
                Note note = new Note();
                note.setTitle(noteTitle);
                note.setContent(noteContent);
                note.setTimestamp(Timestamp.now());
            }
        });
    }

//    void saveNoteToFireBase(Note note){
//        DocumentReference documentReference;
//        documentReference = Utility.getCollectionReferenceForNotes().document();
//        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    // note is added
//                    Utility.showToast(NoteDetailsActivity.this, "Note added successfully!");
//                } else{
//                    Utility.showToast(NoteDetailsActivity.this, "Failed while adding note!");
//                }
//            }
//        });
    }


