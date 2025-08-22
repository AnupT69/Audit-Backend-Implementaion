package com.auditbackend.Audit.Backend.Implementaion.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auditbackend.Audit.Backend.Implementaion.CustomAnnotation.Auditable;
import com.auditbackend.Audit.Backend.Implementaion.Models.Note;
import com.auditbackend.Audit.Backend.Implementaion.Services.NoteService;
import com.auditbackend.Audit.Backend.Implementaion.repositories.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	private NoteRepository noteRepo;
	

	@Override
	@Auditable(action = "CREATE NOTE",entityType = "Note",module = "Note Management")
	public Note createNoteForUser(String username, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        Note savedNote = noteRepo.save(note);
        
		return savedNote;
	}

	@Override
	public Note updateNoteForUser(Long noteId,String content, String username) {
		Note note = noteRepo.findById(noteId).orElseThrow(()->new RuntimeException("Note not found"));
		note.setContent(content);
		Note updatedNote = noteRepo.save(note);
		return updatedNote;
	}

	@Override
	public void deleteNoteForUser(Long noteId, String username) {
		Note note = noteRepo.findById(noteId).orElseThrow(()->new RuntimeException("Note not found"));
		noteRepo.delete(note);
		
	}

	@Override
	public List<Note> getNotesForUser(String username) {
		List<Note> personalNotes = noteRepo.findByOwnerUsername(username);
		
		return personalNotes;
	}
	

}
