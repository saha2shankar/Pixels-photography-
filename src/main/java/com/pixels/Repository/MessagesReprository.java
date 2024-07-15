package com.pixels.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixels.models.Messages;

public interface MessagesReprository extends JpaRepository<Messages, Integer>{

}
