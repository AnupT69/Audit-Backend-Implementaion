package com.auditbackend.Audit.Backend.Implementaion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auditbackend.Audit.Backend.Implementaion.CustomAnnotation.Auditable;
import com.auditbackend.Audit.Backend.Implementaion.Models.Note;
import com.auditbackend.Audit.Backend.Implementaion.Services.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@PostMapping
	@Auditable(action = "CREATE NOTE",entityType = "Note",module = "Note Management")
	public Note createNote(@RequestBody String content,@AuthenticationPrincipal UserDetails userDetails) {
		String username = userDetails.getUsername();
		return noteService.createNoteForUser(username, content);
	}
	
	@GetMapping

	public List<Note> getUserNotes(@AuthenticationPrincipal UserDetails userDetails){
		String username = userDetails.getUsername();
		return noteService.getNotesForUser(username);
	}
	
	 @PutMapping("/{noteId}")
	 @Auditable(action = "UPDATE NOTE",entityType = "Note",module = "Note Management")
	    public Note updateNote(@PathVariable Long noteId,
	                           @RequestBody String content,
	                           @AuthenticationPrincipal UserDetails userDetails) {
	        String username = userDetails.getUsername();
	        return noteService.updateNoteForUser(noteId, content, username);
	    }

	    @DeleteMapping("/{noteId}")
	    @Auditable(action = "DELETE NOTE",entityType = "Note",module = "Note Management")
	    public void deleteNote(@PathVariable Long noteId,
	                           @AuthenticationPrincipal UserDetails userDetails) {
	        String username = userDetails.getUsername();
	        noteService.deleteNoteForUser(noteId, username);
	    }
	

}
