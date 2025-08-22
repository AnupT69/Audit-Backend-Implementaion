package com.auditbackend.Audit.Backend.Implementaion.Services;

import java.util.List;

import com.auditbackend.Audit.Backend.Implementaion.Models.Note;

public interface NoteService {
	
	Note createNoteForUser(String username,String content);
	
	Note updateNoteForUser(Long noteId,String content,String username);
	
	void deleteNoteForUser(Long noteId,String username);
	
	List<Note> getNotesForUser(String username);
	

}
