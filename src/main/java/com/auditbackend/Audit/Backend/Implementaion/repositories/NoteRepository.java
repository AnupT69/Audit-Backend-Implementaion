package com.auditbackend.Audit.Backend.Implementaion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditbackend.Audit.Backend.Implementaion.Models.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
	
	List<Note> findByOwnerUsername(String ownerUsername);

}
